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

    public String toString(){
	return deq.toString();
    }
    
    public static void main(String[]args){
	Frontier f = new Frontier(0);
	Coordinate a = new Coordinate(1,8);
	Coordinate b = new Coordinate(4,9);
	Coordinate c = new Coordinate(5,7);
	f.add(a);
	f.add(b);
	f.add(c);

	System.out.println(f);
    }
    
}
