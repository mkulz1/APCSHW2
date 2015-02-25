import java.util.*;
import java.io.*;

public class NQueens{

    private int[][] board;

    public String toString(){
	String ans = "\n";

	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		ans = ans + board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
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
