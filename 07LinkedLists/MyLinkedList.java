import java.util.*;

public class MyLinkedLIst{

    private lNode head;
    private lNode current;
    private int size;

    public MyLinkedList(){
	head = new LNode(0);
	current = new LNode(0);
	size = 0;
    }

    public String toString(){
	String result = "[";
	current = head;
	while(current.getNext() != null){
	    result += current.toString() + " ";
	    current = current.getNext();
	}
	result += current.toString();
	return result + "]";
    }
}
