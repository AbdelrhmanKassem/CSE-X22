package eg.edu.alexu.csd.datastructure.linkedList.Classes;


import eg.edu.alexu.csd.datastructure.linkedList.Interfaces.ILinkedList;

public class SLinkedList implements ILinkedList {
	
	//Class To Implement The Node 
	private class Node {
		// The Data Inside The Node
		private Object element;
		
		//"Pointer" To Next Node
		private Node next;
		
		public Node (Object value, Node n) {
			element = value;
			next = n;
		}
		public Object getData() {
			return element;
		}
		public Node getNext() {
			return next;
		}
		public void setData (Object value) {
			element = value;
		}
		public void setNext (Node n) {
			next = n;
		}
	}

	
	
	private Node head,tail;
	private int size;
	
	public SLinkedList() {
		head = new Node(null,null);
		tail = new Node(null,null);
		head.setNext(tail);
		tail.setNext(null);
		size=0;
	}
	
	public void add(int index, Object element) {
		
		if ( index > size || index < 0) throw new IndexOutOfBoundsException();
		Node current = head;
		Node temp = new Node(element, null);
		
		if (current != null) {

			for (int i = 0; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}
		
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}

	public void add(Object element) {
		Node current = head;
		Node newTail = new Node (element,null);
		for (int i = 0; i < size; i++) {
			current = current.getNext();
		}
		current.setNext(newTail);
		size++;
		}
		
	

	public Object get(int index) {
		if (index >= size || index < 0)  throw new IndexOutOfBoundsException();
		Node current = head.getNext();
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		return current.getData();
	}

	public void set(int index, Object element) {
		if (index >= size || index < 0)  throw new IndexOutOfBoundsException();
		Node current = head.getNext();
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setData(element);
		
	}

	public void clear() {
		head.setNext(tail);
		size=0;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public void remove(int index) {
		if (index >= size || index < 0)  throw new IndexOutOfBoundsException();
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		size--;
		
	}


	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size) throw new IndexOutOfBoundsException();
		if (fromIndex > toIndex) throw new IndexOutOfBoundsException();
		
		int num = toIndex - fromIndex + 1;
		Node current = head.getNext();
		for (int i = 0; i < fromIndex; i++) {
		current = current.getNext();
		}
		SLinkedList newList = new SLinkedList();
		for (int i = 0; i < num; i++) {
			newList.add(current.getData());
			current = current.getNext();
		}
		return newList;
		
	}

	public boolean contains(Object o) {
		Node current = head.getNext();
		for (int i = 0; i < size; i++) {
			if(current.getData() == o) {
				return true;
			}
			current = current.getNext();
		}
		
		return false;
	}

	public String toString() {
		String result = "";
		Node current = head.getNext();
		for (int i=0 ; i< size ; i++) {
			result = result + current.getData() + ", ";
			current = current.getNext();
		}
		return result;
	}
	
	public int size() {
		return size;
	}
}

	
	


