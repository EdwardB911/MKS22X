import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class FrontierStack{

    private LinkedList<Location> data;

    public FrontierStack(){
	data = new LinkedList();
    }

    public void add(Location l){
	data.addFirst(l);
    }

    public void remove(){
	data.removeFirst();
    }

}
