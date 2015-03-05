import java.util.*;
import java.io.*;

public class silver{

    private char[][] pasture;
    private int n,m,r1,c1,r2,c2,T,ways;
    

    public silver(String filename){
	loadLines(filename);
	ways = 0;
    }

    public void loadLines(String fileName){

	try{

	    File input = new File(fileName);
	    Scanner in = new Scanner(input);
	    
	    // Line 1
	    n = in.nextInt();
	    m = in.nextInt();
	    T = in.nextInt();
	    pasture = new char[n][m];
	    
	    // Pasture
	    for(int i = 0; i < n; i++){
		String line = in.next();
		for(int j = 0; j < m; j++){
		    pasture[i][j] = line.charAt(j);
		}
	    }
	    
	    // Last Line
	    r1 = in.nextInt();
	    c1 = in.nextInt();
	    r2 = in.nextInt();
	    c2 = in.nextInt();
	    
	}catch(FileNotFoundException e){
	    
	    System.out.println("File Does Not Exist");

	}
    }
    
    public String toString(){
	String s  = "";
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < m; j++){
		s = s + pasture[n][m] + " ";
	    }
	    s += "\n";
	}
	return s;
    }

    public int travel(){
	travel(r1,c1,0);
	return ways;
    }

    public void travel(int x,int y, int steps){
	
	if(x < 0 || y < 0 || x >= n || y >= m || steps > T)
	    return; //stops the travel
	
	if(x == r2 && y == c2 && steps == T){
	    ways++;
	    return;
	}

	if(pasture[x][x] == '*')
	    return;
	
	travel(x,y+1,steps+1);
	travel(x,y-1,steps+1);
	travel(x+1,y,steps+1);
	travel(x-1,y,steps+1);
    }

    public static int process(char[][]board,int x0,int yo,int x1,int y1,int steps){
	if(steps == 0){
	    if(x0 == x1 && y0 == y1){
		return 1;
	    }else{
		return 0;
	    }
	}
	char here = ' ';
	try{
	    here = board[x0][y0];
	}catch{ ArrayIndexOutofBoundsException E  
		}
    }

    // Cellular Automata Method
    public static int process(char[][]board,int x0,int yo,int x1,int y1,int maxSteps){
	int[][][]calcboard = new int [board.length][board[0].length][2];
	int steps = 1;
	while(steps <= maxSteps){
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[0].length; c++){
		    if(board[r][c] != '*'){
			calcboard[r][c][steps%2] = 0;
			if(r < board.length - 1){
			    calcboard[r][c][steps%2]+=calcboard[r+1][c][ (steps+1) % 2];
			}
		    }
		}
	    }
	}
    }
    }
    
    public static void main(String[]args){
	
	silver thing = new silver("cowTravel.txt");
	System.out.println(thing);
	System.out.println(thing.travel());
	
    }
    
}
