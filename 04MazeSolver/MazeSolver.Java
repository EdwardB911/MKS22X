import java.util.*;
import java.io.*;

public class MazeSolver{

    private char[][]maze;
    private boolean animate;
    
    public static char[][] convert(String name) throws FileNotFoundException {
	File text = new File(name);
	Scanner inf = new Scanner(text);
	int rows = -1;
	int cols = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    rows = rows + 1;
	    for(int c = 0; c < line.length();c++){
		cols = line.length();
	    }
	}
	char[][] ary = new char[rows][cols];
	String str = "";
	Scanner foo = new Scanner(text);
	while(foo.hasNextLine()){
	    String line = foo.nextLine();
	    str = str + line;
	}
	for(int x = 0; x < rows * cols; x++){
	    ary[x/cols][x%cols] = str.charAt(x);
	}
	return ary;
    }

     private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
	String str = "";
	for(int x = 0; x < maze.length; x++){
	    for(int y = 0; y < maze[0].length; y++){
		str = str +  maze[x][y];
	    }
	    str = str + "\n";
	}
	return str;
    }

  
}
