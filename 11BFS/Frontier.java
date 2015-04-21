import java.util.*;

public class Frontier{
  
    private MyDeque<Coordinate> deq;
    private int mode;
    private static Coordinate end;

    public Frontier(int m, Coordinate e){
	mode = m;
	deq = new MyDeque<Coordinate>();
	Coordinate end = e;
    }
    
    public void add(Coordinate c){
	if(mode == 0){
	    deq.addLast(c);
	}else if (mode == 1){
	    deq.addFirst(c);
	}else if (mode == 2){
	    deq.addLast(c,distance(c));
	}else if (mode == 3){
	    deq.addLast(c,distance(c) + deq.path);
    }
    
    public int distance(Coordinate now){
        return (Math.abs(now.getX() - end.getX())) + (Math.abs(now.getY() - end.getY()));
    }

    public Coordinate remove(){
	if(mode == 2 || mode == 3){
	    return deq.removeSmallest();
	}else{
	    return deq.removeFirst();
	}
    }
    
    public boolean empty(){
	return deq.empty();
    }

    public String toString(){
	return deq.toString();
    }
    
}
