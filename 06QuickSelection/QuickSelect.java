import java.util.Random;
import java.lang.*;

public class QuickSelect{

    public static Random r = new Random();
    
    public static String arrayPrint(int[] array){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result +=  array[i] + " ";
	}
	return result;
    }

    public static void partition(int[] ary,int si, int ei){
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

    // In-place version
   public static void part(int[] ary,int si, int ei){

	int tIndex = r.nextInt(ei - si + 1) + si;
	int target = ary[tIndex]; // Target/Pivot

	int lIndex = si;
	int rIndex = ei;
	
	for(int i = si; i <= ei; i++){
	    if(ary[i] < target){
        
	    }else if (ary[i] > target){
		
	    }

   }
    public static void main(String[]args){
	
	int[] tester = {5,97,34,12,67,42,76,99,15,2};
	System.out.println("Old: " + arrayPrint(tester));
	partition(tester,0,9);
    }
    
}
  
