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

    public T getFirst(){

    }

    public T getLast(){

    }

    public void grow(){

    }

    public void shrink(){

    }
