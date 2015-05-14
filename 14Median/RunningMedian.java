public class RunningMedian{

    private MyHeap greater,lesser;

    public RunningMedian(){
	greater = new MyHeap(false);
	lesser = new MyHeap(true);
    }

    public void add(int value){
	if(value > getMedian())
    }

    public double getMedian(){
	if (greater.heap[0] == lesser.heap[0]) {
	    return (greater.peak() + lesser.peak()) / 2;
	} else if (greater.heap[0] > lesser.heap[0]) {
	    return greater.peak();
	} else {
	    return lesser.peak();
	}
	
    public static void main(String[]args){

    }

}
