import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class RunningMedian{

    private MyHeap<Double> smalls;
    private MyHeap<Double> bigs;

    public RunningMedian(){
	smalls = new MyHeap();
	bigs = new MyHeap(false);
    }

    public void add(Double d){
	if(smalls.size() == 0 && bigs.size() == 0){
	    smalls.add(d);
	}
	else if(smalls.size() == 0 && bigs.size() == 1){
	    smalls.add(d);
	}
	else if(smalls.size() == 1 && bigs.size() == 0){
	    bigs.add(d);
	}
	else if(d > smalls.peek()){
	    bigs.add(d);
	    if(bigs.size() - smalls.size() == 2){
		smalls.add(bigs.remove());
	    }
	}
	else{
	    smalls.add(d);
	    if(smalls.size() - bigs.size() == 2){
		bigs.add(smalls.remove());
	    }
	}
    }

    public int size(){
	return bigs.size() + smalls.size();
    }

    public Double getMedian(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	if(smalls.size() == bigs.size()){
	    return (smalls.peek() + bigs.peek())/2;
	}
	else if(smalls.size() > bigs.size()){
	    return smalls.peek();
	}
	else{
	    return bigs.peek();
	}
    }    

}
