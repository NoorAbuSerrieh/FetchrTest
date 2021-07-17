package com.fetchr.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fetchr.Base.TestBase;
import com.fetchr.pages.TermsAndConditionsPage;
import com.fetchr.pages.TrackingPage;
import com.fetchr.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;



public class TermsAndConditionsPageTest extends TestBase{
	
	TrackingPage trackingPage;
	TermsAndConditionsPage termPage;
	
	public TermsAndConditionsPageTest() throws IOException {
		super();
		
	}
	
	@Parameters({"browser"})
	@BeforeMethod()
	public void login(String browser, Method method) throws IOException
	{
		Logger = extent.startTest(method.getName());
		Initalization(browser);
		trackingPage = new TrackingPage();
		//record = new ATUTestRecorder("..\\FetchrWebsiteTest\\TestReport",method.getName(), false);
	 	//record.start();
	 	termPage = trackingPage.clickOnTerms();
	}
	
	@AfterMethod()
	public void close(Method method, ITestResult result) throws IOException
	{
		TestUtils.TakeScreenshot(method.getName());
		//record.stop();
		if (result.getStatus() == ITestResult.SUCCESS ) {
			Logger.log(LogStatus.PASS, "Test is Passed");
			Logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}else if (result.getStatus() == ITestResult.FAILURE) {
			Logger.log(LogStatus.FAIL, result.getThrowable());
			Logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}else {
			Logger.log(LogStatus.SKIP, "Test is Skipped");
		}
		driver.quit();
	}
	
	@Test(priority= 15)
	public void termsTitleTest(Method method) throws IOException {
		String expectedResults = "Fetchr Track";
    	String actualResults = termPage.getTitle();
    	Assert.assertEquals(actualResults, expectedResults, "Terms Title is wrong");
    	System.out.println("Terms Title Passed");
     	
	}
	
	@Test (priority= 16)
	public void termsUrlCheck(Method method) throws IOException
	
	{	
    	String expectedResults = "http://track.fetchr.us/terms";
    	String actualResults= termPage.getUrl();
	    Assert.assertEquals(actualResults, expectedResults, "Terms Url is not correct");
		System.out.println("Terms URL Passed");
	}
	
	
	@Test (priority= 17)
	public void termsLogoCheck(Method method) throws IOException
	{
	
      boolean actualResults= termPage.logoIsDisplayed();
      Assert.assertTrue(actualResults, "Terms logo is not displayed");
      System.out.println("Terms Logo Passed");    
	}
	
	@Test (priority= 18)
	public void termsSwitchLanguageToArabic(Method method) throws IOException, InterruptedException
	{	
		
		boolean actualResults = termPage.checkchangeLanguageToArabic();
		Assert.assertTrue(actualResults, "Terms Language is not Changed to Arabic");
		System.out.println("Terms Change to Arabic Passed");
	}
	
	
	
}
