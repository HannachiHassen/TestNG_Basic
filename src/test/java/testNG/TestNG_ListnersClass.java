package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(ListenersTestNG.class)
public class TestNG_ListnersClass {
	WebDriver driver = null;

	@BeforeClass
	public void OpenBrowser() {
		Reporter.log("Launching Firefox driver for this test");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.demoqa.com");
		System.out.println("Before Class Method Started");
	}

	@Test// Success Test
	public void urlCheck() {
		String expectedUrl="https://www.demoqa.com/";
		String origanalUrl=driver.getCurrentUrl();
		Assert.assertEquals(origanalUrl, expectedUrl,"URL of the website does match");
	}

	@Test // Failed Test
	public void titleComparision() {
		String expectedTitle = "Free QA Automation Tools For Everyone";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}

	private int i = 1;

	@Test(successPercentage = 60, invocationCount = 3) // Failing Within Success
	public void AccountTest() {
		if (i < 2)
			Assert.assertEquals(i, i);
		i++;
	}

	@Test // Skip Test
	public void SkipTest() {
		throw new SkipException("Skipping The Test Method ");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
		System.out.println("After Class Method Started");
		Reporter.log("Driver Closed After Testing");
	}
}
