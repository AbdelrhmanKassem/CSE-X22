package eg.edu.alexu.csd.datastructure.queue.Classes;

import eg.edu.alexu.csd.datastructure.queue.Interfaces.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.Interfaces.IQueue;

public class LinkedListBasedQueue implements IQueue, ILinkedBased {
	public class Node {
		  public Object element;
		  public Node next = null;
		}
	private Node front =null;
	private Node rear =null;
	private int size =0;
	
	public void enqueue(Object item) {
		Node node = new Node();
		node.element=item;
		if(front==null) {
			front=node;
			rear =node;
			size++;
		}
		else {
			rear.next=node;
			rear=node;
			size++;
		}
	}

	public Object dequeue() {
		if(size==0) {
			throw new RuntimeException("The queue is empty");
		}
		else {
			Object i = front.element;
			front=front.next;
			size--;
			if(size==0) {
				rear=null;
			}
			return i;
		}
	}

	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else
		{		return false;
		
		}
	}

	public int size() {
		return size;
	}
}
