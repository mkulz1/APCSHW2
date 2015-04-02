import java.util.*;

public class MyDeque<T>{

    private Object[] deq;
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

    public void addFirst(T value){
	head--;
	if ( head < 0){
	    head = deq.length-1; // wraps around
	}
	deq[head] = value;
	size++;
    }

    public void addLast(T value){
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

	if (head < 0)
	    tial = deq.length - 1; // wraps around

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

    public void grow(){

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
    
    public static void main(String[]args){
	
    }
}
