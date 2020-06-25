package thread.permutation;

public class Permutaion {

	public static int permutation(int n, int r) throws InterruptedException {

		Factorial fn = new Factorial(n);
		Factorial fn_r = new Factorial(n-r);
		
		return fn.calcFactorial()/ fn_r.calcFactorial(); 
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	
		int p = permutation(7, 2);
		
		System.out.println(p);
	}

}
