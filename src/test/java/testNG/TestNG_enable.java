package testNG;

import org.testng.annotations.Test;

public class TestNG_enable {
	@Test 
	public void testcase1(){
		System.out.println("Test case 1");
	}

	@Test
	public void testcase3(){
		System.out.println("Test case 3");
	}

	@Test (enabled= false)
	public void testcase2(){
		System.out.println("Test case 2 is disabled");
	}

	@Test 
	public void testcase4(){
		System.out.println("Test case 4");
	}

}
