import java.util.Random;
import java.lang.*;

public class QuickSelect{
    
    public static String arrayPrint(int[] array){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result += array[i];
	    result += " ";
	}
	return result;
    }

    public static void partition(int[] ary,int si, int ei){
	int[] d = new int[ary.length];
	
	//select the pivot point
	Random r  = new Random();
	int tIndex = r.nextInt(ei - si) + si;
	int target = ary[tIndex]; // Target/Pivot

	//for elements in range
	int rIndex = si;
	int lIndex = ei;

	for(int i = si; i <= ei; i++){
	    if(ary[i] < target){
		d[rIndex] = ary[i];
		rIndex++;
	    }else if (ary[i] > target){
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
	/*
	String dArray = "";
	for(int i = 0; i < d.length; i++){
	    dArray += d[i] + " ";
	    }*/
	System.out.println("Target: " + target);
       	System.out.println("New: " + arrayPrint(d));

    }
    
    public static void main(String[]args){
	
	int[] tester = {5,97,34,12,67,42,76,99,15,2};
	System.out.println("Old: " + arrayPrint(tester));
	partition(tester,0,9);
    }
    
}
