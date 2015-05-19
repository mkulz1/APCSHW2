import java.util.*;
import java.io.*;

public class RunningMedian{

    public MyHeap greater,lesser;

    public RunningMedian(){
	greater = new MyHeap(false);
	lesser = new MyHeap(true);
    }

    public String name(){
	return "kulyk.mariya";
    }


    public void add(int value){
	if(greater.heap[0] == 1){
	    greater.add(value);
	    return;
	} else if (lesser.heap[0] == 1){
	    lesser.add(value);
	    return;
	}

	if(value > greater.heap[1]){
	    if(greater.heap[0] - lesser.heap[0] == 1){
		int hold = greater.remove();
		lesser.add(hold);
	    }
	    greater.add(value);
	}else{
	    if(lesser.heap[0] - greater.heap[0] == 1){
		int hold = lesser.remove();
		greater.add(hold);
	    }
	    lesser.add(value);
	}
    }
    
    public double getMedian(){
	if (greater.heap[0] == lesser.heap[0]) {
	    return (greater.peek() + lesser.peek()) / 2;
	} else if (greater.heap[0] > lesser.heap[0]) {
	    return greater.peek();
	} else {
	    return lesser.peek();
	}
    }
	
    public static void main(String[]args){
	RunningMedian test = new RunningMedian();

	test.add(1);
	test.add(5);
	test.add(6);
	test.add(19);
	test.add(56);
	test.add(70);
	test.add(99);

	System.out.println("Median is: ");
	System.out.println(test.getMedian());
	System.out.println("Greater: ");
	System.out.println(test.greater);
	System.out.println("Lesser: ");
	System.out.println(test.lesser);


	System.out.println();

	///// Code for heapSort
	int next = test.lesser.heap[0]-1;
	int[] longer = new int[test.greater.heap[0] + test.lesser.heap[0]-2];
	for(int i = next-1; i >=0; i--){
	    longer[i] = test.lesser.remove();
	}
	int se = next + test.greater.heap[0] - 1;
	System.out.println("New: " + se);
	for(int i = next; i < se;i++){
	    longer[i] = test.greater.remove();
	}

	System.out.println(Arrays.toString(longer));

    }

}
