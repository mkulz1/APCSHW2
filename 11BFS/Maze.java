import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private Frontier f;
    private int[] solution;
    private Coordinate t;
    private int path;
    private boolean solved;
    private static Coordinate target;
    private Frontier sol;

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
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
	findE();
    }

    // TO STRING METHODS
    public String toString(){
	String ans = "Solving a maze that is " + maxy + " by " + maxx + "\n";
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
    public String toString(boolean animate){
	if (animate){
	    return hide + clear + go(0,0) + toString() + show;
	}else{
	    return toString();
	}
    }

    // METHODS

    // Mode 0 = BFS  &  Mode 1 = DFS & Mode 2 = Best
    
    public boolean solve(boolean animate, int mode){
	Frontier f = new Frontier(mode);
	Coordinate start = new Coordinate(startx,starty,0);
	System.out.println("Start: " + start);
	System.out.println("Real Target: " + target);
	f.setEnd(target);
	System.out.println("Target: " + f.getEnd());
	path = 0;
	f.add(start);
	
	while(!solved && !f.empty()){
	    
	    if (animate){
		wait(2);
		System.out.println(toString(animate));
		//	System.out.println(f); //for testing 
	    }
	    
	    Coordinate c = f.remove();
	    int x = c.getX();
	    int y = c.getY();
	    
	    if (checkSpot(x,y)){

		if (maze[x][y] == 'E'){
		    t = c;
		    Coordinate hold = t;
		    while ( hold != null){
			path ++;
			hold = hold.getPrevious();
		    }
		    solved = true;	  
		} else {
		    maze[x][y] = '.';
		    // Possible spots
		    Coordinate[] coord = new Coordinate[]{
			new Coordinate(x-1,y,c.getSteps()+1),
			new Coordinate(x+1,y,c.getSteps()+1),
			new Coordinate(x,y-1,c.getSteps()+1),
			new Coordinate(x,y+1,c.getSteps()+1),
		    };
		    for(Coordinate hey : coord){
			hey.setPrevious(c);
			int xx = hey.getX();
			int yy = hey.getY();
			if(checkSpot(xx,yy))
			    f.add(hey);
		    }
		}   
	    }
	}
	return solved;
    }
    

    /// SOLVE METHODS
    public boolean solveBFS(){
	return solve(false,0);
    }
    public boolean solveDFS(){
	return solve(false,1);
    }
    public boolean solveBest(){
	return solve(false,2);
    }
    public boolean solveAStar(){
	return solve(false,3);
    }
    
    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }
    public boolean solveDFS(boolean animate){
	return solve(animate,1);
    }
    public boolean solveBest(boolean animate){
	return solve(animate,2);
    }
    public boolean solveAStar(boolean animate){
	return solve(animate,3);
    }
    
    public boolean checkSpot(int x, int y){
	return !(maze[x][y] == '#' || maze[x][y] == '.' );
    }  
    
    public void findE(){
	for(int x = 0; x < maze.length; x++){
	    for(int y = 0; y <maze[x].length; y++){
		if (maze[x][y] == 'E'){
		    target = new Coordinate(x,y,0);
		}
	    }
	} 
    }
    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called
     (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){
	sol = new Frontier(1); // for printing the solution as a set of coordinates
	solution = new int[path * 2];
	Coordinate ya = t;
	int i = 0;
	while (ya != null){
	    sol.add(ya);
	    solution[i] = ya.getX();
	    solution[i+1] = ya.getY();
	    maze[ya.getX()][ya.getY()] = 'O';
	    i += 2;
	    ya = ya.getPrevious();
	}
	// Have to put them in opposite order
	for(int x = 0; x < solution.length / 2; x++){
	    int temp = solution[x];
	    solution[x] = solution[solution.length - x - 1];
	    solution[solution.length - x - 1] = temp;
	}
	return solution;
    }
    public String solution(){
	String str = "[ ";
	for(int i = 0; i < solution.length; i++){
	    str += solution[i] + ",";
	}
	str += "]";
	return str;
    }
    
    public static void main(String[]args){
	Maze m = new Maze("data1.dat");
       	System.out.println(m.solveBest(true));
       	m.solutionCoordinates();
	System.out.println("Location of E: " + target);
       	System.out.println("Solution: \n" + m.sol);
    }
    
}
