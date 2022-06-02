package main;

public class MyQueue<T> {
	Node<T> head;
	Node<T> tail;
	
	public MyQueue() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return (head == null && tail == null);
	}
	
	//
	public void clear() {
		head = tail = null;
	}
	
	//
	public boolean isFull()
	{
		return true;
	}
	
	public void  enqueue(T item) {
		
		Node newNode = new Node(item);
		
		if(isEmpty()) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		T info = head.info;
		if(head == tail) {
			head = tail = null;
		}else {
			head = head.next;
		}
		
		return info;
		
	}
	
	
	

}
