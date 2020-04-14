package eg.edu.alexu.csd.datastructure.queue.Classes;

import java.util.NoSuchElementException;

import eg.edu.alexu.csd.datastructure.queue.Interfaces.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.Interfaces.IQueue;

public class ArrayBasedQueue implements IQueue, IArrayBased {

	private int f,r,size = 0 ,N;
	private Object [] Q;
	public ArrayBasedQueue (int n) {
		Q = new Object [n];
		N=n;
	}
	
	public void enqueue(Object item) {
		if (size == N-1)
			throw new IllegalStateException("Queue if full");
		Q[r] = item;
		r = (r+1) % N;
		size++;
	}

	public Object dequeue() {
		if (size==0)
			throw new NoSuchElementException("Queue is empty");
		Object temp = Q[f];
		Q[f] = null;
		f = (f+1) % N;
		size--;
		return temp;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}

	public int size() {
		return size;
	}

}
