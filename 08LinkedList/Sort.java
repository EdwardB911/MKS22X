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

    }

    public static void hsort(MyLinkedListImproved<Integer> data){
	Integer n = data.max();
	int times = 

    public static void main (String[] args){
	MyLinkedListImproved<Integer> l = new MyLinkedListImproved<Integer>();
	l.add(3);
	l.add(-4);
	l.add(6);
	l.add(-3);
	l.add(1);
	l.add(2);
	l.add(8);
	l.add(-10);
	System.out.println(l.toString());
	radixsort(l);
    }




}
