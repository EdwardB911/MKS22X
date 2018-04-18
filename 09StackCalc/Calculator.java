public class Calculator{

    public static double eval(String s){
	String[] ary = s.split(" ");
	for(String str : ary){
	    System.out.println(str);
	}
	return 2;
    }

    public static void main(String[] args){
	eval("11 3 - 4 + 2.5 *");
    }
    
}
