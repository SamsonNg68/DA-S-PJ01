package main;

import java.util.Iterator;

public class MyStack<T> {
	Node<T> head;
	
	public MyStack() {
		head = null;
	}
	
	//check stack if empty
	public boolean isEmpty() {
		return head == null;
	}
	
	
	// 
	public void push(T info) {
		Node newNode = new Node(info);
		if(isEmpty()) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
			
		}
		
	}
	//
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T info = head.info;
		head = head.next;
		return info;
	}
	
	
	//
	public T top() {
		if(isEmpty()) {
			return null;
		}
		T info = head.info;
		return info;
	}
	
	//
	public void clear() {
		head = null;
	}
	
	
	
	

}
