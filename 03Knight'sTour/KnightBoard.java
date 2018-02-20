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
			     {2,-1}};
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
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board[0].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if(startingRow >= board.length || startingCol >= board[0].length ||
	   startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
	}
	return solveH(startingRow, startingCol, 1, 0);
    }

    public boolean solveH(int startingRow, int startingCol, int level, int choice){
	System.out.println(Text.go(1,1));
	System.out.println(this);
	Text.wait(100); //adjust this delay
	if (choice > 7){
	    if (level >= board.length * board[0].length){
		return true;
	    }
	    if(level == 0){
	    	return false;
	    }
	    else{
		board[startingRow][startingCol] = 0;
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
		int oldChoice = -2;
		for(int c = 0; c < 8; c++){
		    if(startingRow - row == cycle[c][0] && startingCol - col == cycle[c][1]){
			oldChoice = c;
		    }
		}
		try{
		return solveH(row, col, level - 1, oldChoice + 1);
		}
		catch(IndexOutOfBoundsException ex){
		    return false;
		}		    
	    }
	}
	board[startingRow][startingCol] = level;
	if(startingRow + cycle[choice][0] >= board.length || startingCol + cycle[choice][1] >= board[0].length ||
	   startingRow + cycle[choice][0] < 0 || startingCol + cycle[choice][1] < 0){
	    return solveH(startingRow, startingCol, level, choice + 1);
	}
	if(board[startingRow + cycle[choice][0]][startingCol + cycle[choice][1]] == 0){
	    return solveH(startingRow + cycle[choice][0], startingCol + cycle[choice][1], level + 1, 0);
	}
	else{
	    return solveH(startingRow, startingCol, level, choice + 1);
	}
    }
	
	

    public static void main(String[] args){
	KnightBoard brd = new KnightBoard(3, 4);
	brd.solve(0,0);
	System.out.println(brd.toString());
    }	
	 
		
		
		

    
}
