import java.util.*;
import java.io.*;

public class MyHeap{

    private boolean isMaxHeap;
    private int[] heap;

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
	String result = "";
	for(int i = 0; i < heap.length; i++){
	    result += heap[i];
	}
	return result;
    }

    public int remove(){
	return heap[1];
    }

    public void add(int value){

	int index = heap[0];
	heap[index] = value;
	pushUp(index);
    }
    
    public void pushUp(int index){

	while (heap[index] > heap[index/2]) {

	    int hold = heap[index/2];
	    heap[index/2] = heap[index];
	    heap[index] = hold;

	    index = index/2;	    
	} 
    }
    
    public int peek(){
	return heap[1];
    }

    public static void main(String[]args){

	MyHeap h = new MyHeap();
	h.add(3);
    }

}
