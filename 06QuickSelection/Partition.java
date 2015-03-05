import java.util.Random;

public class Partition{

    
    public static int partition(int[] array){
	Random r  = new Random();
	int target = r.nextInt(array.length);
	return target;
    }
    public static void partition(int[] array, int start, int end, int target){

    }

    public static void main(String[]args){

	Partition part = new Partition();
	int[] tester = {1,6,4,5,2,3,6,6000};

	System.out.println(partition(tester));
    }

}
