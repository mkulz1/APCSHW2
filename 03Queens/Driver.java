public class Driver{
    
    public static void main(String[]args) {
	
	NQueens board = new NQueens(5);
	System.out.println(board.solve());
	System.out.println(board);
	
    }
    
}
