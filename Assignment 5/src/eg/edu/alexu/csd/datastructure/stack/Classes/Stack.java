package eg.edu.alexu.csd.datastructure.stack.Classes;
import eg.edu.alexu.csd.datastructure.stack.Interfaces.IStack;
import java.util.EmptyStackException;
/**
 * 
 * @author Abdelrhman Kassem
 *
 */
public class Stack implements IStack {

	private static class Node {
		/**
		 * The Data Inside The Node
		 */
		private Object element;
	
		/**
		 * "Pointer" To Next Node
		 */
		private Node next;
	
		/**
		 * Constructor function
		 * @param value
		 * @param n
		 */
		public Node (Object value, Node n) {
			element = value;
			next = n;
		}
	
		/**
		 * function to 
		 * @return the data inside the node
		 */
		public Object getData() {
			return element;
		}
	
		/**
		 * function to
		 * @return the next node
		 */
		public Node getNext() {
			return next;
		}
	
	}

	
	/**
	 * integer to keep track of the stack  size
	 */
	private int size;
	/**
	 * the node which is always on the top of the stack
	 */
	private Node top;

	/**
	 * constructor function
	 */
	public Stack ()
	{
		size = 0;
		top = null;
	}
	
	
	/**
	* Removes the element at the top of stack and returns that element.
	*
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		Object res = top.getData();
		top = top.getNext();
		size--;
		return res;
	}
	
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
	@Override
	public Object peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return top.getData();
	}
	
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param element
	* to insert
	*/
	@Override
	public void push(Object element) {
		Node n = new Node (element,top);
		top = n;
		size++;
	}

	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/
	@Override
	public boolean isEmpty() {
		if (top == null) return true;
		return false;
	}
	
	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
	public int size() {
		return size;
	}
	
	/**
	 * Function to store the stack in a string
	 * made for testing purposes only but might come in handy
	 * 
	 * @return string containing the stack elements
	 */
	public String toString() {
		if (size == 0) {
			throw new EmptyStackException();			
		}
		String result = "";
		Node current = top;
		for (int i=0 ; i< size ; i++) {
			result = result + current.getData() + ", ";
			current = current.getNext();
		}
		return result;
	}
	
	/**
	 * function to clear the stack
	 */
	public void clear () {
		top = null;
		size = 0;
	}

}
