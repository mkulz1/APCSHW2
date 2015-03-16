import java.util.*;

public class MyLinkedList{

    private LNode head;
    private LNode current; // used as a holder in many methods
    private LNode tail;
    private int size;


    public String name(){
	return "kulyk.mariya";
    }
    
    
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
    
    public int remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode r;
	if (index == 0){
	    r = head;
	    head  = r.getNext();
	} else if (index == size - 1) {
	    r = tail;
	    tail = null;
	    current = head;
	    while(current.getNext() != null){
		current = current.getNext();
	    }
	    tail = current;
	}else{
	    current = head;
	    while (index > 1) {
		current = current.getNext();
		index --;
	    }
	    r = current.getNext();
	    current.setNext(r.getNext());
	}
	size --;
	return r.getValue();
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
	list.add(8);
	list.add(7);
	list.add(3);
	list.add(11);
	list.add(0);
	list.add(2);
	list.add(1);
	list.add(4);
	list.add(6);
	list.add(34);
	list.add(5);
	list.set(0,6);
	System.out.println(list);
	list.remove(1);
	System.out.println("Removed #1");
	System.out.println(list);
	list.remove(4);
	System.out.println("Removed #4");
	System.out.println(list);
	list.remove(5);
	System.out.println("Removed #5");
	System.out.println(list);
    }

}
