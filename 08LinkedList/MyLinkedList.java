public class MyLinkedList{

    private class Node{
	private Node next, prev;
	private int data;

	public Node(int x){
	    data = x;
	    next = null;
	    prev = null;
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public int getValue(){
	    return data;
	}

	public String toString(){
	    return String.valueOf(data);
	}
	    
    }

    private Node start, end;
    private int size;

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }
    
}
