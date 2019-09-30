package scripts;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin() {
		int totalRowCount = Lib.getTotalRowCount("inputdata", "InvalidLogin");
		LoginPage lp = new LoginPage(driver);
		for(int i=1; i<=totalRowCount; i++)
		{
		String username =Lib.getCellValue("inputdata", "invalidLogin", i, 0);
		String password =Lib.getCellValue("inputdata", "invalidLogin", i, 1);	
		
		lp.setUsername(username);
		lp.setUsername(password);	
		lp.clickLogin();
	}
}
}