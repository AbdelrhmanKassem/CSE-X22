package classes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import interfaces.IPlayerFinder;





public class PlayerFinder implements IPlayerFinder {

	int squares,Xmin,Xmax,Ymin,Ymax;
	
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		if (photo==null || photo.length == 0 ) return null;
		
		ArrayList<Point> resultList = new ArrayList<Point>();
		int [][] locations = new int [photo.length][photo[0].length()];
		fillLocations(locations,photo,team);
		for(int i=0;i<photo.length;i++) {
			for (int j=0;j<photo[0].length();j++) {
				squares=0;Xmin=j;Xmax=j;Ymin=i;Ymax=i;
				if (locations[i][j]!=0) {
					borderCheck(locations,i,j);
					int totalArea=squares*4;
					if(totalArea<threshold)
						continue;
					else {
						int x = Xmin+Xmax+1;
						int y=Ymin+Ymax+1;
						resultList.add(new Point(x,y));
					}
				}
					
			}
		}
		Point [] points = new Point [resultList.size()];
		listToSortedArray(resultList,points);
		
		return points;
		
		
		
	}


	// Sparse-Like array indicating if there is a player pixel in x,y coordinates of the photo
	public void fillLocations (int [][] locations ,String[] photo,int team){
		for(int i=0;i<photo.length;i++) {
			for (int j=0;j<photo[0].length();j++) {
				char c=photo[i].charAt(j);
				if (c-'0'==team)
					locations[i][j]=1;
		
			}
		}
	}
	

	public void borderCheck(int[][] locations,int i,int j) {
		int n=locations.length,m=locations[0].length;
		locations[i][j]=0;
		squares++;
		
		//Check to The Right
		if (j<m-1 && locations[i][j+1]>0) {
			if(j+1>Xmin) 
				Xmin=j+1;
			borderCheck(locations,i,j+1);
		}
		//Check to The Left
		if (j>0 && locations[i][j-1]>0 ) {
			if(j-1<Xmax) 
				Xmax=j-1;
			borderCheck(locations,i,j-1);
		}
		//Check Down
		if (i<n-1 && locations[i+1][j]>0) {
			if(i+1>Ymin) 
				Ymin=i+1;
			borderCheck(locations,i+1,j);
		}
		//Check Up
		if (i>0 && locations[i-1][j]>0 ) {
			if(i-1<Ymax) 
				Ymax=i-1;
			borderCheck(locations,i-1,j);
		}
		
	}
	
	public void listToSortedArray (ArrayList<Point> list , Point [] pts){
        for (int i = 0; i < list.size(); i++) { 
        	pts[i] = list.get(i); 
        } 	 
	 
		// Sorting The array Using Arrays.Sort But With a new comparator for X then Y
		Arrays.sort(pts, new Comparator<Point>() {
		    public int compare(Point a, Point b) {
		        int xComp = Integer.compare(a.x, b.x);
		        if(xComp == 0)
		            return Integer.compare(a.y, b.y);
		        else
		            return xComp;
		    }
		});
	}

}
