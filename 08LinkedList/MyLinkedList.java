public class MyLinkedList{

    private class Node{
	private Node next, prev;
	private int data;

	public Node(int x){
	    data = x;	    
	    prev = null;
	    next = null;
	}

	public Node(int x, Node m, Node n){
	    data = x;
	    prev = m;
	    next = n;
	}

	public Node getNext(){
	    return next;
	}

	public void setNext(Node n){
	    next = n;
	}

	public Node getPrev(){
	    return prev;
	}

	public void setPrev(Node n){
	    prev = n;
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

    public String toString(){
	if(size == 0){ 
 	    return "[]"; 
 	} 
 	String str = "["; 
 	Node current = start; 
 	while(current.getNext() != null){ 
 	    str = str + current.toString() + ", "; 
 	    current = current.getNext(); 
 	} 
 	return str + current.toString() + "]"; 
    }

    public boolean add(Integer value){
	if(size == 0){
	    Node addition = new Node(value);
	    start = addition;
	    end = addition;
	}
	else{
	    Node addition = new Node(value);
	    addition.setPrev(end);
	    end.setNext(addition);
	    end = addition;
	}
	size = size + 1; 
 	return true; 
    }

    public void clear(){ 
 	start = null; 
 	end = null; 
 	size = 0; 
    }

    private Node getNode(int n){ 
 	if(n < 0 || n >= size){ 
 	    throw new IndexOutOfBoundsException(); 
 	} 
 	Node current = start; 
 	while(n > 0){ 
 	    current = current.getNext(); 
 	    n = n - 1; 
 	} 
 	return current; 
    }
    

    public static void main(String args[]){ 
 	MyLinkedList l = new MyLinkedList(); 
 	System.out.println(l.toString()); 
 	l.add(1); 
	System.out.println(l.toString()); 
 	l.add(2); 
	System.out.println(l.toString());
	Node n = l.getNode(0);
	System.out.println(n.toString());
    }



	
    
}
