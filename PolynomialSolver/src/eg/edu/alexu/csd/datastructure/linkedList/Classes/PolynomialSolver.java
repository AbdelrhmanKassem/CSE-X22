package eg.edu.alexu.csd.datastructure.linkedList.Classes;
import eg.edu.alexu.csd.datastructure.linkedList.Interfaces.IPolynomialSolver;
import java.awt.Point;


public class PolynomialSolver implements IPolynomialSolver{
	
	private DLinkedList a = new DLinkedList(), b = new DLinkedList(),c = new DLinkedList(), r = new DLinkedList();	
	
	

	
	public void setPolynomial(char poly, int[][] terms) {
		terms = sort(terms);
		if(poly=='A') {
			if(!a.isEmpty()) {a.clear();}
			for (int i = 0; i < terms.length; i++) {
				a.add(new Point(terms[i][0], terms[i][1]));
		 	   }
			} 
		else if (poly == 'B') {
			if (!b.isEmpty()) {
				b.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				b.add(new Point(terms[i][0], terms[i][1]));
			}
		}
		
		else if (poly == 'C') 
		{			
			if (!c.isEmpty()) {
				c.clear();
			}
			for (int i = 0; i < terms.length; i++) {
			c.add(new Point(terms[i][0], terms[i][1]));
			}
		}else if (poly == 'R') 
		{			
			if (!r.isEmpty()) {
				r.clear();
			}
			for (int i = 0; i < terms.length; i++) {
			r.add(new Point(terms[i][0], terms[i][1]));
			}
		}else
			throw new IllegalArgumentException("Please Type A Valid Character");
	}
	
	
	
	public int[][] sort (int[][] terms){
		for (int i = 0; i < terms.length; i++) {
			for (int j = 0; j < terms.length - 1 - i; j++) 
			{
				if (terms[j][1] < terms[j + 1][1]) 
				{
					int temp = terms[j][1];
					terms[j][1] = terms[j+1][1];
					terms[j+1][1] = temp;
					temp = terms[j][0];
					terms[j][0] = terms[j+1][0];
					terms[j+1][0] = temp;
				}
		   }
		}
		return terms;
	}
	
	
	public String print(char poly) {
		DLinkedList k = new DLinkedList();
		if (poly == 'A') {k = a;} 
		else if (poly == 'B') {k = b;}
		else if (poly == 'C') {k = c;} 
		else if (poly == 'R') {k = r;}
		else {	throw new IllegalArgumentException("Please Type A Valid Character"); }
		if (k.isEmpty()) {throw new IllegalArgumentException("Choosen Polynomial Is Empty Please Choose Another One");}
		String s="";
		
		for (int i = 0; i < k.size(); i++) {
			Point p = (Point) k.get(i);
			int coef = (int) p.getX();
			int ex = (int) p.getY();
			if (s == "") {
				if (coef == 0) {	s = ""; }
				else if (ex == 0) {	s = s + coef; }
				else if (ex == 1 && coef != 0 && coef != 1 && coef != -1) {
					s = coef + "x";
				} 
				else if (coef == 1 && ex == 1) {	s = "x"; }
				else if (coef == 1) {	s = "x^" + ex; }
				else if (coef == -1) { 	s = "-" + "x^" + ex; }
				else {	s = coef + "x^" + ex;}
				
			}else {
				if (ex == 0 && coef > 0) {
					s = s + "+" + coef;
				} else if (ex == 0 && coef < 0) {
					s = s + coef;
				} else if (ex == 1 && coef > 0 && coef != 1) {
					s = s + "+" + coef + "x";
				} else if (ex == 1 && coef < 0 && coef != -1) {
					s = s + coef + "x";
				} else if (coef == 1 && ex == 1) {
					s = s + "+" + "x";
				} else if (coef == -1 && ex == 1) {
					s = s + "-" + "x";
				} else if (coef == 1) {
					s = s + "+" + "x^" + ex;
				} else if (coef == -1) {
					s = s + "-" + "x^" + ex;
				} else if (coef < 0) {
					s = s + coef + "x^" + ex;
				} else if (coef > 0) {
					s = s + "+" + coef + "x^" + ex;
				}
			}
		}
		if (s.length() == 0) {
			return "0";
		}
		return s; 
		
		}
		
	
    public void clearPolynomial(char poly) {
    	if (poly == 'A' ) {    a.clear(); } 
    	else if (poly == 'B') {b.clear(); }
    	else if (poly == 'C') {c.clear(); }
    	else if (poly == 'R') {r.clear(); }
    	else {
			throw new IllegalArgumentException("Please Type A Valid Character");

		}
    }
    
    
    
    
    
