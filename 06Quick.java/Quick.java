import java.util.*;
import java.io.*;

public class Quick{

    private static void swap(int[]ary,int a, int b){                    
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }

    public static void part(int[] data, int start, int end){
	Random rand = new Random();
	int n = start + rand.nextInt(end - start);
	System.out.println(data[n]);
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
    }

    public static void main(String[] args){
	int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
	part(ary, 0, 10);
	System.out.println(Arrays.toString(ary));
    }




}
