import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")


public class Location implements Comparable<Location>{

    private int row,col;

    private Location previous;

    private int distance;

    private int distanceSoFar;

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
	if(l.getPrevious() == null){
	    distanceSoFar = 0;
	}
	else{
	    distanceSoFar = l.getPrevious().getDistanceSoFar() + 1;
	}
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

    public int getDistanceSoFar(){
	return distanceSoFar;
    }

    public Location getPrevious(){
	return previous;
    }

    public int compareTo(Location l){
	return distance - l.getDistance();
    }


}
