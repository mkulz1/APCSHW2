import java.util.*;
import java.io.*;

public class Frontier{
  
    private MyDeque<Coordinate> deq;
    private int mode;
    private Coordinate end;

    public Frontier(int m){
	mode = m;
	deq = new MyDeque<Coordinate>();
    }
    
    public void setEnd(Coordinate e){
	end = e;
    }

    public void add(Coordinate c){
	if(mode == 0){
	    deq.addLast(c);
	}else if (mode == 1){
	    deq.addFirst(c);
	}else if (mode == 2){
	    try{
		deq.add(c,distance(c));
	    }catch(NullPointerException e){
		System.out.println("Something wrong in add!");
	    }
	}else if (mode == 3){
	    deq.add(c,(distance(c) + c.getSteps()));
	}
    }
    
    public int distance(Coordinate now){
        return Math.abs(now.getX() - end.getX()) + Math.abs(now.getY() - end.getY());
    }

    public Coordinate remove(){
	if(mode == 2 || mode == 3){
	    return deq.removeSmallest();
	}else{
	    return deq.removeFirst();
	}
    }

    public Coordinate getEnd(){
	return this.end;
    }    

    public boolean empty(){
	return deq.empty();
    }

    public String toString(){
	return deq.toString();
    }
    
}
