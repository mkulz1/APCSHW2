import java.util.Random;
import java.lang.*;

public class Sorts{

    public static Random r = new Random();

    public static String name(){
	return "kulyk.mariya";
    }
    
    public static String arrayPrint(int[] array){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result +=  array[i] + " ";
	}
	return result;
    }
    
    // Not in place version
    public static void part(int[] ary,int si, int ei){
      	int[] d = new int[ary.length];
	for(int i = 0; i < ary.length; i++){
	    if(i < si || i > ei){
		d[i] = ary[i];
	    }
	}

	//select the pivot point
	int tIndex = r.nextInt(ei - si + 1) + si;
	int target = ary[tIndex]; // Target/Pivot

	//for elements in range
	int lIndex = si;
	int rIndex = ei;

	for(int i = si; i <= ei; i++){
	    if(ary[i] < target){
		d[lIndex] = ary[i];
		lIndex++;
	    }else if (ary[i] > target){
		d[rIndex] = ary[i];
		rIndex--;
	    }
	    // To See the Partition Process
	    // ystem.out.println("Array: { " + arrayPrint(ary) + "}");
	    System.out.println("New: { " + arrayPrint(d) + "}");
	}
	d[lIndex] = ary[tIndex];
	
	System.out.println("Target: " + target);
       	System.out.println("New: " + arrayPrint(d));
    }

    // Quick Sort Methods

    public static void quickSort(int[] ary){
	quickSort(ary, 0, ary.length - 1);
    }
    public static void quickSort(int[] ary, int si, int ei){
        if (si < ei){
	    int index = parition(ary, si, ei);
	    quickSort(ary, si, index - 1);
	    quickSort(ary, index + 1, ei);
	}
    }

    public static int parition(int[] ary, int si, int ei){
	int pIndex = r.nextInt(ei + 1 - si) + si;
	int pivot = ary[pIndex];
	int end = ei;
	int start = si;
	while (start <= end && si != ei) {
	    if (ary[start]<pivot) { 
		int x = ary[start];
		ary[start] = ary[si];
		ary[si] = x;
		si++;
		if(x == pivot){
		    pIndex = si;
		}else if (ary[start] == pivot) {
		    pIndex = start;
		}
		start++;
	    } else if (ary[start] > pivot) {
		int x = ary[start];
		ary[start] = ary[ei];
		ary[ei] = x;
		ei--;
		if(x == pivot){
		    pIndex = ei;
		}else if (ary[start] == pivot) {
		    pIndex = start;
		}
	    } else {
		start++;
	    }
	}
	int x = ary[si];
	ary[si] = pivot;
	ary[pIndex] = x;
	return pIndex;
    }

    public static void main(String[]args){
	
	int[] tester = {5,97,34,12,67,42,76,99,15,2};
       	System.out.println("Old: " + arrayPrint(tester));
	quickSort(tester);

	System.out.println(arrayPrint(tester));
    }
    
}

