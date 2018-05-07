import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class FrontierStack implements Frontier{

    private LinkedList<Location> data;

    public FrontierStack(){
	data = new LinkedList();
    }

    public void add(Location l){
	data.addFirst(l);
    }

    public Location next(){
	return data.removeFirst();
    }

    public boolean hasNext(){
	return data.size() > 0;
    }

}
