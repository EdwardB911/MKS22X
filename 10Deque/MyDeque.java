public class MyDeque<E>{

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
	size = 0;
    }

}
