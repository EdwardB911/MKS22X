import java.util.*;
import java.io.*;

public class Driver{

    public static void main(String[]args) throws FileNotFoundException{

        Maze f;

        f = new Maze("noSolution.txt");//true animates the maze.
	
        f.setAnimate(true);

        f.solve();
	
        System.out.println(f);

    }

}
