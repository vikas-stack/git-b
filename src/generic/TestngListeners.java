package generic;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngListeners implements ISuiteListener,ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	Reporter.log(result.getName()+ "--> Test method is started..",true);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+ "--> Test method is pass..",true);	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+ "--> Test method is failed..",true);	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+ "--> Test method is skipped..",true);	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName()+ "-->  block is started..",true);	
	}

	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName()+ "-->  block is finished..",true);
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+ "--> started.....",true);	
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log(suite.getName()+ "--> ended.....",true);
	}	
}

	
