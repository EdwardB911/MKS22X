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
	    return fibHelper(n)[0];
	}
    }

    public static int[] fibHelper(int n){
	if (n == 0 || n == 1){
	    int[] now = {n,0};
	    return now;
	}
	else{
	    int[] before = fibHelper(n - 1);
	    int[] now = {before[0] + before[1], before[0]};
	    return now;
	}
    }

    public static double percentError(double measured, double accepted){
	return ((measured - accepted)/accepted);
    }

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("n < 0");
	}
	else{
	    return sqrtHelper(n , 1);
	}
    }

    public static double sqrtHelper(double n, double guess){
	if (percentError(guess * guess, n) < 0.000001){
		return guess;
	}
	else{
	    return (n/guess + guess)/2;
	}
    }
		    
		

    public static void main(String[] args){
	System.out.println(sqrt(100));
	System.out.println(sqrt(1));
	System.out.println(sqrt(-1));
    }
}
