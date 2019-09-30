package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{

	@Test
	public void testInvalidLogin() {
		try {
			LoginPage lp = new LoginPage(driver);
			String username =Lib.getCellValue("inputdata", "invalidLogin", 1, 0);
			String password =Lib.getCellValue("inputdata", "invalidLogin", 1, 1);	
			System.out.println(username);
			System.out.println(password);
			lp.setUsername(username);
			Thread.sleep(3000);
			//enter the manager
			lp.setPassword(password);
			Thread.sleep(3000);
			//click on login button
			lp.clickLogin();
			//Thread.sleep(6000);
		}catch (Exception e)
		{
		e.printStackTrace();	
		}
		//polling period or pooling period 500 milliseconds
		//wait till the home page is completely loaded (condition to be true)
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track123"));//TimeoutException
		//Whether i am successfuly navigate to home page or not ?
		String actHomePageTitle = driver.getTitle();
		System.out.println("Home page title is : "+ actHomePageTitle);
		Assert.assertEquals(actHomePageTitle, "actiTIME - Enter Time-Track");
	}
}
		