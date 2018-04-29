import java.util.*;
import java.io.*;

public class MyHeap{

    private String[] data;
    private boolean isMax;
    private int size;

    public MyHeap(){
	data = new String[10];
	isMax = true;
	size = 0;
    }

    public MyHeap(boolean b){
	data = new String[10];
	isMax = b;
	size = 0;
    }

    public int size(){
	return size;
    }

    private void resize(){
	String[] ary = new String[data.length * 2];
	for(int x = 0; x < ary.length; x++){ 
 	    ary[x] = data[x]; 
 	}
	data = ary;
    }

    private int parent(int x){
	return ((x - 1)/2);
    }

    private void swap(int a, int b){                       
        String c = data[a];                                                          
        data[a] = data[b];
	data[b] = c;                                                             
    }

    public String toString(){
	return Arrays.toString(data);
    }

    public void add(String s){
	if(size == data.length){
	    resize();
	}
	data[size] = s;
	for(int x = size(); parent(x) >= 0 && (x != 0); x = parent(x)){
	    if(isMax){
		if(data[parent(x)].compareTo(data[x]) < 0){
		    swap(x, parent(x));
		}
	    }
	    else{
		if(data[parent(x)].compareTo(data[x]) > 0){
		    swap(x, parent(x));
		}
	    }
	}
	size = size + 1;
    }

    public static void main(String[] args){
	MyHeap max = new MyHeap(true);
	max.add("apple");
	max.add("doughnut");
	max.add("carrot");
	max.add("egg");
	System.out.println(max);
	MyHeap min = new MyHeap(false);
	min.add("apple");
	min.add("doughnut");
	min.add("carrot");
	min.add("egg");
	System.out.println(min);
    }
		    
	
	    

}
