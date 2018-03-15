import java.util.*;
import java.io.*;

public class Quick{

    private static void swap(int[]ary,int a, int b){                    
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    public static int part(int[] data, int start, int end){
	Random rand = new Random();
	int n = start + rand.nextInt(end - start);
	int x = data[n];
	swap(data, start, n);
	int small = start + 1;
	int large = end;
	while(small <= large){
	    if(data[small] < data[start]){
		small = small + 1;
	    }
	    else{
		swap(data, small, large);
		large = large -1;
	    }
	}
	swap(data, start, large);
	return large;
    }

    public static int quickSelect(int[] data, int k){
	int n = part(data, 0, data.length -1);
	if(n < k){
	    int[] ary = new int[data.length - 1 - n];
	    for(int x = 0; x < ary.length; x++){
		ary[x] = data[n + x + 1];
	    }
	    return quickSelect(ary, k - n + 1);
	}
	else if(n > k){
	    int[] ary = new int[n - 1];
	    for(int x = 0; x < ary.length; x++){
		ary[x] = data[x];
	    }
	    return quickSelect(ary, k);
	}
	else{
	    return data[k];
	}
    }

    public static void main(String[] args){
	int[] ary = { 2, 10, 15, 23, 0,  5};
	for(int x = 0; x < 6; x++){
	    System.out.println(quickSelect(ary, x));
	}
    }
    
}
