public class Recursion{

    public static int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException("n < 0");
	}
	if (n == 0){
	    return 1;
	}
	else{
	    return n * fact(n - 1);
	}
    }

    public static int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException("n < 0");
	}
	if(n == 0){
	    return 0;
	}
	if(n == 1){
	    return 1;
	}
	else{
	    return fibhelper(n)[0];
	}
    }

    public static int[] fibhelper(int n){
	if (n == 0 || n == 1){
	    int[] now = {n,0};
	    return now;
	}
	else{
	    int[] before = fibhelper(n - 1);
	    int[] now = {before[0] + before[1], before[0]};
	    return now;
	}
    }
		

    public static void main(String[] args){
	System.out.println(fib(0));
	System.out.println(fib(3));
  	System.out.println(fib(5));
	System.out.println(fib(40));
	System.out.println(fact(-1));
    }
}
