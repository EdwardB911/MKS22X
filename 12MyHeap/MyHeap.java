public class MyHeap{

    private String[] data;
    private boolean isMax;
    private int size;

    public MyHeap(){
	data = new String[10];
	isMax = true;
	size = 0;
    }

    public MyHeap(boolean b){
	data = new String[10];
	isMax = b;
	size = 0;
    }

    public int size(){
	return size;
    }

    
	    

}
