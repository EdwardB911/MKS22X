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
	String str = ""
	for(int row = 0; row < board.length; row ++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] == -1){
		    str = str + "Q";
		}
		else{
		    str = str + "_";
		}
	    }
	    str = str + "\n";
	}
    }

    

}
