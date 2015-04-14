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
	deq.addLast(c);
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
    
    public static void main(String[]args){
       	Frontier f = new Frontier(0);
	/*	Coordinate a = new Coordinate(1,8);
	Coordinate b = new Coordinate(4,9);
	Coordinate c = new Coordinate(5,7);
	Coordinate d = new Coordinate(6,6);
	f.add(a);	
	f.add(b);
       	f.add(c);
	f.add(d);

	System.out.println(f);
	System.out.println("Head: " + f.getHead());
	System.out.println("Tail: " + f.getTail());

	f.remove();
	System.out.println(f);
	System.out.println("The Head is: " + f.deq.getFirst());
	System.out.println("Head: " + f.getHead());
	System.out.println("Tail: " + f.getTail());*/
	Coordinate a = new Coordinate(4,5);
	f.add(a);
	System.out.println(f);
        a = new Coordinate(7,8);
	f.add(a);
	System.out.println(f);
	f.remove();
	System.out.println(f);
    }
    
}
