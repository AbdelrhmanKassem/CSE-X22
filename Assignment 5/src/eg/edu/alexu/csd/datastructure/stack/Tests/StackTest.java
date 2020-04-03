package eg.edu.alexu.csd.datastructure.stack.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.datastructure.stack.Classes.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Abdelrhman Kassem
 *
 */
class StackTest {

	@Test
	void test1() {
		Stack stack = new Stack();
		assertEquals(stack.isEmpty(),true);
		assertEquals(stack.size(),0);
		assertThrows(EmptyStackException.class, () -> stack.peek());
		assertThrows(EmptyStackException.class, () -> stack.pop());		
	}	
	
	
	
	@Test
	void test2() {
		Stack stack = new Stack();
		stack.push(5);
		stack.push(3);
		stack.push(2);
		assertEquals(stack.isEmpty(),false);
		assertEquals(stack.size(),3);
		assertEquals(stack.peek(),2);
		assertEquals(stack.pop(),2);
		assertEquals(stack.pop(),3);
		assertEquals(stack.isEmpty(),false);
		assertEquals(stack.pop(),5);
		assertEquals(stack.isEmpty(),true);
	}	
	
	
	
	@Test
	void test3() {
		Stack stack = new Stack();
		stack.push(5);
		stack.push(3);
		stack.push(2);
		assertEquals(stack.toString(),"2, 3, 5, ");
		assertEquals(stack.isEmpty(),false);
		assertEquals(stack.size(),3);
		stack.clear();
		assertEquals(stack.isEmpty(),true);
		assertEquals(stack.size(),0);

	}
	
	
}
