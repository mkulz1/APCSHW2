import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> stack;


    public String name(){
	return "kulyk.mariya";
    }

    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public boolean empty(){
	return (stack.size() == 0);
    }

    public T push(T value){
	stack.add(0,value);
	return value;
    }

    public T peek(){
	if (empty()) 
	    throw new EmptyStackException();
	return stack.get(0);
    }
    
    public T pop(){
	if (empty()) 
	    throw new EmptyStackException();
	return stack.remove(0);
    }

    public static void main(String[]args){
	
    }
    
}
