package eg.edu.alexu.csd.datastructure.linkedList.Classes;

import eg.edu.alexu.csd.datastructure.linkedList.Interfaces.ILinkedList;



public class DLinkedList implements ILinkedList  {

	private class Node {
		// The Data Inside The Node
		private Object element;
		
		//"Pointers"  next To Next Node prev to previous node
		private Node next,prev;
		
		public Node (Object value, Node n ,Node p) {
			element = value;
			next = n;
			prev = p;
		}
		public Object getElement() {
			return element;
		}
		public Node getNext() {
			return next;
		}
		public Node getPrevious() {
			return prev;
		}
		public void setElement (Object value) {
			element = value;
		}
		public void setNext (Node n) {
			next = n;
		}
		public void setPrev (Node p) {
			prev = p;
		}
	 }
	
	private Node head,tail;
	private int size;
	
	public  DLinkedList() {
		head = new Node(null,null,null);
		size = 0;
		tail = new Node(null, null, head);
		head.setNext(tail);
		
	}
	
	public void add(int index, Object element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
			}
		
		Node p = head;
		Node n = head.getNext();
		if (head != null) {
		for (int i=0; i<index; i++) {
			n=n.getNext();
			p =p.getNext();
		    }
		}
		
		Node e = new Node(element, n, p);
		n.setPrev(e);
		p.setNext(e);
		size++;
	}
	
	
	
	public void add(Object element) {
		Node p = tail.getPrevious();
		Node e = new Node(element, tail, p);
		tail.setPrev(e);
		p.setNext(e);
		size++;
	}
	
	
	
	public Object get(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
			}
		
		Node n=head.getNext();
		for(int i=0; i<index; i++) {
			n=n.getNext();
		}
		
		return n.getElement();
	}
	
	
	
	
	public void set(int index, Object element) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
			}
		
		Node n = head.getNext();
		for(int i=0; i<index; i++) {
			n=n.getNext();
		}
		
		n.setElement(element);
	}
	
	
	
	public void clear() {
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}
	
	
	
	public boolean isEmpty() {
		return (size==0);
		
	}
	
	public void remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
			}
		
		size--;
		Node n = head.getNext();
		Node p = head;
		for(int i=0; i<index; i++) {
			n=n.getNext();
			p=p.getNext();
		}
		
		p.setNext(n.getNext());
		n.getNext().setPrev(p);
		n.setNext(null);
		n.setPrev(null);
	}
	
	
	
	public int size() {
		return size;
	}
	
	
	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		if (fromIndex < 0 || toIndex >= size || (fromIndex > toIndex)) {
			throw new IndexOutOfBoundsException();
		}
		
		int count = 0;
		int num = toIndex - fromIndex + 1;
		Node current = head.getNext();
		while (count < fromIndex) {
			current = current.getNext();
			count++;
		}
		count = 0;
		DLinkedList newList = new DLinkedList();
		while (count < num) {
			newList.add(current.getElement());
			current = current.getNext();
			count++;
		}
		
		return newList;
	}
	
	
	
	public boolean contains(Object o) {
		
		Node current = head.getNext();
		for (int i = 0; i < size; i++) {
			if(current.getElement().equals(o)) {
				return true;
			}
			current = current.getNext();
		}
		
		return false;
	}
	
	public String toString (){
		String s = "[";
		Node v = head.getNext();
		while (v != tail) {
			s += v.getElement();
			v = v.getNext();
			if (v != tail) s += ",";
			    }
			s += "]";
			return s ;
			}
		}



	

