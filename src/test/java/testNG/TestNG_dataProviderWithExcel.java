package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicExcelUtils;

public class TestNG_dataProviderWithExcel {
	WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void beforeMethod() throws Exception {
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
	public void test(String sUsername, String sPassword) throws Exception {

		// Argument passed will be used here as String Variable
		driver.findElement(By.id("userName")).sendKeys(sUsername);
		driver.findElement(By.id("password")).sendKeys(sPassword);
		driver.findElement(By.id("login")).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		// Setting up the Test Data Excel file
		BasicExcelUtils.setExcelFile(".//TestData.xlsx", "Sheet1");

		sTestCaseName = this.toString();

		// From above method we get long test case name including package and class name etc.
		// The below method will refine your test case name, exactly the name use have used

		sTestCaseName = BasicExcelUtils.getTestCaseName(this.toString());

		// Fetching the Test Case row number from the Test Data Sheet
		// Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

		iTestCaseRow = BasicExcelUtils.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = BasicExcelUtils.getTableArray(".//TestData.xlsx","Sheet1", iTestCaseRow);
		return (testObjArray);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
