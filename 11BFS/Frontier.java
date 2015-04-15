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
    
    public void add(Coordinate c){
	if(bfs){
	    deq.addLast(c);
	}else{
	    deq.addFirst(c);
	}
    }
    public void add(Coordinate now,Coordinate goal){
	deq.addLast(now,amaze(now,goal));
    }
    
    public int amaze(Coordinate now, Coordinate goal){
	return (Math.abs(now.getX() - goal.getX())) + (Math.abs(now.getY() - goal.getY()));
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
