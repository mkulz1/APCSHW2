public class Maze{

    public char[][] mazeSolve(char[][] maze){
	// find starting coordinates
	int x = 0;
	int y = 0;
	// copy maze
	char[][] mazeCopy = new char[maze.length][maze[0].length];
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze[i].length; j++){
		mazeCopy[i][j] = maze[i][j];
	    }
	}
	return mazeHelper(mazeCopy, x, y);
    }

    public char[][] mazeHelper(char[][] maze, int x, int y){
	return maze;
    }

    public static void main(String [] args) {

    }  


}
