package UtilityLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerSetUp extends ExtentSetUp implements ITestListener {

	ExtentReports extentreports;
	ExtentTest extenttest;

	@Override
	public void onStart(ITestContext context) {
		extentreports = ExtentSetUp.setUp(context.getSuite().getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extentreports.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, "Test case name is " + result.getMethod().getMethodName());
		// now call screenshot method from extentsetup class
		String dest = ExtentSetUp.screenshot("PassScreenshot", result.getMethod().getMethodName());
		extenttest.addScreenCaptureFromPath(dest);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.log(Status.FAIL, "Test case name is " + result.getMethod().getMethodName());
		String dest = ExtentSetUp.screenshot("FailScreenshot", result.getMethod().getMethodName());
		extenttest.addScreenCaptureFromPath(dest);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.SKIP, "Test case name is" + result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();

	}

}
