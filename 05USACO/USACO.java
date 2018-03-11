import java.util.*;
import java.io.*;

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
		if(depth - nums[x][y] > 0){
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

    public static int bronze(String str) throws FileNotFoundException{
	File text = new File(str);
	Scanner inf = new Scanner(text);
	String rules = inf.nextLine();
	int[] params = parameters(rules);
	int R = params[0];
	int C = params[1];
	int E = params[2];
	int N = params[3];
	int[][] plot = new int[R][C];
	for(int x = 0; x < R; x++){
	    String line = inf.nextLine();
	    int[] temps = parameters(line);
	    for(int y = 0; y < C; y++){
		plot[x][y] = temps[y];
	    }
	}
       	for(int x = 0; x < N; x++){
	    String line = inf.nextLine();
	    int[] temps = parameters(line);
	    plot = stomp(plot, temps[0] - 1, temps[1] - 1, temps[2]);
	}
	plot = depths(plot, E);
	int sum = 0;
	for(int x = 0; x < plot.length; x++){
	    for(int y = 0; y < plot[0].length; y++){
		sum = sum + plot[x][y];
	    }
	}
	return (sum * 5184);
    }

    public static void main(String[] args) throws FileNotFoundException{
	System.out.println(silver("ctravel.in"));
    }

    public static int silver(String str) throws FileNotFoundException{
	File text = new File(str);
	Scanner inf = new Scanner(text);
	String rules = inf.nextLine();
	int[] params = parameters(rules);
	int N = params[0];
	int M = params[1];
	int T = params[2];
	char[][] plot = new char[N][M];
	int[][] oldNums = new int[N][M];
	int[][] newNums = new int[N][M];
	for(int x = 0; x < N; x++){
	    String line = inf.nextLine();
	    for(int y = 0; y < M; y++){
		plot[x][y] = line.charAt(y);
	    }
	}
	rules = inf.nextLine();
	int[] instructions = parameters(rules);
	int R1 = instructions[0];
	int C1 = instructions[1];
	int R2 = instructions[2];
	int C2 = instructions[3];
	newNums[R1 - 1][C1 - 1] = 1;
	for(int x = 0; x < T; x++){
	    for(int row = 0; row < N; row++){
		for(int col = 0; col < M; col++){
		    oldNums[row][col] = newNums[row][col];
		}
	    }
	    for(int row = 0; row < N; row++){
		for(int col = 0; col < M; col++){
		    if(plot[row][col] == '*'){
			newNums[row][col] = 0;
		    }
		    else{
			try{
			    newNums[row][col] += oldNums[row + 1][col];
			}
			catch(IndexOutOfBoundsException e){}
			try{
			    newNums[row][col] += oldNums[row - 1][col];
			}
			catch(IndexOutOfBoundsException e){}
			try{
			    newNums[row][col] += oldNums[row][col + 1];
			}
			catch(IndexOutOfBoundsException e){}
			try{
			    newNums[row][col] += oldNums[row][col -1];
			}
			catch(IndexOutOfBoundsException e){}
		    }
		}
	    }
	}
	return newNums[R2 -1][C2 -1];
    }
	    
	



    
}
		
