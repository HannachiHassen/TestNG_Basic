package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_assertions {
	WebDriver Driver;
	SoftAssert soft = new SoftAssert();
	
	@Test(priority =10)
	public void openBrowser() {
		Reporter.log("Launching Firefox driver for this test");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\geckodriver.exe");
		Driver = new FirefoxDriver();
		Driver.manage().window().maximize();
		Driver.get("http://www.qatechhub.com");
	}

	@Test(priority = 20)
	public void compareTitle() {		
		
		Reporter.log("The website used for this test was qatechhub",true);

		Assert.assertEquals(Driver.getTitle(), "QA Automation Tools Trainings and Tutorials | QA Tech Hub");		
	}

	@Test(priority = 30)
	public void softAssert() {
		String expectedTitle="Qa Automation Tools Trainings and Tutorials  | QA Tech Hub";
		String originalTitle=Driver.getTitle();
		
		soft.assertEquals(originalTitle, expectedTitle);
		
		System.out.println("softAssert Method Was Executed");
		soft.assertAll();
	}

	@Test(priority = 40,retryAnalyzer = com.listeners.RetryFailedTests.class)
	public void hardAssert() {
		Assert.assertTrue(false);
		System.out.println("hardAssert Method Was Executed");
	}
	
	@Test(priority = 50)
	public void closeBrowser() {
		Driver.close();
		Reporter.log("Close Driver for Testing");
	}
	
}
