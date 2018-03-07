import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private boolean animate;
    private int[][] moves = {{0,1},{1,0},{-1,0},{0,-1}};
    
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

    public Maze(String filename) throws FileNotFoundException{
	maze = convert(filename);
	setAnimate(false);
	int S = 0;
	int E = 0;
	for(int x = 0; x < maze.length; x++){
	    for(int y = 0; y < maze[0].length; y++){
		if(maze[x][y] == 'S'){
		    S = S + 1;
		}
		if(maze[x][y] == 'E'){
		    E = E + 1;
		}
	    }
	}
	if(S != 1 || E != 1){
	    throw new IllegalStateException();
	}
    }

    public int solve(){
	int row = -1;
	int col = -1;
	for(int x = 0; x < maze.length; x++){
	    for(int y = 0; y < maze[0].length; y++){
		if (maze[x][y] == 'S'){
		    row = x;
		    col = y;
		}
	    }
	}
	return solve(row, col);
    }

    public int solve(int row, int col){
	if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

	if(maze[row][col] == 'E'){
	   int count = 0;
	   for(int x = 0; x < maze.length; x++){
	       for(int y = 0; y < maze[0].length; y++){
		   if(maze[x][y] == '@'){
		       count = count + 1;
		   }
	       }
	   }
	   return count;
	}
	
	maze[row][col] = '@';

	for(int x = 0; x <= 4; x++){
	    if(x == 4){
		maze[row][col] = '.';
		for(int y = 0; y < 4; y++){
		    if(maze[row - moves[y][0]][col - moves[y][1]] == '@'){
			return solve(row - moves[y][0], col - moves[y][1]);
		    }
		}
		return -1;
	    }
	    else if(maze[row + moves[x][0]][col + moves[x][1]] == ' ' || maze[row +moves[x][0]][col + moves[x][1]] == 'E'){
		int y = x;
		x = 5;
		return solve(row + moves[y][0], col + moves[y][1]);
	    }
	}
	return -1;
    }			     
	    


    public static void main(String[] args) throws FileNotFoundException{
	try{
	    Maze m = new Maze(args[0]);
	    m.solve();
	}
	catch(ArrayIndexOutOfBoundsException f){
	    System.out.println("There is no file");
	}	
    }

  
}
