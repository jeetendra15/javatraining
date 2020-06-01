package junittestcase;

import org.junit.Test;

public class SimpleMathTest {

	@Test
	public void test1() {

		int x = 10, y = 20;
		double result = SimpleMath.plus(x, y);

		System.out.println("sum :" + result);
	}

}
