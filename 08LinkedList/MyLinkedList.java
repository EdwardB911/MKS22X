public class MyLinkedList{

    private class Node{
	private Node next, prev;
	private int data;

	private Node(int x){
	    data = x;
	    next = null;
	    prev = null;
	}

	private Node getNext(){
	    return next;
	}

	private Node getPrev(){
	    return prev;
	}

	private int getValue(){
	    return data;
	}

	private String toString(){
	    return String.valueOf(data);
	}
	    
    }
}
