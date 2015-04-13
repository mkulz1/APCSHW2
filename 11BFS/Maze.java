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
		starty = i % maxx;
		startx = i / maxx;
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
    public String toString(boolean animate){
	if (animate){
	    return hide + clear + go(0,0) + toString() + show;
	}else{
	    return toString();
	}
    }

    // METHODS

    // Mode 0 = BFS  &  Mode 1 = DFS
    
    public boolean solve(boolean animate, int mode){
	Frontier f = new Frontier(mode);
	Coordinate start = new Coordinate(startx,starty);
	f.add(start);
	
	while(!f.empty()){
	    
	    if (animate){
		wait(20);
		System.out.println(toString(animate));
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
		    return true;
		} else {
		    maze[x][y] = '.';
		    // Possible spots
		    Coordinate a = new Coordinate(x-1,y);
		    a.setPrevious(c);
		    Coordinate b = new Coordinate(x+1,y);
		    b.setPrevious(c);
		    Coordinate d = new Coordinate(x,y+1);
		    d.setPrevious(d);
		    Coordinate e = new Coordinate(x,y-1);
		    e.setPrevious(e);
		    f.add(a);
		    f.add(b);
		    f.add(d);
		    f.add(e);
		}   
	    }
	}
	return false;
    }


    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }

    public boolean solveDFS(boolean animate){
	return solve(animate,1);
    }

    public boolean checkSpot(int x, int y){
	if(maze[x][y] != '#' && maze[x][y] != '.'){
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
	System.out.println("(" + m.startx + "," + m.starty + ")");
	//	System.out.println(m);
       	System.out.println(m.solve(true,0));
    }

}
