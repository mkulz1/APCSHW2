import java.util.*;

public class MyDeque<T>{

    private Object[] deq;
    private int[] amazingness;
    private int head; 
    private int tail;
    private int size;

    public MyDeque(){
	deq = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
    }

    public String name(){
	return "kulyk.mariya";
    }

    public int getTail(){
	return tail;
    }
    public int getHead(){
	return head;
    }
    public int[] getAmazing(){
	return amazingness;
    }
    
    public void addFirst(T value){
	if (size == deq.length){
	    resize();
	}
	head--;
	if ( head < 0){
	    head = deq.length-1; // wraps around
	}
	deq[head] = value;
	size++;
    }
    public void addFirst(T value, int a){
	if (size == deq.length){
	    resize();
	}
	head--;
	if ( head < 0){
	    head = deq.length-1; // wraps around
	}
	deq[head] = value;
	amazingness[head] = a;
	size++;
    }
    
    public void addLast(T value, int a){
	if (size == deq.length){
	    resize();
	}
	tail++;
	if (tail > deq.length - 1){
	    tail = 0; // wraps around
	}
	deq[tail] = value;
	amazingness[tail] = a;
	size++;
    }
    public void addLast(T value){
	if (size == deq.length){
	    resize();
	}
	tail++;
	if (tail > deq.length - 1){
	    tail = 0; // wraps around
	}
	deq[tail] = value;
	size++;
    }
    
    public T removeFirst(){
	if (size == 0)
	    throw new NoSuchElementException();
	
	size--;
	T removed = (T)deq[head];
	head++;
	
	if (head > deq.length - 1)
	    head = 0; // wraps around

	return removed;
    }

    public T removeLast(){
	if (size == 0)
	    throw new NoSuchElementException();

	size--;
	T removed = (T)deq[tail];
	tail--;

	if (tail < 0)
	    tail = deq.length - 1; // wraps around

	return removed;
    }

    public T getFirst(){
	if (size == 0)
	    throw new NoSuchElementException();
     
	return (T)deq[head];
    }

    public T getLast(){
	if (size == 0)
	    throw new NoSuchElementException();
	
	return (T)deq[tail];
    }

    public void resize(){
	Object[] thing = new Object[deq.length*2];
	if (head < tail){
	    for (int i = head; i <= tail; i++){
		thing[i] = deq[i];
	    }
	}else{
	    for( int i =head; i < deq.length; i++){
		thing[i] = deq[i];
	    }
	    for(int i = 0; i <= tail; i++){
		thing[i + deq.length] = deq[i];
	    }
	    tail += deq.length;
	}
	deq = thing;
    }
    
    public boolean empty(){
	return  (size == 0);
    }
    
    public void shrink(){
	Object[] ret = new Object[deq.length / 2];
	int c = 0;
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		    ret[c] = deq[i];
		    c ++;
	    }
	}else{
	    for (int i = head; i < deq.length; i ++){
		ret[c] = deq[i];
		c ++;
	    }
	    for (int i = 0; i <= tail; i ++){
		ret[c] = deq[i];
		    c ++;
	    }
	}
	head = 0;
	    tail = c - 1;
	    deq = ret;
    }
    
    public String toString(){
	String str = "[";
	if (size > 0){
	    for (int i = 0; i < size-1; i++){
		str += deq[ (head+i) % deq.length] + ", ";
	    }
	    str += deq[tail];
	}
	str += "]";
	return str;
    }
}
