import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MazeConverter{
    public static void main(String[] args) throws FileNotFoundException {
	File text = new File(args[0]);
	Scanner inf = new Scanner(text);
	int rows = 0;
	int cols = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    rows = rows + 1;
	    cols = line.length();
	    System.out.println(line);
	}
	char[][] ary = new char[rows][cols];
	int x = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    for(int y = 0; y < line.length(); y++){
		ary[x][y] = line.charAt(y);
	    }
	    x = x + 1;
	}
	System.out.println(Arrays.deepToString(ary));
    }	    
}
