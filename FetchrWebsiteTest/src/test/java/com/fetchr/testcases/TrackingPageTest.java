package com.fetchr.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fetchr.Base.TestBase;
import com.fetchr.pages.CoronaSafetyPage;
import com.fetchr.pages.DeliveryMapsPage;
import com.fetchr.pages.PrivacyPolicyPage;
import com.fetchr.pages.TermsAndConditionsPage;
import com.fetchr.pages.TrackingPage;
import com.fetchr.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
//import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
public class TrackingPageTest extends TestBase {
	
	public TrackingPageTest() throws IOException {
		super();
		
	}

	TrackingPage trackingPage;
	TermsAndConditionsPage termPage;
	CoronaSafetyPage coronaPage;
	DeliveryMapsPage deliveryMapsPage;
	PrivacyPolicyPage policyPage;
	

	
	@Parameters({"browser"})
	@BeforeMethod() 
	public void setUp(String browser, Method method) throws ATUTestRecorderException, IOException{
	Logger = extent.startTest(method.getName());
	Initalization(browser);
	trackingPage = new TrackingPage();
	//record = new ATUTestRecorder("..\\FetchrWebsiteTest\\TestReport",method.getName(), false);
 	//record.start();
		
	}	
	
	@AfterMethod()
	public void tearDown(Method method , ITestResult result) throws ATUTestRecorderException, IOException {
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

	
	@Test(priority= 1 )
	public void trackingTitleTest(Method method) throws IOException, ATUTestRecorderException { 
		String expectedResults = "Fetchr Track";
    	String actualResults = trackingPage.getTitle();
    	Assert.assertEquals(actualResults, expectedResults, "Tracking Title is wrong");
    	System.out.println("Tracking Title Passed");
     	
	}
		
	
	@Test (priority= 2)
	public void trackingUrlCheck(Method method) throws IOException
	
	{	
    	String expectedResults = "http://track.fetchr.us/";
    	String actualResults= trackingPage.getUrl();
	    Assert.assertEquals(actualResults, expectedResults, "Tracking Url is not correct");
		System.out.println("Tracking URL Passed");
	}
	
	
	@Test (priority= 3)
	public void trackingLogoCheck(Method method) throws IOException
	{
	  trackingPage.clickOnClose();
      boolean actualResults= trackingPage.logoIsDisplayed();
      Assert.assertTrue(actualResults, "Tracking logo is not displayed");
      System.out.println("Tracking Logo Passed");    
	}
	
	@Test (priority= 4)
	public void switchLanguageToArabic(Method method) throws IOException, InterruptedException
	{	
		trackingPage.clickOnClose();
		Thread.sleep(20);
		boolean actualResults = trackingPage.changeLanguageToArabic();
		Assert.assertTrue(actualResults, "Tracking Language is not Changed to Arabic");
		System.out.println("Tracking Change to Arabic Passed");
	}
	
	@Test(priority= 5 , dataProvider = "testData")
	public void checkTheStatusOfOrderByTrackingNum (String trackNum,  Method method) throws IOException
		{		
			boolean actualResults = trackingPage.checkOrderTrackingNumberStatus(trackNum);
			Assert.assertTrue(actualResults, "Order Status is not displayed");
			System.out.println("Order Tracking Status Passed");
	}

	@Test(priority= 6)
	public void clickOnCoronaSafetyMessage (Method method) throws IOException, InterruptedException
		{	
		
		    coronaPage = trackingPage.clickOnCoronaSafetyPage();
		    String expectedResults = "https://www.fetchr.us/safety-and-business-continuity-during-covid-19/";
			String actualResults = coronaPage.getUrl();
		    Assert.assertEquals(actualResults, expectedResults, "Corona Message is not Displayed");
			System.out.println("Click On Corona Message Passed");
	}
	
	
	@Test(priority= 7, dataProvider = "testData2")
    public void navigateToDeliveryMapsScreen (String trackNum, Method method) throws IOException
		{	
		
		    deliveryMapsPage = trackingPage.navigateToMapsPage(trackNum);
		    boolean actualResults = deliveryMapsPage.CheckConfirmDeliveryLocationButton();
			Assert.assertTrue(actualResults, "Location Confirm Button is not displayed");
			System.out.println("Navigate to maps Passed");
	}
	
	@Test (priority = 8, dataProvider = "testData3" )
	public void checkOrderHistory (String trackNum,  Method method) throws IOException
	{	
		String expectedResults = "img";
		String actualResults = trackingPage.checkOrderHistory(trackNum);
		Assert.assertEquals(actualResults, expectedResults, "History dialog is not displayed");
		System.out.println("Order History Passed");
    }
	
	@Test (priority = 9, dataProvider = "testData5")
	public void searchingForInvalidOrderNumbers(String trackNum,  Method method) throws IOException
	{	
		boolean actualResults = trackingPage.checkInvalidOrderTrackingNumberStatus(trackNum);
		Assert.assertTrue(actualResults, "Error message is not displayed");
		System.out.println("Invalid Number for Orders Passed");
    }
	
	@Test (priority = 10, dataProvider = "testData4")
	public void enteringInvalidInputInOrderNumbers(String trackNum,  Method method) throws IOException
	{	
		boolean actualResults = trackingPage.checkInvalidInputOrderTrackingNumberStatus(trackNum);
		Assert.assertTrue(actualResults, "Error message is not displayed");
		System.out.println("Invalid Input for Orders Passed");
    }
	
	@Test (priority = 11)
	public void searchForEmptyOrderTrackingNumbers(Method method) throws IOException
	{	
		boolean actualResults = trackingPage.CheckEmptyOrderStatus();
		Assert.assertTrue(actualResults, "Error message is not displayed");
		System.out.println("Empty Order Tracking Number Passed");
    }
	
	@Test (priority = 12, dataProvider = "testData3")
	public void NavigatetoRescheduleOrderScreem (String trackNum,  Method method) throws IOException
	{	
		deliveryMapsPage = trackingPage.navigateToResheduleScreen(trackNum);
	    boolean actualResults = deliveryMapsPage.CheckConfirmDeliveryLocationButton();
		Assert.assertTrue(actualResults, "Confirm Button is not displayed");
		System.out.println("Navigate to Reschedule Order Passed");
}
	
	@Test (priority= 13)
	public void clickOnPrivacyPolicy(Method method) throws IOException
	{		
		policyPage = trackingPage.clickOnPrivacy();
		String expectedResults = "http://track.fetchr.us/privacy";
		String actualResults = policyPage.getUrl();
		Assert.assertEquals(actualResults, expectedResults, "Not able to navigate to Terms and Conditions page");
	    System.out.println("ClickOnTermsPassed");
	}
	
	@Test (priority= 14)
	public void clickOnTermsAndConditions(Method method) throws IOException
	{		
		termPage = trackingPage.clickOnTerms();
		String expectedResults = "http://track.fetchr.us/terms";
		String actualResults = termPage.getUrl();
		Assert.assertEquals(actualResults, expectedResults, "Not able to navigate to Terms and Conditions page");
	    System.out.println("ClickOnTermsPassed");
	}
	
	
	

	@DataProvider
	public Object[][] testData() throws IOException {
		Object [][] data = TestUtils.getDataFromExcel("OrdersTrackingNums");
		
		return data;
	}
	
	@DataProvider
	public Object[][] testData2() throws IOException {
		Object [][] data = TestUtils.getDataFromExcel("OrderToDeliveryNum");
		
		return data;
	}
	
	@DataProvider
	public Object[][] testData3() throws IOException {
		Object [][] data = TestUtils.getDataFromExcel("OrderWithHistoryNum");
		
		return data;
	}
	@DataProvider
	public Object[][] testData4() throws IOException {
		Object [][] data = TestUtils.getDataFromExcel("InvalidInputsOrderNumbers");
		
		return data;
	}
	
	@DataProvider
	public Object[][] testData5() throws IOException {
		Object [][] data = TestUtils.getDataFromExcel("InvalidOrderNumber");
		
		return data;
	}

	
}
