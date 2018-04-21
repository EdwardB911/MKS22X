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

    public String toString(){ 
 	String line = "["; 
 	for(int x = front; x <= back; x++){ 
 	    if(x == data.length){ 
 		x = 0; 
 	    } 
 	    line += data[x] + ","; 
 	} 
 	return line + "]"; 
    } 


    public void addFirst(E value){
	if (size == 0){
	    data[0] = value;
	    front = 0;
	    back = 0;
	}
	else if(front == 0){
	    int x = data.length - 1;
	    data[x] = value;
	    front = x;
	}
	else{
	    data[front - 1] = value;
	    front = front - 1;
	}
	size = size + 1;
    }
	
	    

}
