import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class MyDeque<E>{

    private E[] data;
    private int size;
    private int front;
    private int back;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
	size = 0;
	front = 0;
	back = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity){
	if(capacity <= 0){
	    throw new IllegalArgumentException() ;
	}
	data =(E[])new Object[capacity];
	size = 0;
	front = 0;
	back = 0;
    }

    public int size(){
	return size;
    }

    public String toString(){ 
 	String line = "[";
	if (size == 1){
	    line += data[front];
	}
	else if(size > 1){		
	    int x = front;
		for(x = front; (x % data.length) != (back); x++){  	    
		    line += data[x % data.length] + ","; 
		}
	    line += data[back];
	}
 	return line + "]"; 
    }

    private void resize(){
	E[] next = (E[])new Object[(data.length * 2)];
	int y = 0;
	if (size == 1){
	    next[0] = data[front];
	}
	else if(size > 1){		
	    int x = front;
		for(x = front; (x % data.length) != (back); x++){  	    
		     next[y] = data[x % data.length];
		     y = y + 1;
		}
	   next[y] = data[back];
	}
	data = next;
	front = 0;
	back = size() - 1;
    }	


    public void addFirst(E value){
	if(value == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if (size == 0){
	    data[0] = value;
	    front = 0;
	    back = 0;
	}
	else if(front == 0){
	    int x = data.length - 1;
	    data[x] = value;
	    front = x;
	}
	else{
	    data[front - 1] = value;
	    front = front - 1;
	}
	size = size + 1;
    }

    public void addLast(E value){
	if(value == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if (size == 0){
	    data[0] = value;
	    front = 0;
	    back = 0;
	}
	else if(back == data.length - 1){
	    data[0] = value;
	    back = 0;
	}
	else{
	    data[back + 1] = value;
	    back = back + 1;
	}
	size = size + 1;
    }

    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    E moved = data[front];
	    data[front] = null;
	    if (front == data.length - 1){
		front = 0;
	    }
	    else{
		front = front + 1;
	    }
	    size = size - 1;
	    return moved;
	}
	
    }
    
    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    E moved = data[back];
	    data[back] = null;
	    if (back == 0){
		front = data.length - 1;
	    }
	    else{
		back = back - 1;
	    }
	    size = size - 1;
	    return moved;
	}
	
    }

    public E getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[front];
	}
    }

    public E getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[back];
	}
    }

		
   
    public static void main(String[] args){
	MyDeque<Integer> a = new MyDeque();
	System.out.println(a);
	for(int x = 0; x < 12; x++){
	    a.addLast(x);
	    System.out.println(a);
	}
	System.out.println(a.getFirst());
	System.out.println(a.getLast());

    }
	
	    

}
