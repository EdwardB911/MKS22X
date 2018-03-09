public class USACO{

    public static int[][] stomp(int[][] nums, int row, int col, int depth){
	int max = -1;
	for(int x = row; x <= row + 2; x++){
	    for(int y = col; y <= col + 2; y++){
		if (nums[x][y] > max){
		    max = nums[x][y];
		}
	    }
	}
	for(int x = row; x <= row + 2; x++){
	    for(int y = col; y <= col + 2; y++){
		if(nums[x][y] > (max - depth)){
		    nums[x][y] = (max - depth);
		}
	    }
	}
	return nums;
    }

    public static int[][] depths(int[][] nums, int depth){
	for(int x = 0; x < nums.length; x++){
	    for(int y = 0; y < nums[0].length; y++){
		if(depth - nums[x][y] < 0){
		    nums[x][y] = (depth - nums[x][y]);
		}
		else{
		    nums[x][y] = 0;
		}
	    }
	}
	return nums;
    }

    public static int[] parameters(String str){
	String[] ary = str.split(" ", 0);
	int[] params = new int[ary.length];
	    for(int x = 0; x < ary.length; x++){
		params[x] = Integer.parseInt(ary[x]);
	    }
	return params;
    }
	



    
}
		
