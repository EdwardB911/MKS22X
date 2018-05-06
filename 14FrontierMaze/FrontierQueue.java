import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class FrontierQueue{

    private LinkedList<Location> data;

    public FrontierQueue(){
	data = new LinkedList();
    }

    public void add(Location l){
	data.addFirst(l);
    }

    public void remove(){
	data.removeLast();
    }

}
