import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MazeConverter{
    public static void main(String[] args) throws FileNotFoundException {
	File text = new File(args[0]);
	Scanner inf = new Scanner(text);
	int rows = -1;
	int cols = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    rows = rows + 1;
	    for(int c = 0; c < line.length();c++){
		cols = line.length();
		// System.out.println(line.length());
	    }
	    System.out.println(line);
	}
	System.out.println(rows);
	System.out.println(cols);
	char[][] ary = new char[rows][cols];
	String str = "";
	Scanner foo = new Scanner(text);
	while(foo.hasNextLine()){
	    String line = foo.nextLine();
	    str = str + line;
	}
	System.out.println(str);
	for(int x = 0; x < rows * cols; x++){
	    ary[x/cols][x%cols] = str.charAt(x);
	}
	System.out.println(Arrays.deepToString(ary));
    }	    
}
