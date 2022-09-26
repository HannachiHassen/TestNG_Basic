package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_parameters {
	WebDriver Driver;

	@Parameters("BrowserType")
	@Test
	public void invokeBrowser(String sBrowserType) {
		if (sBrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\chromedriver.exe");
			Driver = new ChromeDriver();
		} else if (sBrowserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\geckodriver.exe");
			Driver = new FirefoxDriver();
		} else if (sBrowserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		}
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.get("http://www.qatechhub.com/v4");
	}

	@Test
	@Parameters("arguments")
	public void singleParameterTest(String s) {
		System.out.println("Testing for input parameter = " + s);
	}

	@Test
	@Parameters({ "id", "name" })
	public void multipleParameterTest(int id, String s) {
		System.out.println("Testing for multiple input parameter = " + id + " and " + s);
	}

	@BeforeSuite
	@Parameters("before_suite")
	public void beforeSuite(String s) {
		System.out.println("Before Suite Parameter = " + s);
	}

	@AfterSuite
	@Parameters("after_suite")
	public void afterSuite(@Optional("Default Parameter") String s) {
		System.out.println("After Suite Parameter = " + s);

	}

}
