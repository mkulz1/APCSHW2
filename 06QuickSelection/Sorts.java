import java.util.Random;
import java.lang.*;

public class Sorts{

    public static Random r = new Random();
    
    public static String arrayPrint(int[] array){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result +=  array[i] + " ";
	}
	return result;
    }

    public static void quickSelect(int[] ary,int si, int ei){
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

    // In place
    public static int partPlace(int[] ary, int n, int si, int ei){

	int tIndex = r.nextInt(ei - si + 1) + si;
	int target = ary[tIndex]; // Target/Pivot
	int lIndex = si;
	int rIndex = ei;

	//In boundary
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < target){
		int hold = ary[lIndex];
		ary[lIndex] = ary[i];
		ary[i] = hold;
		lIndex ++;
	    }else if (ary[i] > target){
	        int hold = ary[rIndex];
		ary[rIndex] = ary[i];
		ary[i] = hold;
		rIndex --;
	    }
	}
	ary[lIndex] = target;
	//	System.out.println(target);
	//	System.out.println(arrayPrint(ary));

	if (lIndex == n - 1){
	    return ary[lIndex];
	} else if(lIndex < n - 1) {
	    return partPlace(ary, n, lIndex, ei);
	}else{
	    return partPlace(ary, n, si, lIndex);
	}
    }

    //QuickSelect
    public static int quickSelect(int ary[], int n){
	return partPlace(ary, n, 0, ary.length - 1);
    }

    //QuickSort
    public static void quickSort(int[] ary){
       
    }

    public static void main(String[]args){
	
	int[] tester = {5,97,34,12,67,42,76,99,15,2};
       	System.out.println("Old: " + arrayPrint(tester));
	quickSelect(tester,0,9);

	System.out.println(quickSelect(tester,3));
    }
    
}

