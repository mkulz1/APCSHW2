import java.util.*;

public class MyLinkedLIst{

    private lNode head;
    private lNode current;
    private int size;

    public MyLinkedList(){
	head = new LNode(0);
	current = new LNode(0);
	size = 0;
    }

    public int get(int index){
	if( index < 0 || index >= size) {
	    throw new ArrayIndexOutOfBoundsException();
	}
	current = head;
	while(index != 0) {
	    current = current.getNext();
	    index --;
	}
	return current.getValue();
    }

    public void set(int index, int value){
	if (index < 0 || index >= size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	current = head;
	while( index != 0) {
	    current = current.getNext();
	    index --;
	}
	current.setValue(value);
    } 

    public String toString(){
	String result = "[";
	current = head;
	while(current.getNext() != null){
	    result += current.toString() + " ";
	    current = current.getNext();
	}
	result += current.toString();
	return result + "]";
    }
}
