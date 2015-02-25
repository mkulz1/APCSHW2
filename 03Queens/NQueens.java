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
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	board[0][0] = 8;

    }

}
