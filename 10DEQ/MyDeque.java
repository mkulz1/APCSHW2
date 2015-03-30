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

    }

    public T getLast(){

    }

    public void grow(){

    }

    public void shrink(){

    }

    public static void main(String[]args){

    }
}
