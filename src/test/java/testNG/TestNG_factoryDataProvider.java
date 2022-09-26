package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_factoryDataProvider {
	private String str;
	private int param;

	public TestNG_factoryDataProvider(String s) {
		this.str = s;
	}

	@Test
	public void test1() {
		System.out.println("Test1 test method. str = " + str);
	}

	@Test
	public void testMethodOne() {
		int opValue = param + 1;
		System.out.println("Test method one output: " + opValue);
	}

	@Test
	public void testMethodTwo() {
		int opValue = param + 2;
		System.out.println("Test method two output: " + opValue);
	}
	
	@DataProvider
	public Object[][] dataMethod() {
		return new Object [][] {{2},{3}};
	}
	
}
