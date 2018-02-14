public class KnightBoard{

    public int[][] board;

    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    board = new int[startingRows][startingCols];
	}
    }

    public String toString(){
	String str = ""
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[].length){
		if (data[row][col] < 10;){
		    str = str + "0" + data[row][col];
		}
		else{
		    str = str + data[row][col];
		}
	    }
	    str = str + "\n"
	}
    }
		
		
		

    
}
