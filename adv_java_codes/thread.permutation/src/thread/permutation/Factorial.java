package thread.permutation;

public class Factorial {

	int number;

	public Factorial(int number) {
		// TODO Auto-generated constructor stub

		this.number = number;
	}

	public int calcFactorial() throws InterruptedException {
		// TODO Auto-generated method stub

		int fn = 1;
		for (int i = 1; i <= number; i++) {
			Thread.sleep(1000);
			fn = fn * 1;
		}

		return fn;
	}

}
