package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_dataProvider2 {
	private WebDriver driver;

	@BeforeMethod
	private void invokeBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.navigate().to("https://www.demoqa.com/login");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) {
		
		// Argument passed will be used here as String Variable
		driver.findElement(By.id("userName")).sendKeys(sUsername);
		driver.findElement(By.id("password")).sendKeys(sPassword);
		driver.findElement(By.id("login")).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		// The number of times data is repeated, test will be executed the same no. of times
        // Here it will execute two times
		return new Object[][] { { "testuser1", "Test@123" }, { "testuser1", "Test@123" } };
	}

	@AfterMethod
	private void closeBrowser() {
		driver.close();
		Reporter.log("Driver Closed After Testing");
	}
}
