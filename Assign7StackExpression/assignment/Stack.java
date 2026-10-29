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
	
	public void append(Node n) {
		System.out.println("Appending "+n.value);
		Node newNode = n;
		if(this.head == null) {
			this.head = newNode;
			this.tail =newNode;
		}
		else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			while(newNode.next !=null) {
				newNode = newNode.next;
				size++;
			}
			this.tail = newNode;
		}
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
	
	public Node delete(Object value) {
		Node delNode = search(value);
		
		if(delNode == this.head){
			this.head = delNode.next;
			this.head.prev = delNode.prev;
		}
		else if(delNode == this.tail) {
			this.tail = delNode.prev;
			this.tail.next = delNode.next;
		}
		
		if(delNode.prev != null) {
			delNode.prev.next = delNode.next;
		}
		delNode.next = null;
		delNode.prev = null;
		return delNode;
	}

	@Override
	public Object peek() {
		return this.head;
	}
	
	public Node search(Object value) {
		boolean found = false;
		Node curNode = this.head;
		while(!found && curNode != null) {
			if(curNode.value == value) {
				found = true;
			}
			else{
				curNode = curNode.next;
				if(curNode == null || curNode == this.head){
					return null;
				}
			}
		}
		return curNode;
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
	
	public void show() {
		Node curNode = this.head;
		while(curNode != null) {
			System.out.println(curNode);
			curNode = curNode.next;
			if(curNode == null || curNode == this.head){
				break;
			}
		}	
	}
	
	public Node clear() {
		Node clear = this.head;
		this.head = null;
		this.tail = null;
		return clear;
	}
	
}
