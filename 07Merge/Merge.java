import java.util.*;
import java.io.*;

public class Merge{

    public static void merge(int[] data,int[] temp,int lo,int mid,int shift,int high){
	int x = lo;
	int y = shift;
	int place = lo;
	while(x <= mid || y <= high){
	    if(x > mid){
		temp[place] = data[y];
		y++;
	    }
	    else if(y > mid){
		temp[place] = data[x];
		x++;
	    }
	    else{
		int a = data[x];
		int b = data[y];
		if(a < b){
		    temp[place] = data[x];
		    x++;
		}
		else{
		    temp[place] = data[y];
		    y++;
		}
	    }
	    place++;
	}
    }

    public static void main(String[] args){
	int[] a = {0,5,1,2,4};
	int[] b = {6,6,6,6,6};
	merge(a,b,0,2,3,4);
	System.out.println(Arrays.toString(b));
    }





}

    
			
