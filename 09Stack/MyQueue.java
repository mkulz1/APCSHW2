import java.util.*;

public class MyQueue<T> extends MyLinkedList<T>{

    private MyLinkedList<T> queue;

    public String name(){
	return "kulyk.mariya";
    }

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public boolean enqueue(T t){
	return queue.add(t);
    }

    public T dequeue(T t){
	return queue.remove(0);
    }

}
