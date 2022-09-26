package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_order {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before a suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t Executed before a test in a suite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\t Executed as last method in the class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t Executing before a testcase");
	}

	@Test
	public void testcase1() {
		System.out.println("\t\t\t\t execute test case 1");
	}

	@Test
	public void testcase2() {
		System.out.println("\t\t\t\t execute test case 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t Executing after a testcase");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\t\t Executed as first method in the class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\t Executed after a test in a suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After a suite");
	}

}
