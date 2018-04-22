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
	for(int x = front; (x % data.length) != (back + 1); x++){
	    next[y] = data[x];
	    System.out.println(data[x]);
	    y = y + 1;
	}
	data = next;
	front = 0;
	back = size();
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
    
   
    public static void main(String[] args){
	MyDeque<Integer> a = new MyDeque();
	System.out.println(a);
	for(int x = 0; x < 10; x++){
	    a.addFirst(x);
	    System.out.println(a);
	}

    }
	
	    

}
