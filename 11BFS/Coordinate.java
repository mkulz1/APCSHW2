import java.util.*;

public class Coordinate{

    private int x;
    private int y;
    private Coordinate previous;
    private int steps;

    public Coordinate(int x, int y, int steps){
	this.x = x;
	this.y = y;
	this.steps = steps;
    }

    public int getX(){
	return this.x;
    }
    public int getY(){
	return this.y;
    }
    public int getSteps(){
	return this.steps;
    }
    public Coordinate getPrevious(){
	return this.previous;
    }
    public void setPrevious(Coordinate c){
	previous = c;
    }

    public String toString(){
	String str = "(";
	str += x + "," + y + ")";
	return str;
    }

}
