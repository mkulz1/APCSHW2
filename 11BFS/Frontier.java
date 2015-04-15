import java.util.*;

public class Frontier{
  
    private MyDeque<Coordinate> deq;
    private int mode;
    private Coordinate end;

    public Frontier(int m){
	mode = m;
	deq = new MyDeque<Coordinate>();
    }
    
    public void add(Coordinate c){
	if(mode == 0){
	    deq.addLast(c);
	}else if (mode == 1){
	    deq.addFirst(c);
	}else{
	    deq.addLast(c,amaze(c,end));
	}
    }
    
    public int amaze(Coordinate now, Coordinate goal){
	return (Math.abs(now.getX() - goal.getX())) + (Math.abs(now.getY() - goal.getY()));
    }

    public int[] getAmazing(){
	return deq.getAmazing();
    }
    public Coordinate remove(){
	return deq.removeFirst();
    }
    
    public boolean empty(){
	return deq.empty();
    }

    public String toString(){
	return deq.toString();
    }
    
}
