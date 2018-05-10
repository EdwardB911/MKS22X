@SuppressWarnings("unchecked")

public class FrontierPriorityQueue implements Frontier{

    private MyHeap<Location> data;

    public FrontierPriorityQueue(){
	data = new MyHeap(false);
    }

    public void add(Location l){
	data.add(l);
    }

    public Location next(){
	return data.remove();
    }

    public boolean hasNext(){
	return data.size() > 0;
    }
}
    
