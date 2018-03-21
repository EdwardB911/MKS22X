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
	mergesort(a);
	System.out.println(Arrays.toString(a));
    }





}

    
			
