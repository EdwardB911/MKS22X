import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class Sort{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<Integer>();
	MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<Integer>();
	for(Integer n : data){
	    int index = 0;
	    if (n < 0){
		neg.add(n * -1);
	    }
	    else{
		pos.add(n);
	    }
	}
	System.out.println(neg.toString());
	System.out.println(pos.toString());
	hsort(neg);
	hsort(pos);
	System.out.println(neg.toString());
	System.out.println(pos.toString());

    }

    public static void hsort(MyLinkedListImproved<Integer> data){
	Integer a = data.max();
	int times = (int)(Math.log(a)/Math.log(10));
	times = times + 1;
	for(int x = 1; x <= times; x++){
	    MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	    for(int y = 0; y < 10; y++){
		buckets[y] = new MyLinkedListImproved<Integer>();
	    }
	    for(Integer n : data){
		int pow = 1;
		for(int p = 0; p < x; p++){
		    pow = pow * 10;
		}
	    	int rem = n % pow;
		int dig = rem / (pow / 10);
		System.out.println(dig);
		buckets[dig].add(n);
	    }
	    MyLinkedListImproved<Integer> c = new MyLinkedListImproved<Integer>();
	    for(int y = 0; y < 10; y++){
		c.extend(buckets[y]);
	    }
	    data = c;
	    System.out.println(data);
	}
    }
	    

    public static void main (String[] args){
	MyLinkedListImproved<Integer> l = new MyLinkedListImproved<Integer>();
	l.add(3);
	l.add(-400);
	l.add(60);
	l.add(-30);
	l.add(10);
	l.add(200);
	l.add(8);
	l.add(-10);
	System.out.println(l.toString());
	radixsort(l);
    }




}
