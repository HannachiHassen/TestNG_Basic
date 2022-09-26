package testNG;

import org.testng.annotations.Test;

public class TestNG_priority {
	@Test (priority=2)
	public void testcase1(){
		System.out.println("Test case 1 Execute 2nd");
	}

	@Test (priority=1)
	public void testcase3(){
		System.out.println("Test case 3 Execute 1st");
	}

	@Test (priority=4)
	public void testcase2(){
		System.out.println("Test case 2 Execute 4th");
	}

	@Test (priority=3)
	public void testcase4(){
		System.out.println("Test case 4 Execute 3rd");
	}

}

