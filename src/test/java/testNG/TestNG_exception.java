package testNG;

import org.testng.annotations.Test;

public class TestNG_exception {
	@Test(expectedExceptions = ArithmeticException.class)
	public void testException() {
		System.out.println("SoftwareTestingMaterial.com");
		int i = 1 / 0;	
	}

}
