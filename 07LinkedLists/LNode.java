public class LNode{

    private int value;
    private LNode next;

    public LNode getNext(){
	return this.next;
    }

    public int getValue(){
	return this.value;
    }

    public void setNext(LNode next){
	this.next = next;
    }

    public void setValue(int value){
	this.value = value;
    }
    
    public String toString(){
	String result = "";
	result += value;
	return result;
    }
    
    
}
