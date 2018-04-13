import java.util.*;
import java.io.*;

public class MyLinkedListImproved<T extends Comparable> implements Iterable<T>{

    private class Node{
	private Node next, prev;
	private T data;

	public Node(T x){
	    data = x;	    
	    prev = null;
	    next = null;
	}

	public Node(T x, Node m, Node n){
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

	public T getValue(){
	    return data;
	}

	public void setValue(T x){
	    data = x;
	}

	public String toString(){
	    return String.valueOf(data);
	}
	    
    }

    private Node start, end;
    private int size;

    public MyLinkedListImproved(){
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

    public boolean add(T newData){
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

    public T get(int index){
	Node current = getNode(index);
	return current.getValue();
    }

    public T set(int index, T value){
	Node current = getNode(index);
	T n = current.getValue();
	current.setValue(value);
	return n;
    }

    public int indexOf(T value){
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

    public void add(int index, T value){
	if(index < 0 || index > size){ 
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

    public boolean remove(T value){
	int x = indexOf(value);
	if(x == -1){
	    return false;
	}
	else if(x == 0){
	    start = start.getNext();
	    start.setPrev(null);
	    size = size - 1;
	}
	else if(x == size - 1){
	    end = end.getPrev();
	    end.setNext(null);
	    size = size - 1;
	}
	else{
	    Node before = getNode(x - 1);
	    Node after = getNode(x + 1);
	    before.setNext(after);
	    after.setPrev(before);
	    size = size - 1;
	}
	return true;
    }

    public T remove(int index){
	if(index < 0 || index >= size){ 
 	    throw new IndexOutOfBoundsException(); 
 	}
	T x = get(index);
	if(index == 0){
	    start = start.getNext();
	    start.setPrev(null);
	    size = size - 1;
	}
	else if(index == size - 1){
	    end = end.getPrev();
	    end.setNext(null);
	    size = size - 1;
	}
	else{
	    Node before = getNode(index - 1);
	    Node after = getNode(index + 1);
	    before.setNext(after);
	    after.setPrev(before);
	    size = size - 1;
	}
	return x;
    }

    public Iterator<T> iterator(){
	return new LLIterator(this);
    }

    private class LLIterator implements Iterator<T>{

	private Node next;

	public LLIterator(MyLinkedListImproved<T> l){
	    next = l.start;
	}

	public boolean hasNext(){
	    try{
		if (next.getValue() != null){
		    return true;
		}
	    }
	    catch(NullPointerException e){
		return false;
	    }
	    return false;
	}
	
	public T next(){
	    if(hasNext()){
		Node V = next;
		next = next.getNext();
		return V.getValue();
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}
    }

    public int max(){
	int max = 0;
	int index = 0;
	T biggest = start.getValue();
	if (size == 0){
	    return -1;
	}
	else{
	    for(T n : this){
		if (n.compareTo(biggest) > 0){
		    max = index;
		    biggest = n;
		}
		index = index + 1;
	    }
	}
	return max;
    }
		
	


    public static void main(String args[]){ 
    	MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>(); 
    	System.out.println(l.toString()); 
    	l.add(1); 
    	System.out.println(l.toString()); 
    	l.add(2); 
    	System.out.println(l.toString());
    	l.add(0, 3);
    	System.out.println(l.toString());
    	l.add(2, 4);
    	System.out.println(l.toString());
	l.add(5);
    	System.out.println(l.toString());
    	// l.remove(3);
    	// System.out.println(l.toString());
    	// l.remove(1);
    	// System.out.println(l.toString());
    	// l.remove(0);
    	// System.out.println(l.toString());
    	// l.remove(12);
    	// System.out.println(l.toString());

	for(Integer n : l){
	    System.out.println(n.toString());
	}
	
    }

    // public static void main(String args[]){
    // 	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
    //     n.add("fish");
    // 	System.out.println(n);
    // 	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
    //     m.add(new Integer(0));
    // 	System.out.println(m);
    // }

    



	
    
}
