public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);      
    }

    //Default to BFS
    public boolean solve(){
	return solve(0);
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false

	if(mode == 0){
	    frontier = new FrontierQueue();
	}
	else if(mode == 1){
	    frontier = new FrontierStack();
	}

	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location L = frontier.next();
	    if (L.getRow() == maze.getEnd().getRow() && L.getCol() == maze.getEnd().getCol()){
		maze.set(L.getRow(),L.getCol(), 'E');
		while (L.getPrevious() != null){
		    Location N = L.getPrevious();
		    maze.set(N.getRow(),N.getCol(), '@');
		    System.out.println(maze.toString());
		    L = N;
		}
		maze.set(maze.getStart().getRow(), maze.getStart().getCol(), 'S');
		System.out.println(maze);
		return true;
	    }
	    maze.set(L.getRow(), L.getCol(), '.');
	    System.out.println(maze.toString());
	    Location[] ary = maze.getNeighbors(L);
	    for(Location X : ary){
		try{
		    maze.set(X.getRow(),X.getCol(), '?');
		    System.out.println(maze.toString());
		    frontier.add(X);
		}
		catch(NullPointerException e){}
	    }
	}      
	return false;
    }
    
    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args){
	MazeSolver a = new MazeSolver("data2.dat");
	a.solve();    
    }
}
