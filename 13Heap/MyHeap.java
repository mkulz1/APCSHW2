import java.util.*;
import java.io.*;

public class MyHeap{

    private boolean isMaxHeap;
    private int[] heap;
    // heap[0] keeps track of next open spot in array

    public MyHeap(){
	this(true);
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

	if (heap[0] == 1) {
	    throw new NoSuchElementException();
	}

	int removed = heap[1];

	heap[1] = heap[heap[0]-1];
	heap[heap[0]-1] = 0;
	heap[0] -= 1;
	pushDown(1);
	return removed;
	
    }

    public void add(int value){
	int index = heap[0];
	heap[index] = value;
	pushUp(index);
	heap[0] += 1;
	resize();
    }
    
    public void pushUp(int index){
	if(index > 1){
	    if (isGood(index,index/2)) {
		swap(index,index/2);
		pushUp(index/2);	    
	    } 
	}
    }
    
    public boolean isGood(int a,int b){
	if(isMaxHeap){
	    return a > b;
	}else{
	    return a < b;
	}
    }

    public void swap(int indexOne, int indexTwo){
	int hold = heap[indexTwo];
	heap[indexTwo] = heap[indexOne];
	heap[indexOne] = hold;
    }

    public void pushDown(int index){

	int left = index*2;
	//	int right = index*2 + 1;
	//	int next;

	if(heap[left] > heap[0]-1){
	    return;
	}
	if(!isGood(heap[index],heap[left])){
	    swap(index,left);
	    pushDown(left);
	}
    }
   
    
    public int peek(){
	if (heap[0] == 1) {
	    throw new NoSuchElementException();
	} 
	return heap[1];
    }


    private void resize() {
	if (heap[0]-1 == heap.length - 1) {
	    heap = Arrays.copyOf(heap, (heap[0]-1) * 2);
	} else if (heap[0]-1 < heap.length / 2 && heap[0]-1 > 10) {
	    heap = Arrays.copyOf(heap, heap.length / 2);
	}
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
	System.out.println();

	h.remove();
	h.remove();
	System.out.println("After Removing: ");
	System.out.println(h);
	
	MyHeap m = new MyHeap(false);
	System.out.println("Min Heap");
	m.add(3);
	m.add(8);
	m.add(4);	
	m.add(30);
	m.add(85);
	m.add(25);	
	m.add(96);
	m.add(67);
	System.out.println("After Adding: ");
	System.out.println(m);
	System.out.println();

	m.remove();
	System.out.println("After Removing: ");
	System.out.println(m);
    }

}
