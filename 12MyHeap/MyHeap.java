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

    private int[] children(int x){
	int[] ary = new int[2];
	ary[0] = (2 * x) + 1;
	ary[1] = (2 * x) + 2;
	return ary;
    }

    private void swap(int a, int b){                       
        String c = data[a];                                                          
        data[a] = data[b];
	data[b] = c;                                                             
    }

    public String toString(){
	String str = "[";
	for(int x = 0; x < size(); x++){
	    str = str + data[x] + ", ";
	}
	return str + "]";	
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

    // removes top element
    public String remove(){
	String str = data[0];
	swap(0, size - 1);
	data[size - 1] = null;
	size = size - 1;
	int x = 0;
	while(x < size()){
	    int[] ary = children(x);
	    int est = -1;
	    if (ary[0] >= size()){
		x = size();
	    }	    
	    else if(ary[1] == size()){
		est = ary[0];
	    }
	    else{
		if(isMax){
		    if(data[ary[0]].compareTo(data[ary[1]]) > 0){
			est = ary[0];
		    }
		    else{
			est = ary[1];
		    }
		    if(data[est].compareTo(data[x]) > 0){
			swap(x, est);
		    }
		}
		else{
		    if(data[ary[0]].compareTo(data[ary[1]]) < 0){
			est = ary[0];
		    }
		    else{
			est = ary[1];
		    }
		    if(data[est].compareTo(data[x]) < 0){
			swap(x, est);
		    }
		}
	    }
	    if(ary[0] < size()){
		    x = est;
	    }
	}
	return str;
    }

    public String peek(){
	return data[0];
    }	
	    
			    
	
	

    public static void main(String[] args){
	MyHeap max = new MyHeap(true);
	max.add("apple");
	max.add("doughnut");
	max.add("carrot");
	max.add("egg");
	System.out.println(max);
	max.remove();
	System.out.println(max);
	MyHeap min = new MyHeap(false);
	min.add("doughnut");
	min.add("carrot");
	min.add("egg");
	min.add("apple");
	System.out.println(min);
	min.remove();
	System.out.println(min);
    }
		    
	
	    

}
