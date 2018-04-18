import java.util.*;
import java.io.*;

public class Calculator{

    public static double eval(String s){
	String[] ary = s.split(" ");
	LinkedList<Double> l = new LinkedList<>();
	for(String str : ary){
	    char x = str.charAt(0);
	    if(Character.isDigit(x)){
		double i = Double.parseDouble(str);
		l.push(i);
	    }
	    else if(x == '+'){
		double a = l.pop();
		double b = l.pop();
		l.push(b + a);
	    }
	    else if(x == '-'){
		double a = l.pop();
		double b = l.pop();
		l.push(b - a);
	    }
	    else if(x == '*'){
		double a = l.pop();
		double b = l.pop();
		l.push(b * a);
	    }
	    else if(x == '/'){
		double a = l.pop();
		double b = l.pop();
		l.push(b / a);
	    }
	    else if(x == '%'){
		double a = l.pop();
		double b = l.pop();
		l.push(b % a);
	    }			   
	}
	return l.getFirst();
    }

    public static void main(String[] args){
	System.out.println(eval("10 2.0 +"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
    }
    
}
