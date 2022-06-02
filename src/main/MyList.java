package main;

public class MyList<T> {
	
	
	Node<T> head;
	Node<T> tail;

	public void MyList() {
		head = tail = null;
	}

	// check linked if empty or not
	public boolean isEmpty() {
		return (head == null);
	}

	// clear linked list
	public void clear() {
		head = tail = null;

	}

	// get head node
	public Node getHead() {
		return head;
	}

	// length of list
	public int length() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	// add an item to the head of the list
	public void insertToHead(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = tail = newNode;
		} else {

			newNode.next = head;
			head = newNode;
		}

	}

	// add an item to the tail of the list

	public void insertToLast(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	

	// add an item at position to this list
	public void insertAfterPosition(int position, T item) {
		Node<T> newNode = new Node(item);

		int count = 0;

		Node<T> currentNode = head;
		while (currentNode != null && count < position) {
			currentNode = currentNode.next;
			count++;
		}

		if (currentNode == null && count < position) {
			System.out.println("Position is higher than size of linked list.");
			return;
		}

		Node<T> preNode = currentNode.next;
		newNode.next = preNode;
		currentNode.next = newNode;
	}

	
	// Print Node info
	public void traverse() {
		Node<T> p = head;
		while (p != null) {
			System.out.println(p.info);
			p = p.next;
		}
		System.out.println();
	}
	
	

	// get Object by position
	public T getObject(int position) {
		if (isEmpty()) {
			System.out.println("The list is empty.");
		}
		boolean check = false;
		int count = 0;
		Node<T> currentNode = head;
		while (currentNode != null) {
			// when Object exits in lined list
			if (position == count) {
				check = true;
				break;
			}
			currentNode = currentNode.next;
			count++;
		}
		// when Object not exits in linked list
		return currentNode.info;
	}

	
	
	// Delete an item by comparing Id
	public void deleteElement(T item) {
		Node temp = head, prev = null;

		if (temp != null && temp.info == item) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.info != item) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			return;
		}

		prev.next = temp.next;

	}

	// Convert to Binary using recursion
	public int convertToBinary(int i) {

		if (i == 0) {
			return 0;
			
		}
		else {
			return (i % 2 + 10 * convertToBinary(i / 2));
			
		}

	}
	
	
	//take head and tail of node but not break its linked.

	public Node<T> paritionLast(Node start, Node end) {
		if (start == end || start == null || end == null)

			return start;

		Node pivot_prev = start;
		Node curr = start;
		Product pivot = (Product) end.info;

		while (start != end) {
			Product temp = (Product) start.info;
			if (temp.bcode.compareTo(pivot.bcode) < 0) {

				pivot_prev = curr;
				Product t = (Product) curr.info;
				curr.info = start.info;
				start.info = t;
				curr = curr.next;
			}

			start = start.next;
		}

		Product t = (Product) curr.info;
		curr.info = pivot;
		end.info = t;

		return pivot_prev;
	}

	
	// Sort an linked list by using quick sort + recursion
	public void sortQuick(Node start, Node end) {
		if (start == null || start == end || start == end.next)
			return;

		Node pivot_prev = paritionLast(start, end);

		sortQuick(start, pivot_prev);

		if (pivot_prev != null && pivot_prev == start)
			sortQuick(pivot_prev.next, end);

		else if (pivot_prev != null && pivot_prev.next != null)
			sortQuick(pivot_prev.next.next, end);
	}

}
