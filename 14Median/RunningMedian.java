public class RunningMedian{

    private MyHeap greater,lesser;

    public RunningMedian(){
	greater = new MyHeap(false);
	lesser = new MyHeap(true);
    }

    public String name(){
	return "kulyk.mariya";
    }


    public void add(int value){
	if(greater.heap[0] == 1){
	    greater.add(value);
	    return;
	} else if (lesser.heap[0] == 1){
	    lesser.add(value);
	    return;
	}

	if(value > greater.heap[1]){
	    if(greater.heap[0] - lesser.heap[0] == 1){
		int hold = greater.remove();
		lesser.add(hold);
	    }
	    greater.add(value);
	}else{
	    if(lesser.heap[0] - greater.heap[0] == 1){
		int hold = lesser.remove();
		greater.add(hold);
	    }
	    lesser.add(value);
	}
    }
    
    public double getMedian(){
	if (greater.heap[0] == lesser.heap[0]) {
	    return (greater.peek() + lesser.peek()) / 2;
	} else if (greater.heap[0] > lesser.heap[0]) {
	    return greater.peek();
	} else {
	    return lesser.peek();
	}
    }
	
    public static void main(String[]args){
	RunningMedian test = new RunningMedian();

	test.add(1);
	test.add(5);
	test.add(6);
	test.add(19);
	test.add(56);
	test.add(70);
	test.add(99);

	System.out.println("Median is: ");
	System.out.println(test.getMedian());
	System.out.println(test.greater);
    }

}
