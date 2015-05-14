import java.util.*;
import java.io.*;

public class MyHeap{

    private boolean isMaxHeap;
    private int[] heap;
    // heap[0] keeps track of next open spot in array

    public MyHeap(){
	isMaxHeap = true;
	heap = new int[10];
	heap[0] = 1;
    }
    public MyHeap(boolean isMax){
	isMaxHeap = isMax;
	heap = new int[10];
	heap[0] = 1;
    }

    public String toString(){
	String result = "{ ";
	for(int i = 0; i < heap.length; i++){
	    result += heap[i] + ",";
	}
	result = result.substring(0,result.length()-1);
	return result + " }";
    }

    public int remove(){
	heap[1] = heap[heap[0]-1];
	heap[heap[0]-1] = 0;
	pushDown(1);
	heap[0] -= 1;
	return heap[1];
    }

    public void add(int value){

	int index = heap[0];
	heap[index] = value;
	pushUp(index);
	heap[0] += 1;
    }
    
    public void pushUp(int index){

	while ( (heap[index] > heap[index/2]) && index/2 != 0 ) {

	    int hold = heap[index/2];
	    heap[index/2] = heap[index];
	    heap[index] = hold;

	    index = index/2;	    
	} 
    }

    public void pushDown(int index){
 
	while(heap[index] < heap[index*2] || heap[index] < heap[index*2+1])
	    if(heap[index] < heap[index*2]){
		int hold = heap[index*2];
		heap[index*2] = heap[index];
		heap[index] = hold;
		index = index*2;
	    } else if (heap[index] < heap[index*2+1]){
		int hold = heap[index*2+1];
		heap[index*2+1] = heap[index];
		heap[index] = hold;
		index = index*2+1;
	    }
    }
    
    public int peek(){
	return heap[1];
    }

    public static void main(String[]args){

	MyHeap h = new MyHeap();
	h.add(3);
	h.add(8);
	h.add(67);
	h.add(4);	
	h.add(30);
	h.add(85);
	h.add(25);	
	h.add(96);
	System.out.println("After Adding: ");
	System.out.println(h);
	h.remove();
	System.out.println("After Removing: ");
	System.out.println(h);
    }

}
