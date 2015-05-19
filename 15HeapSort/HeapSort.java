import java.util.*;
import java.io.*;

public class HeapSort{

    public RunningMedian bob;
    public int[] sorted;

    public String name(){
	return "kulyk.mariya";
    }

    public HeapSort(){
	bob = new RunningMedian();
    }

    public void add(int value){
	bob.add(value);
    }

    public int[] heapSort(){
	int next = bob.lesser.heap[0]-1;
	sorted = new int[bob.greater.heap[0] + bob.lesser.heap[0]-2];
	for(int i = next-1; i >=0; i--){
	    sorted[i] = bob.lesser.remove();
	}
	int se = next + bob.greater.heap[0] - 1;
	//	System.out.println("New: " + se);
	for(int i = next; i < se;i++){
	    sorted[i] = bob.greater.remove();
	}

	return sorted;

    }

    public String toString(){
	return Arrays.toString(sorted);
    }

    public static void main(String[]args){

	HeapSort sort = new HeapSort();

	sort.add(6);
	sort.add(7);
	sort.add(8);
	sort.add(13);
	sort.add(3);
	sort.add(11);

	sort.heapSort();
	System.out.println(sort);



    }

}
