import java.util.Random;

public class Partition{
 
    public int value = -1;
    public int[] arr;

    public Partition(int numElements){
	Random rand = new Random();
	int[] arr = new int[numElements];
	for(int i = 0; i < arr.length; i++){
	    arr[i] = (10 * rand.nextInt());
	}
    }

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

    public String toString(){
	String result = "";
	for(int i = 0; i < arr.length; i++){
	    result = result + arr[i] + " ";
	}
	return result;
    }
    
    public static void main(String[]args){
	
	Partition part = new Partition(10);
	System.out.println(part);
    }

}
