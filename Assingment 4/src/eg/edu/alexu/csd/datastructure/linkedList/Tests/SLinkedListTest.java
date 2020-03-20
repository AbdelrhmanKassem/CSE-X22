package eg.edu.alexu.csd.datastructure.linkedList.Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import eg.edu.alexu.csd.datastructure.linkedList.Classes.SLinkedList;


class SLinkedListTest {
	
	//Testing List Initialization and Adding items At The End
	@Test
	void test1() {
		SLinkedList list = new SLinkedList();
		int i = 5;
		list.add(1);
		list.add(i);
		list.add(6);
		list.add(3,8);
		assertEquals(list.toString(),"1, 5, 6, 8, ");
		assertEquals(5,list.get(1));
		assertEquals(4,list.size());
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
		
		
	}	
	
	//Testing Adding At A Defined Index
	@Test
	void test2() {
		SLinkedList list = new SLinkedList();
		list.add(0,1);
		list.add(1,2);
		list.add(2,3);
		list.add(3,4);
		list.add(4,8);
		assertEquals(5, list.size());
		assertEquals(1,list.get(0));
		assertEquals(2,list.get(1));
		assertEquals(list.toString(),"1, 2, 3, 4, 8, ");
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));

	}
	
	// Testing Removing items and validating that size has decreased  
	@Test
	void test3() {
		SLinkedList list = new SLinkedList();
		list.add(0,1);
		list.add(1,2);
		list.add(2,3);
		list.add(3,4);
		assertEquals(4, list.size());
		list.remove(1);
		assertEquals(3, list.size());
		assertEquals(list.toString(),"1, 3, 4, ");
		assertEquals(1,list.get(0));
		assertEquals(3,list.get(1));
		

	}
	
	//Testing Adding To The Middle Of a list that already has items and making sure to throw expection when
	//going out of bounds of the array
	@Test
	void test4() {
		SLinkedList list = new SLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		assertEquals(6, list.size());
		assertEquals(list.toString(),"1, 2, 3, 4, 5, 6, ");
		list.add(3,9);
		list.add(4,10);
		assertEquals(8, list.size());
		assertEquals(list.toString(),"1, 2, 3, 9, 10, 4, 5, 6, ");
		assertEquals(9,list.get(3));
		assertEquals(10,list.get(4));
		assertEquals(4,list.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(8));

	}
	
	//Testing the set function to change one node 
	@Test
	void test5() {
		SLinkedList list = new SLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(1, 4);
		assertEquals(4,list.get(1));
		assertEquals(3,list.size());
	}	
	
	//Testing Sublist Method and making sure that only the desired elements and size are moved
	@Test
	void test6() {
		SLinkedList list = new SLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		assertEquals(7,list.size());
		SLinkedList subList = new SLinkedList();
		subList = (SLinkedList) list.sublist(3, 6);
		assertEquals(4,subList.size());
		assertEquals(subList.toString(),"3, 4, 5, 6, ");
	}	
	
	//Testing the contains method
	@Test
	void test7() {
		SLinkedList list = new SLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		assertEquals(7,list.size());
		assertEquals(true,list.contains(3));
		assertEquals(false,list.contains(8));
		
	}	
	
	//Testing the isEmpty method
	@Test
	void test8() {
		SLinkedList list = new SLinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		assertEquals(7,list.size());
		list.clear();
		assertEquals(0,list.size());
		assertEquals(true,list.isEmpty());
	}
			

}
	
	
	
	
	

