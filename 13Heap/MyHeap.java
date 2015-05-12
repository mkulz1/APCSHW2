import java.util.*;
import java.io.*;

public class MyHeap{

    private boolean isMaxHeap;
    private int[] heap;

    public MyHeap(){
	isMaxHeap = true;
	heap = new int[10];
    }
    public MyHeap(boolean isMax){
	isMaxHeap = isMax;
	heap = new int[10];
    }

    public String toString(){
	String result = "";
	for(int i = 0; i < heap.length; i++){
	    result += heap[i];
	}
	return result;
    }

    public static void main(String[]args){

	MyHeap h = new MyHeap();

    }

}
