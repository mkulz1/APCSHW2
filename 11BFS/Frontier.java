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
	}else if (mode == 2){
	    deq.addLast(c,distance(c));
	}
    }
    
    public int distance(Coordinate now){
        return (Math.abs(now.getX() - end.getX())) + (Math.abs(now.getY() - end.getY()));
    }

    public int[] getPriority(){
	return deq.getPriority();
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
