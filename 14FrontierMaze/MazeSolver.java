public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private String text;    

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	text = mazeText;
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
	else if(mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
	else if(mode == 3){
	    maze = new Maze(text, true);
	    frontier = new FrontierPriorityQueue();
	}
	// adds the start location to the maze
	frontier.add(maze.getStart());
	// while the frontier isn't empty
	while(frontier.hasNext()){
	    // remove and isolate the next location in the frontier
	    Location L = frontier.next();
	    // if the location is the end indicate is as such
	    if (L.getRow() == maze.getEnd().getRow() && L.getCol() == maze.getEnd().getCol()){
		maze.set(L.getRow(),L.getCol(), 'E');
		// then trace the path from the end to the start
		while (L.getPrevious() != null){
		    Location N = L.getPrevious();
		    maze.set(N.getRow(),N.getCol(), '@');
		    System.out.println(maze.toString());
		    L = N;
		}
		// indicate the start
		maze.set(maze.getStart().getRow(), maze.getStart().getCol(), 'S');
		System.out.println(maze);
		return true;
	    }
	    // if the location isn't the end try it out
	    maze.set(L.getRow(), L.getCol(), '.');
	    System.out.println(maze.toString());
	    // get its possible neighbors
	    Location[] ary = maze.getNeighbors(L);
	    // add the valid neighbors
	    for(Location X : ary){
		try{
		    maze.set(X.getRow(),X.getCol(), '?');
		    System.out.println(maze.toString());
		    frontier.add(X);
		}
		catch(NullPointerException e){}
	    }
	}
	// if the frontier is empty return false
	return false;
    }
    
    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args){
	MazeSolver a = new MazeSolver("data3.dat");
	a.solve(3);    
    }
}
