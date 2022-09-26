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

public class TestNG_dataProvider {
	WebDriver Driver;

	@BeforeMethod
	private void invokeBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HASSEN\\workspace\\basicselenium\\Drivers\\geckodriver.exe");
		Driver = new FirefoxDriver();

		Driver.navigate().to("https://www.facebook.com/");
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "getData")
	public void loginFacebook(String username, String password) {
		Driver.findElement(By.id("email")).sendKeys(username);
		Driver.findElement(By.id("pass")).sendKeys(password);
		Driver.findElement(By.id("u_0_b")).click();
		
		System.out.println("Username=" +username);
		Reporter.log("Test Executed successfully");
	}

	@DataProvider()
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "username1@gmail.com";
		data[0][1] = "password1";

		data[1][0] = "username2@gmail.com";
		data[1][1] = "password2";

		data[2][0] = "username3@gmail.com";
		data[2][1] = "password3";

		return data;
	}
	
	@AfterMethod
	private void closeBrowser() {
		Driver.close();
		Reporter.log("Driver Closed After Testing");
	}
}
