public class LNode{

    private int value;
    private LNode next;

    public LNode(int v){
	value = v;
    }
    public LNode(){
	value = 0;
    }
    
    public LNode getNext(){
	return next;
    }

    public int getValue(){
	return value;
    }

    public void setNext(LNode n){
	next = n;
    }

    public void setValue(int v){
	value = v;
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
