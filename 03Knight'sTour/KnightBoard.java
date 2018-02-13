public class KnightBoard{

    public int[] board;

    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    board = new int[startingRows][startingCols];
	}
		

    
}
