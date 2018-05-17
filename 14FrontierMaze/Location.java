import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")


public class Location implements Comparable<Location>{

    private int row,col;

    private Location previous;

    private int distance;

    private int distanceSoFar;

    private boolean aStar;

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

    public Location(Location l, int dist, boolean Star){
	row = l.getRow();
	col = l.getCol();
	aStar = Star;
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
	// System.out.println(distanceSoFar);
	return distanceSoFar;	
    }

    public Location getPrevious(){
	return previous;
    }

    public int compareTo(Location l){
	if(aStar){
	    return distance + distanceSoFar - l.getDistance() - l.getDistanceSoFar();
	}
	else{
	    return distance - l.getDistance();
	}
    }

    public String toString(){
	return "" + getRow() + ", " + getCol() + ", " + getDistance();
    }


}
