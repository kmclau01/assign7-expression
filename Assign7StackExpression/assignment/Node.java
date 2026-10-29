package assignment;

public class Node {

	Node next;
	Node prev;
	Object value;
	
	public Node(Object value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
}
