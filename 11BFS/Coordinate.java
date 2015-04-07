import java.util.*;

public class Coordinate{

    private int x;
    private int y;

    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
    }

    public int getX(){
	return this.x;
    }
    public int getY(){
	return this.y;
    }

    public String toString(){
	String str = "(";
	str += x + "," + y + ")";
	return str;
    }

    public static void main(String[]args){
	Coordinate g = new Coordinate(3,4);
	Coordinate c = new Coordinate(5,7);
	System.out.println(g);
	System.out.println("G's x-cor:" + g.getX());
	System.out.println(c);
    }

}
