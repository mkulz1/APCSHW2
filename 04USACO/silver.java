import java.util.*;
import java.io.*;

public class silver{

    private String[][] pasture;
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
	    pasture = new String[n][m];

	    // Pasture
	    for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
		    pasture[i][j] = in.next();
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

    public int travel(){
	return travel(r1,c1,0);
    }

    public void travel(int x,int y, int steps){
	
	if(x < 0 || y < 0 || x >= n || y >= m || steps > T)
	    return 0; 
	
	if(x == r2 && y == c2 && steps == T)
	    ways++;

	if(pasture[x][x].equals("*"))
		return 0;
	
	return 0;
    }
    
    public static void main(String[]args){
	
	silver thing = new silver("cowTravel.txt");
	System.out.println(thing.travel());
	
    }
    
}
