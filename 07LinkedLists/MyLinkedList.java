import java.util.*;

public class MyLinkedList{

    private LNode head;
    private LNode current;
    private LNode tail;
    private int size;

    public MyLinkedList(){
	head = new LNode(0);
	current = new LNode(0);
	tail = new LNode(0);
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
	for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	current.setValue(value);
    } 

    public boolean add(int value){
	LNode t = new LNode(value);
	if( size == 0){
	    head = t;
	    tail = head;
	    current = head;
	}else{
	    tail.setNext(t);
	    tail = t;
	}
	size ++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String result = "[ ";
	current = head;
	for (int i = 0; i < size; i ++){
	    result += current.getValue() + ",";
	    current = current.getNext();
	}
	return result.substring(0,result.length()-1) + " ]";
    }

    public static void main(String[]args){

	MyLinkedList list = new MyLinkedList();
	list.add(5);
	list.add(5);
	System.out.println(list);
    }

}