    public float evaluatePolynomial(char poly, float value) {
    	DLinkedList k = new DLinkedList();
		Point p;
		float result = 0.0f;
		if (poly == 'A') { k = a;}
		else if (poly == 'B') { k = b; }
		else if (poly == 'R') { k = r; }
		else if (poly == 'C') { k = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
		if (k.isEmpty()) {
			throw new IllegalArgumentException("Choosen Polynomial Is Empty Please Choose Another One");
		}
          for (int i=0; i<k.size();i++) {
        	  p=(Point)k.get(i);
        	  if (p.y < 0 && value == 0) {
					throw new IllegalArgumentException();
				}
        	  result += p.x * (float)java.lang.Math.pow(value, p.y);
          }
          return result;
    }
    
    
    
    
    
    public int[][] add(char poly1, char poly2){
    	r.clear();
    	DLinkedList first = new DLinkedList(), second = new DLinkedList();
    	if (poly1 == 'A') { first = a;}
		else if (poly1 == 'B') { first = b; }
		else if (poly1 == 'R') { first = r; }
		else if (poly1 == 'C') { first = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (first.isEmpty()) {
    		throw new IllegalArgumentException("First Operand Polynomial Is Empty Please Choose Another One");
		}
    	if (poly2 == 'A') { second = a;}
		else if (poly2 == 'B') { second= b; }
		else if (poly2 == 'R') { second = r; }
		else if (poly2 == 'C') { second = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (second.isEmpty()) {
    		throw new IllegalArgumentException("Second Operand Polynomial Is Empty Please Choose Another One");
		}
    	Point p1, p2, p3;
    	int i = 0, j = 0, z = 0;
    	p1 = (Point) first.get(i);
		p2 = (Point) second.get(j);
		while (p1 != null && p2 != null) {
			
		    if (p1.y > p2.y) {
			r.add(p1);
			i++;
			} else if (p1.y == p2.y) {
			    if(p1.x == (-1 * p2.x)) {
			    	i++;
			    	j++;
			    	z--;
			    }else {
				    p3 = new Point(p1.x + p2.x, p1.y);
		     	    r.add(p3);
			        i++;
			        j++;
			    }
			} else {
			r.add(p2);
			j++;
			}
		z++;
	
		p1 = (Point) first.get(i);
		p2 = (Point) second.get(j);
		
		}
		while (p1 != null) {
		r.add(p1);
		p1 = (Point) first.get(++i);
		z++;
		}
		while (p2 != null) {
			r.add(p2);
			p2 = (Point) second.get(++j);
			z++;
			}
		int[][] result = new int[z][2];
		for (i = 0; i < z; i++) {
			p3 = (Point) r.get(i);
			result[i][0] = p3.x;
			result[i][1] = p3.y;
		}

		return result;
    }
    
    
    
    
    public int[][] subtract(char poly1, char poly2){
    	r.clear();
    	DLinkedList first = new DLinkedList(), second = new DLinkedList();
    	if (poly1 == 'A') { first = a;}
		else if (poly1 == 'B') { first = b; }
		else if (poly1 == 'R') { first = r; }
		else if (poly1 == 'C') { first = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (first.isEmpty()) {
    		throw new IllegalArgumentException("First Operand Polynomial Is Empty Please Choose Another One");
		}
    	if (poly2 == 'A') { second = a;}
		else if (poly2 == 'B') { second= b; }
		else if (poly2 == 'R') { second = r; }
		else if (poly2 == 'C') { second = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (second.isEmpty()) {
    		throw new IllegalArgumentException("Second Operand Polynomial Is Empty Please Choose Another One");
		}
    	Point p1, p2, p3;
    	int i = 0, j = 0, z = 0;
    	p1 = (Point) first.get(i);
		p2 = (Point) second.get(j);
		while (p1 != null && p2 != null) {
			if (p1.y > p2.y) {
				r.add(p1);
				i++;
			} else if (p1.y == p2.y) {
				if (p1.x == p2.x) {
					i++;
					j++;
					z--;
				} else {
				p3 = new Point(p1.x - p2.x, p1.y);
				r.add(p3);
				i++;
				j++;
				}
			} else {
				p3 = new Point(-1 * p2.x, p2.y);
				r.add(p3);
				j++;
			}
			z++;
		
			p1 = (Point) first.get(i);
			p2 = (Point) second.get(j);
			
		}
			while (p1 != null) {
			r.add(p1);
			p1 = (Point) first.get(++i);
			z++;
			}
			while (p2 != null) {
				p2.x = -1 * p2.x;
				r.add(p2);
				p2 = (Point) second.get(++j);
				z++;
				}
			if (z == 0) {
				int[][] result = {{0, 0}};
				p3 = new Point(0, 0);
				r.add(p3);
				return result;
			}
			int[][] result = new int[z][2];
			for (i = 0; i < z; i++) {
				p3 = (Point) r.get(i);
				result[i][0] = p3.x;
				result[i][1] = p3.y;
			}
		
			return result;
    	
    }
    public int[][] multiply(char poly1, char poly2){
    	
    	r.clear();
    	int z=0;
    	DLinkedList all = new     	DLinkedList();
    	DLinkedList  unsort_r= new     	DLinkedList();
    	DLinkedList first = new DLinkedList(), second = new DLinkedList();
    	if (poly1 == 'A') { first = a;}
		else if (poly1 == 'B') { first = b; }
		else if (poly1 == 'R') { first = r; }
		else if (poly1 == 'C') { first = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (first.isEmpty()) {
    		throw new IllegalArgumentException("First Opernad Polynomial Is Empty Please Choose Another One");
		}
    	if (poly2 == 'A') { second = a;}
		else if (poly2 == 'B') { second= b; }
		else if (poly2 == 'R') { second = r; }
		else if (poly2 == 'C') { second = c; }
		else {
			throw new IllegalArgumentException("Please Type A Valid Character");
		}
    	if (second.isEmpty()) {
    		throw new IllegalArgumentException("Second Operand Polynomial Is Empty Please Choose Another One");
		}
    	Point p1, p2, p3 = null;
    	for (int i = 0; i < first.size(); i++) {
			p1 = (Point) first.get(i);
			for (int j = 0; j < second.size(); j++) {
				p2 = (Point) second.get(j);
				p3 = new Point(p1.x * p2.x, p1.y + p2.y);
				all.add(p3);
				z++;
			}
		}
    	int k1 = 0;
		int[] flag = new int[z];
		for (int h = 0; h < z; h++) {
			flag[h] = 0;
		}
		for (int i = 0; i < z; i++) {
			int flage = 0;
			p1 = (Point) all.get(i);
			for (int j = i + 1; j < z; j++) {
			p2 = (Point) all.get(j);
			if (p1.y == p2.y && flag[i]==0) {
					p3 = new Point(p1.x + p2.x, p1.y);
					p1.x=p3.x;
					
					flage = 1;
					flag[j] = 1;
					}
			}
			if(flage==1 && p3.x!=0 ) {unsort_r.add(p3);}
			if (flage == 0 && flag[i]==0) {
				p3 = new Point(p1.x, p1.y);
				unsort_r.add(p3);
			}
		}
		
			k1 = unsort_r.size();
		
		int[][] result = new int[k1][2];
		for (int i = 0; i < k1; i++) {
			p3 = (Point) unsort_r.get(i);
			result[i][0] = p3.x;
			result[i][1] = p3.y;
		}
		result = sort(result);
		for (int i = 0; i < k1; i++) {
			p3 = new Point(result[i][0], result[i][1]);
			r.add(p3);
		}
		
		return result;
    }
    
}
