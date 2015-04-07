import java.util.*;

public class Frontier{
  
    private MyDeque<Coordinate> deq;
    private boolean bfs;
    
    public Frontier(int mode){
	if(mode == 0){
	    bfs = true;
	}else{
	    bfs = false;
	}
	deq = new MyDeque<Coordinate>();
    }
    
    public boolean add(Coordinate c){
	deq.addFirst(c);
	return true;
    }
    
    public static void main(String[]args){
	Frontier f = new Frontier(0);
	System.out.println(f);
    }
    
}
