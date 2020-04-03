package eg.edu.alexu.csd.datastructure.stack.Classes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

/**
 * 
 * @author Abdelrhman Kassem
 *
 */
public class StackUI {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static Stack stack = new Stack();
	

	public static void main(String[] args) {
			main_menu();
	}
	
	
	
	public static void main_menu () {
		String first_menu ="1: Push\r\n" + 
				"2: Pop\r\n" + 
				"3: Peek\n" + 
				"4: Get size\n" + 
				"5: Check if empty\n"+ 
				"6: Print the stack\n"+ 
				"7: Exit\n"+ 
				"Enter Your Choice: ";
		System.out.println(first_menu);
		try 
		{
			String read = br.readLine();
			int choice = Integer.parseInt(read);
			switch (choice) {
			case 1:
				read="";
				choice=0;
				System.out.println("Enter the number to push");
				String push = br.readLine();
				int noPush = Integer.parseInt(push);
				stack.push(noPush);
				System.out.println(noPush + " Pushed!");
				main_menu();
				break;

			case 2:
				read="";
				choice=0;
				int pop;
				try {
					pop = (int) stack.pop();
					System.out.println("The number poped is: " + pop);

				}
				catch (Exception e) {
					System.out.println("Stack is empty cannot pop!");
					main_menu();

				}
				main_menu();
				break;
			
			case 3:
				read="";
				choice=0;
				int peek;
				try {
					peek = (int) stack.peek();
					System.out.println("The top of the stack is: " + peek);

				}
				catch (Exception e) {
					System.out.println("Stack is empty cannot peek!");
					main_menu();

				}
				main_menu();
			
			case 4:
				read="";
				choice=0;
				System.out.println("Stack size is: " + stack.size());
				main_menu();
				break;
			
			case 5:
				read="";
				choice=0;
				if (stack.isEmpty()) System.out.println("Stack is empty");
				else System.out.println("Stack is not empty");
				main_menu();			
				
			case 6:
					read="";
					choice=0;
					try {
						System.out.println("Stack: " + stack.toString());
					}
					catch( EmptyStackException e) {
						System.out.println("Stack is empty!!");
					}
					main_menu();
				break;
				
			case 7:
				System.out.println("Exit Successfully");
				System.exit(0);
			
				
			default:
				System.out.println("Please Enter A Number Between 1-7: ");
				main_menu();
		}
					
			
		}
		catch (Exception e) {
			System.out.println("Please Enter A Number Between 1-7: ");
			main_menu();
		}
	}		

}