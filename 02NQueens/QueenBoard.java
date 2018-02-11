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
		
		

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	a.addQueen(0,0);
	System.out.println(a.display());
	System.out.println(a.toString());
    }

}
