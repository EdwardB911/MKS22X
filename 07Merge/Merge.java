public class merge{

    public static void merge(data, temp, lo, mid, shift, high){
	int x = lo;
	int y = shift;
	int place = lo
	while(x <= mid || y <= high){
	    if(x > mid){
		temp[place] = data[y];
		y++;
	    }
	    else if(y > mid){
		temp[place] = data[x];
		x++;
	    }
	    else{
		int a = data[x];
		int b = data[y];
		if(a < b){
		    temp[place] = data[x];
		    x++;
		}
		else{
		    temp[place] = data[y];
		    y++;
		}
	    }
	    place++
	}
    }

    
			
