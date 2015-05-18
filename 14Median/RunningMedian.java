public class RunningMedian{

    private MyHeap greater,lesser;

    public RunningMedian(){
	greater = new MyHeap(false);
	lesser = new MyHeap(true);
    }

    public void add(int value){
	if(lesser.heap[0] == 1){
	    lesser.add(value);
	    return;
	} else if (greater.heap[0] == 1){
	    greater.add(value);
	    return;
	}

	if(value > getMedian()){
	    greater.add(value);
	}else{
	    lesser.add(value);
	}
    }

    public double getMedian(){
	if (greater.heap[0] == lesser.heap[0]) {
	    System.out.println("They are both of equal length!");
	    System.out.println("Greater is: " + greater.peek());
	    System.out.println("Lesser is: " + lesser.peek());
	    return ((double)greater.peek() + (double)lesser.peek()) / 2;
	} else if (greater.heap[0] > lesser.heap[0]) {
	    return greater.peek();
	} else {
	    return lesser.peek();
	}
    }
	
    public static void main(String[]args){
	RunningMedian test = new RunningMedian();

	test.add(9);
	test.add(8);
	test.add(6);

	System.out.println("Median is: ");
	System.out.println(test.getMedian());
    }

}
