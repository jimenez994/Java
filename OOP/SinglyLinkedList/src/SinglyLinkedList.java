public class SinglyLinkedList {
	private Node head;
	public SinglyLinkedList() {
		this.head = null;
	}
	public SinglyLinkedList add(int num) {
		Node node = new Node(num);
		if(this.head == null) {
			this.head = node;
		}else {
			Node rnr = this.head;
			while(rnr.next != null) {
				rnr = rnr.next;	
			}
			rnr.next = node;
		}
		return this;
	}
	public SinglyLinkedList remove() {
		Node rnr = this.head;
		if(rnr.next == null) {
			this.head = null;
		}else {
			while(rnr.next.next != null) {
				rnr = rnr.next;
			}
			rnr.next = null;
			
		}
		return this;
	}
	public SinglyLinkedList printValues() {
		Node rnr = this.head;
		while(rnr != null) {
			System.out.println(rnr.value);
			rnr = rnr.next;
		}
		return null;
	}
	public SinglyLinkedList find(int num) {
		Node rnr = this.head;
		while(rnr.value != num) {
			rnr = rnr.next;
		}
		if(rnr.value == num) {
			System.out.println("Is This Your Number? " + rnr.value);
		}else {
			System.out.println("Sorry there no node with that value");
		}
		return null;
	}
	public SinglyLinkedList removeAt(int num) {
		
		if(this.head != null) {
			if(this.head.value == num) {
				this.head = this.head.next;
				return this;
			}else {
				Node rnr = this.head;
				while(rnr.next != null) {
					if(rnr.next.value == num) {
						rnr.next = rnr.next.next;
						return this;
					}else {
						rnr = rnr.next;
					}
				}
			}
		}
		
		return this;
	}
	
}