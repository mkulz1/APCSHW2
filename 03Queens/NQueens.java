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
	if (x > board.length || x < 0)
	    return false;
	board[0][x] = 8;
	return solve(1,board.length-1);
    }

    public boolean solve(int y, int numQ){
      if (numQ == 0){
	    return true;
	}
	for (int x = 0; x < board.length; x ++){

	    if (canPut(x, y)){

	        board[y][x] = 8;

		if (solve(y + 1, numQ - 1)){
		    return true;
		}

		board[y][x] = 0;
	    }
	}

	return false;
    }

    public boolean canPut(int col, int row){
	// Going down the row
	for (int y = row; y >= 0; y --){
	    if (board[y][col] == 8){
		return false;
	    }
	}

	// Going down the left diagonal
	int c = col;
	int r = row;
	while(c >= 0 && r >= 0){
	    if (board[r][c] == 8){
		return false;
	    }
	    c --;
	    r --;
	}

	// Going down the right diagonal
	c = col;
	r = row;
        while(c < board.length && r >= 0){
	    if (board[r][c] == 8){
		return false;
	    }
	    c++;
	    r--;
	}

	return true;
    }
   

}
