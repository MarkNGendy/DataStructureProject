package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.queues;


public class LinkedListQueue implements IQueue {
	public class Node {
		private Object data; 
	    private Node next; 
	    public Node(){}
	    public Node(Object data) { this.data = data; }
	    public Node(Object data, Node next) {this.data= data; this.next= next;}
	    /** Returns the element of this node. */
		public Object getObj() { return data; }
		/** Returns the next node of this node. */
		public Node getNext() { return next;  }
		/** Sets the element of this node. */
		public void setObj(Object data) {this.data = data;}
		/** Sets the next node of this node.*/
		public void setNext(Node next) {this.next = next;}
	}
	private Node head= new Node();
	private Node tail= new Node();
	int size;
	public LinkedListQueue()
	{
		size=0;
	}

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		Node newNode= new Node(item,null);
		if(isEmpty())
			head= newNode;
		else
			tail.setNext(newNode);
		tail= newNode;
		size++;
		}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()){throw new IllegalStateException("Queue is Empty.");}
		Object temp = head.getObj();
		head=head.getNext();
		size--;
		if(isEmpty())
			tail=null;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size==0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
