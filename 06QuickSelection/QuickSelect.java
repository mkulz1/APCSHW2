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
	//copy over elements outside of range into d
	int something = 0;
	int something2 = ary.length-1;
	// 	System.arraycopy(ary,something,d,something,si-something);
	// 	System.arraycopy(ary,something2,d,something2,something2-ei-1);
	//select the pivot point
	Random r  = new Random();
	int tIndex = r.nextInt(ei - si) + si;	
	//	int tIndex = r.nextInt(array.length); // index of target
	int target = array[tIndex]; // target integer
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
	if(rIndex == lIndex)
	    d[rIndex] = target;
    }

    public static void main(String[]args){
	
	QuickSelect quick = new QuickSelect(10);
	System.out.println(quick);
	quick.partition(quick.array,0,6);
	System.out.println("Target will be:" + quick.pivot);
    }
    
}
