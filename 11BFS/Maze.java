import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int targetX,targetY;
    private Frontier f;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    // Methods from old MazeSolver
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }
    public void clearTerminal(){
	System.out.println(clear);
    }
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    // Constructor
    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	    if(c == 'E'){
		targetX = i % maxx;
		targetY = i / maxx;
	    }
	}
    }

    public String toString(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(32,40)+c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }

    // METHODS

    // Mode 0 = BFS  &  Mode 1 = DFS
    
    public boolean solve(boolean animate, int mode){
	int x = startx;
	int y = starty; 
	Frontier f = new Frontier(mode);
	Coordinate c = new Coordinate(x,y);
	f.add(c);

	while( x != targetX || y != targetY){
	    
	    for(int i = f.getHead(); i < f.getTail(); i++){
		
        	x = f.getFirst().getX();
		y = f.getFirst().getY();

		if(checkAround(x+1,y)){
		    c = new Coordinate(x+1,y);
		    f.add(c);
		} else if (checkAround(x-1,y)){
		    c = new Coordinate(x-1,y);
		    f.add(c);
		} else if (checkAround(x,y+1)){
		    c = new Coordinate(x+1,y);
		    f.add(c);
		} else if (checkAround(x,y-1)){
		    c = new Coordinate(x,y-1);
		    f.add(c);
		}
		
		f.remove();
	    }   
	}
	return true;	
    }
    

    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }

    public boolean solveDFS(boolean animate){
	return solve(animate,1);
    }

    public boolean checkAround(int x, int y){
	if(maze[x][y] != '.' && maze[x][y] == ' '){
	    return true;
	}else{
	    return false;
	}
    }   
    
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called
     (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    /*public int[] solutionCoordinates(){ 
	
      }*/
    
    public static void main(String[]args){
	Maze m = new Maze("data1.dat");
	System.out.println(m);
    }

}
