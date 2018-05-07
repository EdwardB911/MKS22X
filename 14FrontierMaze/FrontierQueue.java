import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class FrontierQueue implements Frontier{

    private LinkedList<Location> data;

    public FrontierQueue(){
	data = new LinkedList();
    }

    public void add(Location l){
	data.addFirst(l);
    }

    public Location next(){
	return data.removeLast();
    }

    public boolean hasNext(){
	return data.size() > 0;
    }

}
