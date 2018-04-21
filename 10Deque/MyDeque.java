public class MyDeque<E>{

    private E[] data;
    private int size;
    private int front;
    private int back;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
	size = 0;
	front = 0;
	back = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity){
	if(capacity <= 0){
	    throw new IllegalArgumentException() ;
	}
	data =(E[])new Object[capacity];
	size = 0;
	front = 0;
	back = 0;
    }

    public int size(){
	return size;
    }

}
