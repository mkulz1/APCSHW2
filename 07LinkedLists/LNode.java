public class LNode{

    private int value;
    private LNode next;

    public LNode(int value){
	value = value;
    }
    public LNode(){
	value = 0;
    }
    
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
	String result = "[ ";
	while(this.getNext() != null){   
	    result += this.getValue() + " ";
	    result += this.getNext().toString();
	    result += " ]";
		}
	return result;
    }
}
