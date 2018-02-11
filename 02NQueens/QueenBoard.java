public class QueenBoard{

    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < size; x++){
	    for(int y = 0; y < size; y++){
		board[x][y] = 0;
	    }
	}
    }

    public String toString(){
	String str = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] == -1){
		    str = str + "Q ";
		}
		else{
		    str = str + "_ ";
		}
	    }
	    str = str + "\n";
	}
	return str;
    }

    public String display(){
	String str = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] == -1){
		    str = str + "Q ";
		}
		else{
		    str = str + board[row][col] + " ";
		}
	    }
	    str = str + "\n";
	}
	return str;
    }

    
    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	else{
	    board[row][col] = -1;
	    for(int x = 1; (col + x < board.length); x++){
		board[row][col + x] += 1;
	    }
	    for(int x = 1; (row - x > -1) && (col + x < board.length); x++){
	    	board[row - x][col + x] += 1;
	    }
	    for(int x = 1; (row + x < board.length) && (col + x < board.length); x++){
	    	board[row + x][col + x] += 1;
	    }
	    return true;
	}
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] == -1){
	    board[row][col] = 0;
	    for(int x = 1; (col + x < board.length); x++){
		board[row][col + x] -= 1;
	    }
	    for(int x = 1; (row - x > -1) && (col + x < board.length); x++){
	    	board[row - x][col + x] -= 1;
	    }
	    for(int x = 1; (row + x < board.length) && (col + x < board.length); x++){
	    	board[row + x][col + x] -= 1;
	    }
	    return true;
	}
	else{
	    return false;
	}
    }

    public boolean solve(){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp(0,0,0);
    }

    public boolean solveHelp(int row, int col, int queens){
	if (queens == board.length){
	    return true;
	}
	else if(col < 0){
	    return false;
	}
	else if(row >= board.length){
	    int y = 0;
	    for(int x = 0; x < board.length; x++){
		if(board[x][col - 1] == -1){
		    y = x;
		}
	    }
	    removeQueen(y, col - 1);
	    return solveHelp(y + 1, col - 1, queens - 1);
	}
	else if(board[row][col] == 0){
	    addQueen(row,col);
	    return solveHelp(0, col + 1, queens + 1);
	}
	else{
	    return solveHelp(row + 1, col, queens);
	}
    }
		
		
		

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(8);
	a.solve();
	System.out.println(a.display());
	System.out.println(a.toString());
    }

}
