import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...

	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		ans = ans + board[i][j] + " ";
	    }
	    ans += "\n";
	}

	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){

	 board = new int[size][size];
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}			
    }

    
    public void solve(){
	solve(0,0,1);		
    }

    public void solve(int startx, int starty){
	solve(startx,starty,1);
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	
	boolean allFilled = false;
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if (board[i][j] == 0)
		    allFilled = false;
	    }
	}

	// out of bounds
	if(x<0 || y<0 || x > board[0].length || y > board.length)
	    return false;

	// done touring
       	if(allFilled)
	    return true;

	// still touring
	if(board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if( solve(x-1, y-2,currentMoveNumber+1) || solve(x+1,y-2,currentMoveNumber+1) ||
		solve(x+2,y-1,currentMoveNumber+1) || solve(x-1,y+2,currentMoveNumber+1) ||
		solve(x+2,y+1,currentMoveNumber+1) || solve(x+1,y+2,currentMoveNumber+1) || 
		solve(x-2,y+1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1) )
		return true;
	}
		
	return false;
    }


    public static void main(String[]args) {

	KnightsTour board = new KnightsTour(5);
	// 	System.out.println(board);
	board.solve();

    }

}
