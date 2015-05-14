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

	if (heap[0] == 1) {
	    throw new NoSuchElementException();
	}

	heap[1] = heap[heap[0]-1];
	heap[heap[0]-1] = 0;
	heap[0] -= 1;
	if(isMaxHeap){
	    pushDown(1);
	}else{
	    pushDownMin(1);
	}
	return heap[1];

    }

    public void add(int value){
	    int index = heap[0];
	    heap[index] = value;
	    pushUp(index);
	    heap[0] += 1;
    }
    
    public void pushUp(int index){
	
	while ( isGood(index,index/2) && index/2 != 0 ) {
	    swap(index,index/2);
	    index = index/2;	    
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
	int right = index*2 + 1;

        if (isGood(heap[index],heap[left])){
	    swap(index,left);
	}
	if (isGood(heap[index],heap[right])){
	    swap(index,right);
	}
	/*	while(heap[index] < heap[index*2] || heap[index] < heap[index*2+1]){
	    // Ugly, messy code =___=
	    if(heap[index] < heap[index*2]){
		int hold = heap[index*2];
		heap[index*2] = heap[index];
		heap[index] = hold;
		if(heap[index] < heap[index*2+1]){
		    int holder = heap[index*2+1];
		    heap[index*2+1] = heap[index];
		    heap[index] = holder;
		}
		index = index*2;
    
	    } else if (heap[index] < heap[index*2+1]){
		int hold = heap[index*2+1];
		heap[index*2+1] = heap[index];
		heap[index] = hold;
		if(heap[index] < heap[index*2]){
		    int holder = heap[index*2];
		    heap[index*2] = heap[index];
		    heap[index] = holder;
		}
		index = index*2+1;
	    }
	    }*/
    }
    public void pushDownMin(int index){
	while(index < heap[0]-1 && (heap[index] > heap[index*2] || heap[index] > heap[index*2+1])){
	    // Ugly, messy code =___=
	    System.out.println(this);
	    if(heap[index] > heap[index*2]){
		int hold = heap[index*2];
		heap[index*2] = heap[index];
		heap[index] = hold;
		if(heap[index] > heap[index*2+1]){
		    int holder = heap[index*2+1];
		    heap[index*2+1] = heap[index];
		    heap[index] = holder;
		}
		index = index*2;
		
	    } else if (heap[index] > heap[index*2+1]){
		int hold = heap[index*2+1];
		heap[index*2+1] = heap[index];
		heap[index] = hold;
		if(heap[index] > heap[index*2]){
		    int holder = heap[index*2];
		    heap[index*2] = heap[index];
		    heap[index] = holder;
		}
		index = index*2+1;
	    }
	    System.out.println(this);
	}
    }
    
    public int peek(){
	if (heap[0] == 1) {
	    throw new NoSuchElementException();
	} 
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
	System.out.println();

	h.remove();
	h.remove();
	System.out.println("After Removing: ");
	System.out.println(h);

	MyHeap m = new MyHeap(false);
	System.out.println("Min Heap");
	m.add(3);
	m.add(8);
	m.add(67);
	m.add(4);	
	m.add(30);
	m.add(85);
	m.add(25);	
	m.add(96);
	System.out.println("After Adding: ");
	System.out.println(m);
	System.out.println();

	m.remove();
	m.remove();
	System.out.println("After Removing: ");
	System.out.println(m);
    }

}
