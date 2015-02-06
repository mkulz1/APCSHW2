public class Recursion{

    public String name(){
	return "Kulyk,Mariya";
    }

    public int fact(int n){
	if (n < 0) 
	    throw new IllegalArgumentException();
	if (n <= 1){
	    return n;
	} else {
	    return n * fact(n-1);
	}
    }

    public static void main(String[]args){

	Recursion r = new Recursion();

	System.out.println(r.fact(3));
	System.out.println(r.fact(4));
	//	System.out.println(r.fact(-4));

    } 

}
