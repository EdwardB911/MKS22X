public class KnightBoard{

    public int[][] board;
    public int[][] cycle;

    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    board = new int[startingRows][startingCols];
	}
	cycle = new int[][] {{1,2},
			     {2,1},
			     {-1,2},
			     {-2,1},
			     {-2,-1},
			     {-1,-2},
			     {1,-2},
			     {-1,2}};
    }

    public String toString(){
	String str = "";
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[0].length; col++){
		if (board[row][col] < 10){
		    str = str + "0" + board[row][col] + " ";
		}
		else{
		    str = str + board[row][col] + " ";
		}
	    }
	    str = str + "\n";
	}
	return str;
    }

    public boolean solve(int startingRow, int startingCol){
	return solveH(startingRow, startingCol, 1, 0);
    }

    public boolean solveH(startingRow, startingCol, level, choice){
	if (choice > 7){
	    if (level > board.length * board[0].length){
		return true;
	    }
	    if(level == 0){
		return false;
	    }
	    else{
		int row = 0;
		int col = 0;
		for(int x = 0; x < board.length; x++){
		    for(int y = 0; y < board[0].length; y++){
			if(board[x][y] == (level - 1)){
			    row = x;
			    col = y;
			}
		    }
		}
		board[startingRow][startingCol] = 0;
		int oldChoice
		for(int c = 0; c < 8; c++){
		    if(row - startingRow == cycle[c][0] && col - startingCol == cycle[c][1]){
			oldChoice = c;
		    }
		}
		return solveH(row, col, level - 1, choice + 1);		    
	}
	board[startingRow][startingCol] = level;
	if(startingRow + cycle[choice][0] >= board.length || startingCol + cycle[choice][1] >= board.length ||
	   startingRow + cycle[choice][0] < 0 || startingCol + cycle[choice][1] < 0){
	    return SolveH(startingRow, startingCol, level, choice + 1);
	}
	if(board[startingRow + cycle[choice][0]][startingCol + cycle[choice][1]] == 0){
	    return solveH(startingRow + cycle[choice][0], startingCol + cycle[choice][1], level + 1, 0);
	}
	else{
	    return solveH(startingRow, startingCol, level, choice + 1);
	}
	

    public static void main(String[] args){
	KnightBoard brd = new KnightBoard(5, 5);
	System.out.println(brd.toString());
    }	
	 
		
		
		

    
}
