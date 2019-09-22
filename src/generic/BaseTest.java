package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{

	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(GECKO_KEY, GECKO_PATH);
	}
	@BeforeMethod
	public void launchApplication() throws InterruptedException
	{
		//launch the browser
		driver = new ChromeDriver();
		//enter the url
		driver.get(Lib.getpropertyValue("URL"));
		Thread.sleep(1000);
		//set the implicit wait period
		String timeout = Lib.getpropertyValue("IMPLICIT_WAIT_TIME");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);	
	}
	@AfterMethod
	public void closeApplication(ITestResult res) {
		if (ITestResult.FAILURE== res.getStatus()) {
		Lib.captureScreenshots(driver, res.getName());
		}
		//close the browser
		driver.close();
	}
}
