import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")


public class Location implements Comparable<Location>{

    private int row,col;

    private Location previous;

    private int distance;

    public Location(int x, int y, Location prev){
	row = x;
	col = y;
	previous = prev;
    }

    public Location(int x, int y, Location prev, int dist){
	row = x;
	col = y;
	previous = prev;
	distance = dist;
    }

    public Location(Location l, int dist){
	row = l.getRow();
	col = l.getCol();
	previous = l.getPrevious();
	distance = dist;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistance(){
	return distance;
    }

    public Location getPrevious(){
	return previous;
    }

    public int compareTo(Location l){
	return distance - l.getDistance();
    }

}
