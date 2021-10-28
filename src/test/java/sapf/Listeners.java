package sapf;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener

{	ExtentTest test;
	ExtentReports extent=ExtentReportNG.getReportobject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result)
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
		 test =  extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		//test.log(Status.PASS,"Teat passed");
		extentTest.get().log(Status.PASS , "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		//test.fail(result.getThrowable());
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		//screcnshot
		String testmethodname = result.getMethod().getMethodName();
		try 
		
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		
		catch(Exception e)
		
		{
			
		}
		try
		
		{
			//i want to attach the screenshot to extent Report
			extentTest.get().addScreenCaptureFromPath(getscreebshotpath(testmethodname,driver), result.getMethod().getMethodName());
		//	getscreebshotpath(testmethodname,driver);
		} 
		
		catch (IOException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) 
	
	{
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
