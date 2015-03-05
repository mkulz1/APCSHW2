import java.util.Random;

public class Partition{
 
    public int value = -1;

    public void partition(int[] array){
	Random r  = new Random();
	int tIndex = r.nextInt(array.length); // index of target
	int target = array[tIndex]; // target integer

	 partition(array,0,array.length-1,target);
    }
    public void partition(int[] array, int start, int end, int target){
	int[] newArray = new int[array.length];
	int s = start;
	int e = end;
	for(int i = start; i < end; i++){
	    if(array[i] > target){
		newArray[e] = array[i];
		e--;
	    }else{
		newArray[s] = array[i];
		s++;
	    }
	}
    }

    public static String printArray(int[] array){
	String result = "";
	for(int i = 0; i < array.length; i++){
	    result += array[i] + " ";
	}
	return result;
    }
    
    public static void main(String[]args){
	
	Partition part = new Partition();
	int[] tester = {1,6,4,5,2,3,6,6000};
	System.out.println(part.value);
    }

}
