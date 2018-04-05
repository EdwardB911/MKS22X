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

	public void setValue(int x){
	    data = x;
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

    public boolean add(Integer newData){
	if(size == 0){
	    Node addition = new Node(newData);
	    start = addition;
	    end = addition;
	}
	else{
	    Node addition = new Node(newData);
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

    public int size(){
	return size;
    }

    private Node getNode(int index){ 
 	if(index < 0 || index >= size){ 
 	    throw new IndexOutOfBoundsException(); 
 	} 
 	Node current = start; 
 	while(index > 0){ 
 	    current = current.getNext(); 
 	    index = index - 1; 
 	} 
 	return current; 
    }

    public Integer get(int index){
	Node current = getNode(index);
	return current.getValue();
    }

    public Integer set(int index, Integer value){
	Node current = getNode(index);
	int n = current.getValue();
	current.setValue(value);
	return n;
    }

    public int indexOf(Integer value){
	int x = 0;
	Node current = start;
	while(current != null){
	    if(current.getValue() == value){
		return x;
	    }
	    x = x + 1;
	    current = current.getNext();
	}
	return -1;
    }

    public void add(int index, Integer value){
	if(index < 0 || index >= size){ 
 	    throw new IndexOutOfBoundsException(); 
 	}
	Node addition = new Node(value);
	if (index == size){
	    add(value);
	}	
	else if (index == 0){	   
	    addition.setNext(start);
	    start.setPrev(addition);
	    start = addition;
	    size = size + 1;
	}
	else{
	    Node after = getNode(index);
	    Node before = after.getPrev();
	    addition.setNext(after);
	    addition.setPrev(before);
	    before.setNext(addition);
	    after.setPrev(addition);
	    size = size + 1;
	}
    }

    public boolean remove(Integer value)


    public static void main(String args[]){ 
 	MyLinkedList l = new MyLinkedList(); 
 	System.out.println(l.toString()); 
 	l.add(1); 
	System.out.println(l.toString()); 
 	l.add(2); 
	System.out.println(l.toString());
	l.add(0, 3);
	System.out.println(l.toString());
	l.add(2, 4);
	System.out.println(l.toString());
	
    }



	
    
}
