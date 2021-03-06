import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    public class MLLIterator<T> implements Iterator<T>{

	private LNode<T> node;

	public MLLIterator(LNode<T> no){
	    node = no;
	}

	public boolean hasNext(){
	    return current!=null;
	}

	public T next(){
	    if (hasNext()){
		T ans = node.getData();
		node = node.getNext();
		return ans;
	    }else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }
    
    public Iterator<T> iterator(){
	return new MLLIterator<T>(head);
    }
    
    private LNode<T> head;
    private LNode<T> current; // used as a holder in many methods
    private LNode<T> tail;
    private int size;
   
    
    public MyLinkedList(){
	size = 0;
    }
    
    public T get(int index){
	if( index < 0 || index >= size) {
	    throw new ArrayIndexOutOfBoundsException();
	}
	current = head;
	while(index != 0) {
	    current = current.getNext();
	    index --;
	}
	return current.getData();
    }

    public void set(int index, T value){
	if (index < 0 || index >= size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	current = head;
	for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	current.setData(value);
    } 

    public boolean add(T value){
	LNode<T> tL = new LNode<T>(value);
	if( size == 0){
	    head = tL;
	    tail = head;
	    current = tL;
	}else{
	    tail.setNext(tL);
	    tail = tL;
	}
	size ++;
	return true;
    }

    public boolean add(int index, T value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> add = new LNode<T>(value);
	if (index == 0){
	    add.setNext(head);
	    head = add;
	}else if(index == size()){
	    add(value);
	}else{
	    current = head;
	    for (int i = 0; i < index - 1; i ++){
		current = current.getNext();
	    }
	    LNode<T> next = current.getNext();
	    current.setNext(add);
	    add.setNext(next);
	}
	size ++;
	return true;
	
    }
    
    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> r;
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
	return r.getData();
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
	String result = "[ ";
	current = head;
	for (int i = 0; i < size; i ++){
	    result += current.getData() + ",";
	    current = current.getNext();
	}
	return result.substring(0,result.length()-1) + " ]";
    }

    public String name(){
	return "kulyk.mariya";
    }
    
    public boolean empty(){
	return (size() == 0);
    }

    public static void main(String[]args){

	MyLinkedList<Integer> list = new MyLinkedList<Integer>();

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
