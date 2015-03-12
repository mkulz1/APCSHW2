import java.util.*;

public class MyLinkedList{

    private LNode head;
    private LNode current;
    private int size;

    public MyLinkedList(){
	head = new LNode();
	current = new LNode();
	size = 1;
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

    public void add(int value){
	LNode t = new LNode();
	current = head;
	head = t;
    }

    public String toString(){
	String result = "[ ";
	current = head;
	while(current.getNext() != null){
	    result += current.toString() + ",";
	    current = current.getNext();
	}
	result += current.toString();
	return result.substring(0,result.length()-1) + "]";
    }

    public static void main(String[]args){

	LNode node = new LNode();
	MyLinkedList list = new MyLinkedList();
	list.set(0,8);
	System.out.println(list);
    }

}
