import java.util.*;
import java.io.*;


public class Sorts{

    private static int parent(int x){
	return ((x - 1)/2);
    }

    private static int[] children(int x){
	int[] ary = new int[2];
	ary[0] = (2 * x) + 1;
	ary[1] = (2 * x) + 2;
	return ary;
    }
    
    private static void swap(int[] data, int a, int b){                       
        int c = data[a];                                                        
        data[a] = data[b];
	data[b] = c;	
    }


    public static void heapify(int[] ary){
	for(int x = 0; x < ary.length; x++){
	    int y = x;
	    while(parent(y) >= 0 && y != 0){
		if(ary[y] > ary[parent(y)]){
		    swap(ary, y, parent(y));
		}
		y = parent(y);
	    }
	}
    }

    public static void main(String[] args){
	int[] ary;
	ary = new int[10];
	for(int x = 0; x < ary.length; x++){
	    ary[x] = (int)(Math.random() * 10);
	}
	heapify(ary);
	System.out.println(Arrays.toString(ary));
    }


    
}

