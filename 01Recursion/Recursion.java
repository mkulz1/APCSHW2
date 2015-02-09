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

    public int fib(int n){
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return fibH(n, 0, 1);
    }
    public int fibH(int n, int x, int y){
	if (n==0) 
	    return x;
	return fibH(n - 1, y, x + y);
    }
		  
    public static void main(String[]args){

	Recursion r = new Recursion();

	System.out.println(r.fact(3));
	System.out.println(r.fact(4));
	//	System.out.println(r.fact(-4));
	System.out.println(r.fib(5));
	System.out.println(r.fib(10));

    } 

}
