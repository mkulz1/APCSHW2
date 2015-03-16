public class LNode<T> {

    private T data;
    private LNode<T> next;

    public LNode(T data){
	this.setData(data);
    }
    
    public LNode<T> getNext(){
	return next;
    }

    public T getData(){
	return data;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public void setData(T d){
	data = d;
    }
    
    public String toString(){
	String result = "[ ";
	while(this.getNext() != null){   
	    result += this.getData() + " ";
	    result += this.getNext().toString();
	    result += " ]";
		}
	return result;
    }
}
