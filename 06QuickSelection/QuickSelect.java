import java.util.Random;
import java.lang.*;

public class QuickSelect{

    public int pivot = -1;
    public int[] array;

    public QuickSelect(int numElements){
	array = new int[numElements];
	for(int i = 0; i < numElements; i++){
	    array[i] = (int)(10*Math.random());
	}
    }

    public String toString(){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result += array[i];
	    result += " ";
	}
	return result;
    }

    public void partition(int[] ary,int si, int ei){
	int[] d = new int[ary.length];
	
	//select the pivot point
	Random r  = new Random();
	int tIndex = r.nextInt(ei - si) + si;
	int target = array[tIndex]; // Target/Pivot
	pivot = target;

	//for elements in range
	int rIndex = si;
	int lIndex = ei;

	for(int i = si; i <= ei; i++){
	    if(ary[i] < target){
		d[rIndex] = ary[i];
		rIndex++;
	    }else{
		d[lIndex] = ary[i];
		lIndex--;
	    }
	}
	d[rIndex] = ary[tIndex];

	//copy over elements outside of range into d
	for (int i = si - 1; i >= 0; i --){
	    d[i] = ary[i];
	}
	for (int i = ei + 1; i < ary.length; i ++){
	    d[i] = ary[i];
	}

	String dArray = "";
	for(int i = 0; i < d.length; i++){
	    dArray += d[i] + " ";
	}
	System.out.println("New: " + dArray);
    }
    
    public static void main(String[]args){
	
	QuickSelect quick = new QuickSelect(10);
	System.out.println("Old: " + quick);
	quick.partition(quick.array,0,9);
	System.out.println("Target: " + quick.pivot);
	System.out.println("After Quick Select:");
    }
    
}
