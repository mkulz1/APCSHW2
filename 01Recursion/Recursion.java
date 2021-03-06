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
	if (n < 0) 
	    throw new IllegalArgumentException();
	return fibH(n, 0, 1);
    }
    public int fibH(int n, int x, int y){
	if (n==0) 
	    return x;
	return fibH(n - 1, y, x + y);
    }

    public double sqrt(double n){
	if (n < 0) 
	    throw new IllegalArgumentException();
	return sqrtH(n, n / 2);
    }
    public double sqrtH(double n, double g){
	if (Math.abs(g * g - n) < 0.00001)
	    return g;
	return sqrtH(n, ( n / g + g) / 2);
    }
		  

}
