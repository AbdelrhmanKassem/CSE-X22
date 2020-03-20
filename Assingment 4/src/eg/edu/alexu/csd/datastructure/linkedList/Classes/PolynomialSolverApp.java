package eg.edu.alexu.csd.datastructure.linkedList.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class PolynomialSolverApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	static PolynomialSolver polysolver = new PolynomialSolver();

	
	static void main_menu () {
		String first_menu = "====================================================================\r\n" + 
				"Please choose an action\r\n" + 
				"-----------------------\r\n" + 
				"1- Set a polynomial variable\r\n" + 
				"2- Print the value of a polynomial variable\r\n" + 
				"3- Add two polynomials\r\n" + 
				"4- Subtract two polynomials\r\n" + 
				"5- Multiply two polynomials\r\n" + 
				"6- Evaluate a polynomial at some point\r\n" + 
				"7- Clear a polynomial variable\r\n" + 
				"8- Exit\r\n" + 
				"====================================================================\r\n" +
				"Enter Your Choice: ";
		System.out.println(first_menu);
		try 
		{
			String r = br.readLine();
			int choice = Integer.parseInt(r);
			switch (choice) {
			case 1:
				read_poly();
				r="";
				choice=0;
				break;

			case 2:
				print_poly();
				r=" ";
				choice=0;
				break;
			
			case 3:
				add_polys();
				r=" ";
				choice=0;
				break;
			
			case 4:
				subtract_polys();
				r="";
				choice=0;
				break;
			
			case 5:
				multip_polys();
				r="";
				choice=0;
				break;
			
			case 6:
				eval_poly();
				r="";
				choice=0;
				break;
				
			case 7:
				clear_poly();
				r="";
				choice=0;
				break;
			
			case 8:
				System.exit(0);
				r="";
				choice=0;
				break;
				
			default:
				System.out.println("Please Enter A Number Between 1-8: ");
		}
					
			
		}
		catch (Exception e) {
			System.out.println("Please Enter A Number Between 1-8: ");
			main_menu();
		}
	}
	
	
	static void read_poly () {
		System.out.println("Insert the variable name: A, B or C");
		char poly=' ';
		try {
			poly = br.readLine().charAt(0);
		} catch (IOException e1) {
			System.out.println("Please Type A Valid Character"); 
			read_poly();
		}
		if(!(poly=='A' || poly == 'B' || poly == 'C')) {System.out.println("Please Type A Valid Character"); read_poly();}
		System.out.println("Insert the polynomial terms in the form:\r\n(coeff1, exponent1), (coeff2, exponent2),..");
   
        try
	    {
    		String polyn_str = br.readLine();
            polyn_str = polyn_str.replace(" ", "");
            polyn_str = polyn_str.replace(",", " ");
            polyn_str = polyn_str.replace(")", "");
            polyn_str = polyn_str.replace("(", "");
            String[] polyn_str2 = polyn_str.split(" ");
            int[][] poly_array = new int[polyn_str2.length / 2][2];
            for (int i = 0; i < polyn_str2.length; i += 2) {
            	poly_array[i / 2][0] = Integer.parseInt(polyn_str2[i]);
            	poly_array[i / 2][1] = Integer.parseInt(polyn_str2[i + 1]);
              }
            polyn_str="";
        	polysolver.setPolynomial(poly,poly_array);
	    	System.out.println("Polynomial " + poly + " Is Set");
	    	main_menu();
	  	}
	    catch (Exception e)
	    {
	    	System.out.println("\nPlease Make Sure To Enter The polynomial Excatly As Described Above");	    	
	    	read_poly();
	    }
	}
	
	static void print_poly() {
		System.out.println("Insert the variable name: A, B, C or R");
		char poly = ' ';
  	  	try {
			poly = br.readLine().charAt(0);
		} 
  	  	catch (IOException e) {
			System.out.println("Please Type A Valid Character");
			print_poly();
		}
  
		try 
	      {
	    	  String polyn = polysolver.print(poly);
	    	  System.out.println("Value in "+ poly + ": " + polyn);
	    	  main_menu();
	      }
	      catch (IllegalArgumentException e)
	      {
	    	  System.err.println(e.getLocalizedMessage());
	    	  print_poly();
	      }
	}
	
	static void add_polys() {

        try 
	    {
    		System.out.println("Insert first operand variable name: A, B or C");
    		char poly1 = ' ';
    		poly1=br.readLine().charAt(0);
    		System.out.println("Insert second operand variable name: A, B or C");
    		char poly2 = ' ';
    		poly2=br.readLine().charAt(0);
    		int[][] result = polysolver.add(poly1,poly2);
	    	 System.out.print("Result set in R:");
	         for (int i = 0; i < result.length; i++) {
	           System.out.print("(" + result[i][0] + "," + result[i][1] + ")");
	           if (i + 1 != result.length) {
	             System.out.print(" ,");
	           }
	         }
	         System.out.print("\n");
	  	}
	    catch (IllegalArgumentException e)
	    {
	    	System.err.println(e.getLocalizedMessage());
	    	add_polys();
	    } 
        catch (IOException e) {
			System.out.println("Please Type A Valid Character");
			add_polys();
		}
	}
   
	
	static void subtract_polys() {
		try 
	    {
			System.out.println("Insert first operand variable name: A, B or C");
			char poly1 = ' ';
	   		poly1=br.readLine().charAt(0);
	    	System.out.println("Insert second operand variable name: A, B or C");
	   		char poly2 = ' ';
	   		poly2=br.readLine().charAt(0);
	   		int[][] result = polysolver.subtract(poly1,poly2);
	   		System.out.print("Result set in R:");
		    for (int i = 0; i < result.length; i++) {
		    	System.out.print("(" + result[i][0] + "," + result[i][1] + ")");
		        if (i + 1 != result.length) {
		             System.out.print(" ,");
		           }
		         }
		    System.out.print("\n");
		  	}
		catch (IllegalArgumentException e)
	    {
	    	System.err.println(e.getLocalizedMessage());
	    	subtract_polys();
	    } 
		catch (IOException e) {
			System.out.println("Please Type A Valid Character");
			subtract_polys();
		}
		
	}
    
    
    static void multip_polys() {
    	 try 
 	    {
     		System.out.println("Insert first operand variable name: A, B or C");
     		char poly1 = ' ';
     		poly1=br.readLine().charAt(0);
     		System.out.println("Insert second operand variable name: A, B or C");
     		char poly2 = ' ';
     		poly2=br.readLine().charAt(0);
     		int[][] result = polysolver.multiply(poly1,poly2);
 	    	 System.out.print("Result set in R:");
 	         for (int i = 0; i < result.length; i++) {
 	           System.out.print("(" + result[i][0] + "," + result[i][1] + ")");
 	           if (i + 1 != result.length) {
 	             System.out.print(" ,");
 	           }
 	         }
 	         System.out.print("\n");
 	  	}
 	    catch (IllegalArgumentException e)
 	    {
 	    	System.err.println(e.getLocalizedMessage());
 	    	multip_polys();
 	    } 
         catch (IOException e) {
 			System.out.println("Please Type A Valid Character");
 		}
    }
    
    static void eval_poly() {
    	System.out.println("Insert the variable name: A, B, C or R");
		char poly = ' ';
        //Tried Using 1 as value Just to make sure user input is correct before asking for a point
		try 
        {
        	poly = br.readLine().charAt(0);
			@SuppressWarnings("unused")
			float dummy_try=polysolver.evaluatePolynomial(poly, 1);
	  	}
        
	    catch (IllegalArgumentException e)
	    {
	    	System.err.println(e.getLocalizedMessage());
	    	eval_poly();
	    } 
		catch (IOException e) {
 			System.out.println("Please Type A Valid Character");
	    	eval_poly();
		}
		
    	System.out.println("Type The Point At Which You Would Like To Evaluate The Polnomial: ");
    	float val;
    	
		try 
        {
        	String r = br.readLine();
        	val = Float.parseFloat(r);
			float result = polysolver.evaluatePolynomial(poly, val);
        	System.out.println("The Result Is: "+ result);
        	main_menu();
	  	}
        
	    catch (IllegalArgumentException e)
	    {
	    	System.err.println(e.getLocalizedMessage());
	    	eval_poly();
	    } 
		catch (IOException e) 
		{
 			System.out.println("Please Enter A Valid Number");
	    	eval_poly();

		}
    }
    
    static void clear_poly() {
		System.out.println("Insert the variable name: A, B, C or R");
		char poly = ' ';
	      try 
	      {
	    	  poly = br.readLine().charAt(0);
	    	  polysolver.clearPolynomial(poly);
	    	  System.out.println("Polynomial " + poly + " has been Cleared!!");     
	      }
	      catch (IllegalArgumentException e)
	      {
	    	  System.err.println(e.getLocalizedMessage());
	    	  clear_poly();
	      } catch (IOException e) 
	      {
	    	  System.out.println("Please Type A Valid Character");
	    	  clear_poly();
		}
	
    }
    	
    
	
	public static void main(String[] args) {
		while(true) {
			main_menu();
		}

	}
}
