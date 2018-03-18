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
	if(end - start == 0){
	    return n;
	}
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

    public static int badQuickSelect(int[] data, int k){
	int n = part(data, 0, data.length -1);
	if(n < k){
	    int[] ary = new int[data.length - 1 - n];
	    for(int x = 0; x < ary.length; x++){
		ary[x] = data[n + x + 1];
	    }
	    return badQuickSelect(ary, k - n + 1);
	}
	else if(n > k){
	    int[] ary = new int[n - 1];
	    for(int x = 0; x < ary.length; x++){
		ary[x] = data[x];
	    }
	    return badQuickSelect(ary, k);
	}
	else{
	    return data[k];
	}
    }

    public static int[] partition(int[] data, int lo, int hi){
	Random rand = new Random();
	int n = lo + rand.nextInt(hi - lo);
	int lt = lo;
	int i = lo + 1;
	int gt = hi;
	int pivot = data[n];
	swap(data, lo, n); 
	while(i <= gt){
	    if (data[i] == pivot){
		i = i + 1;
	    }
	    else if (data[i] >  pivot){
		swap(data, i, gt);
		gt = gt - 1;
	    }
	    else{
		swap(data, i, lt);
		lt = lt + 1;
		i = i+1;
	    }
	}
	int[] ary = {lt,gt};
	return ary;
    }

    public static int quickSelect(int[] data, int k){
	int[] ary = partition(data, 0, data.length - 1);
	if(ary[0] <= k && k <= ary[1]){
	    return data[k];
	}
	else if(k < ary[0]){
	    int[] sub = new int[ary[1]];
	    for(int x = 0; x < sub.length ;x++){
		sub[x] = data[x];
	    }
	    return quickSelect(sub, k);
	}
	else{
	    int[] sub = new int[data.length - ary[1] - 1];
	    for(int x = 0; x < sub.length; x++){
		sub[x] = data[ary[1] + 1 + x];
	    }
	    return quickSelect(sub, k - ary[1] - 1);
	}
	    
    }

    public static void main(String[] args){
	int[] ary = { 2, 1, 2, 0, 1, 0,  2, 1, 0};
	System.out.println(quickSelect(ary, 4));
	System.out.println(Arrays.toString(ary));
    }
    
}
