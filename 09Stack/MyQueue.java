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

    public T dequeue(){
	return queue.remove(0);
    }

    public static void main(String[]args){
	MyQueue<String> q = new MyQueue<String>();
	q.enqueue("hi");
	q.enqueue("bye");
	q.enqueue("yo");
	System.out.println(q);
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
    }

}
