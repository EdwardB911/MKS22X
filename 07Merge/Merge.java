import java.util.*;
import java.io.*;

public class Merge{

    public static void merge(int[] data,int[] temp,int lo,int mid, int high){
	int x = lo;
	int y = mid + 1;
	for(int place = lo; place <= high; place++){
	    if (x > mid){
		temp[place] = data[y];
		y++;
	    }
	    else if (y > high){
		temp[place] = data[x];
		x++;
	    }
	    else{
		if (data[x] < data[y]){
		    temp[place] = data[x];
		    x++;
		}
		else{
		    temp[place] = data[y];
		    y++;
		}
	    }
	}
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	for(int x = 0; x < data.length; x++){
	    temp[x] = data[x];
	}
	msort(data, temp , 0, data.length - 1);
    }

    public static void insertionSort(int[] ary){
	insertionSort(ary, 0, ary.length);
    }

    private static void swap(int[]ary,int a, int b){                    
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    public static void insertionSort(int[] ary, int start, int end){
	for(int x = start + 1; x < end; x++){
	    for (int y = x; y > 0; y--){
		if(ary[y] < ary[y-1]){
		    swap(ary, y-1, y);
		}
	    }
	}
    }

    // public static void msort(int[] data, int[] temp, int lo, int hi){
    // 	if (lo < hi){
    // 	    int mdpt = (lo + hi)/2;
    // 	    msort(temp, data, lo, mdpt);
    // 	    msort(temp, data, mdpt + 1, hi);
    // 	    merge(temp, data, lo, mdpt, hi);
    // 	}
    // }

     public static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo < hi){
	    int mdpt = (lo + hi)/2;
	    msort(temp, data, lo, mdpt);
	    msort(temp, data, mdpt + 1, hi);
	    merge(temp, data, lo, mdpt, hi);
	}
    }

	

    public static void main(String[] args){
	int[] a = {4,2,8,1,6,3};	
	insertionSort(a);
	System.out.println(Arrays.toString(a));
    }





}

    
			
