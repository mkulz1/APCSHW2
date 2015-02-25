import java.util.*;
import java.io.*;

public class NQueens{

    public String name(){
	return "kulyk.mariya";
    }
    
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
	
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		ans = ans + board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int n){
	// Makes base board and initialize it
	board = new int[n][n];
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < n; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	// Start from 0,0
	return solve(0,board.length);
    }

    public boolean solve(int x){
	if (x < board.length || x >= 0)
	    return solve(x,board.length);
	return false;
    }

    public boolean solve(int r, int numQ){
	//System.out.println(this);
	//wait(20);

	if(numQ == 0)
	    return true;

	for(int i = 0; i < board.length; i++){

	}
	return false;

    }

    public void blockSpots(int row, int col){
	blockSpots(row,col,0,1);
	blockSpots(row,col,1,0);
	blockSpots(row,col,1,1);
	blockSpots(row,col,0,-1);
	blockSpots(row,col,-1,0);
	blockSpots(row,col,-1,1);
	blockSpots(row,col,1,-1);
	blockSpots(row,col,-1,-1);
    }

    public void blockSpots(int row, int col, int y, int x){

	for(int i = row;i < board.length && i > 0; i=i+y){
	    for(int j = col; j < board.length && j > 0;j= j+x){
		board[i][j] = 3;
	    }
	}
    }

}
