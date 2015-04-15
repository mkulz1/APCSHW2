import java.util.*;

public class Coordinate{

    private int x;
    private int y;
    private Coordinate previous;
    private int amazingness;

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
    public Coordinate getPrevious(){
	return this.previous;
    }
    public void setPrevious(Coordinate c){
	previous = c;
    }
    public int getA(){
	return this.amazingness;
    }

    public String toString(){
	String str = "(";
	str += x + "," + y + ")";
	return str;
    }

}
