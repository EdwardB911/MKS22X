import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")


public class Location{

    private int row,col;

    private Location previous;

    public Location(int x, int y, Location prev){
	row = x;
	col = y;
	previous = prev;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrevious(){
	return previous;
    }

}
