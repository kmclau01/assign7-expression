package assignment;

public class Stack implements StackInterface {
	Node head;
	Node tail;
	int size;
	
	@Override
	public void push(Object item) {
		Node newnode = new Node(item);
		newnode.next = this.head;
		this.head.prev = newnode;
		this.head = newnode;
		size++;
	}

	@Override
	public Object pop() {
		Node popnode = this.head;
		this.head = popnode.next;
		
		popnode.next = null;
		this.head.prev = null;
		size--;
		return popnode;
	}

	@Override
	public Object peek() {
		return this.head;
	}

	@Override
	public boolean isEmpty() {
		if(this.head == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return this.size;
	}
}
