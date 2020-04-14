package eg.edu.alexu.csd.datastructure.queue.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eg.edu.alexu.csd.datastructure.queue.Classes.LinkedListBasedQueue;

class LinkedListBasedTest {

	@Test
	void test() {
		LinkedListBasedQueue a = new LinkedListBasedQueue();
		assertEquals(a.size(),0);
		assertTrue(a.isEmpty());
		a.enqueue(1);
		a.enqueue('s');
		assertEquals(a.size(),2);
		assertFalse(a.isEmpty());
		assertEquals(a.dequeue(),1);
		assertEquals(a.size(),1);
		assertFalse(a.isEmpty());
		assertEquals(a.dequeue(),'s');
		assertTrue(a.isEmpty());
        assertThrows(RuntimeException.class,()->a.dequeue());
	}

}
