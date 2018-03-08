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



    
}
		
