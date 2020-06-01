package junittestcase;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {

	@Test
	public void test() {
		System.out.println("Test 1");
	}

	@Test
	public void secondTest() {
		System.out.println("Test 2");
	}

	@Test
	public void thirdTest() {
		System.out.println("Test 3");
	}

	public void noTest() {
		System.out.println("No Test Case");
	}

}
