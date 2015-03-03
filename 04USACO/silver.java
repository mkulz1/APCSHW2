import java.util.*;
import java.io.*;

public class silver{

    private String[][] pasture;
    private int n,m,r1,c1,r2,c2,T;
    

    public silver(){
	loadLines("ctravel.txt");
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

}
