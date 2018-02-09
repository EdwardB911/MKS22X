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

    

}
