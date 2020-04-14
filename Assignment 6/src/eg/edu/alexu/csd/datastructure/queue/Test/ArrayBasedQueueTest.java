package eg.edu.alexu.csd.datastructure.queue.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import eg.edu.alexu.csd.datastructure.queue.Classes.ArrayBasedQueue;

class ArrayBasedQueueTest {

	@Test
	void test() {
		ArrayBasedQueue Q = new ArrayBasedQueue(10);
		assertEquals(Q.size(),0);
		assertEquals(Q.isEmpty(),true);
		assertThrows(NoSuchElementException.class, () -> Q.dequeue());
		Q.enqueue(1);
		assertEquals(Q.size(),1);
		assertEquals(Q.isEmpty(),false);
		Q.enqueue(2);
		Q.enqueue(3);
		assertEquals(Q.size(),3);
		assertEquals(Q.dequeue(),1);
		assertEquals(Q.size(),2);
		assertEquals(Q.isEmpty(),false);
	}

}
