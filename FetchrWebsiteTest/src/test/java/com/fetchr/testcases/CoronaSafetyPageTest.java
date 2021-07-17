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
import com.fetchr.pages.CoronaSafetyPage;
import com.fetchr.pages.TrackingPage;
import com.fetchr.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;

public class CoronaSafetyPageTest extends TestBase {

	public CoronaSafetyPageTest() throws IOException {
		super();
	}

	TrackingPage trackingPage;
	CoronaSafetyPage CoronaPage;

	@Parameters({ "browser" })
	@BeforeMethod()
	public void setUp(String browser, Method method) throws IOException {
		Logger = extent.startTest(method.getName());
		Initalization(browser);
		trackingPage = new TrackingPage();
		//record = new ATUTestRecorder("..\\FetchrWebsiteTest\\TestReport", method.getName(), false);
		//record.start();
		CoronaPage = trackingPage.clickOnCoronaSafetyPage();

	}

	@AfterMethod()
	public void tearDown(Method method, ITestResult result) throws IOException {
		TestUtils.TakeScreenshot(method.getName());
		//record.stop();
		if (result.getStatus() == ITestResult.SUCCESS) {
			Logger.log(LogStatus.PASS, "Test is Passed");
			Logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png"
					+ "'><span class='lable info'>Download Snapshot</span></a>");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			Logger.log(LogStatus.FAIL, result.getThrowable());
			Logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png"
					+ "'><span class='lable info'>Download Snapshot</span></a>");
		} else {
			Logger.log(LogStatus.SKIP, "Test is Skipped");
		}
		driver.quit();
	}

	@Test(priority = 23)
	public void SafetyTitleTest(Method method) throws IOException,  InterruptedException {
		String expectedResults = "Safety and business continuity during COVID-19 - Fetchr";
		String actualResults = CoronaPage.getTitle();
		Assert.assertEquals(actualResults, expectedResults, "Safety Title is wrong");
		System.out.println("Safety Title Passed");

	}

	@Test(priority = 24)
	public void SafetyUrlCheck(Method method) throws IOException, InterruptedException

	{
		String expectedResults = "https://www.fetchr.us/safety-and-business-continuity-during-covid-19/";
		String actualResults = CoronaPage.getUrl();
		Assert.assertEquals(actualResults, expectedResults, "Safety Url is not correct");
		System.out.println("Safety URL Passed");
	}

	@Test(priority = 25)
	public void SafetyLogoCheck(Method method) throws IOException {

		boolean actualResults = CoronaPage.logoIsDisplayed();
		Assert.assertTrue(actualResults, "Safety logo is not displayed");
		System.out.println("Safety Logo Passed");
	}

	@Test(priority = 26)
	public void SafetyswitchLanguageToArabic(Method method) throws IOException, InterruptedException {
		String expectedResult = "selected";
		String actualResults = CoronaPage.changeLanguageToArabic();
		Assert.assertEquals(actualResults, expectedResult, "Safety Language is not Changed to Arabic");
		System.out.println("Safety Change to Arabic Passed");
	}

	@Test(priority = 27)
	public void checkSafetyFacebookIcon(Method method) throws IOException, InterruptedException {
		boolean actualResults = CoronaPage.checkFacebookIcon();
		Assert.assertTrue(actualResults, "Safety Facebook Icon didn't show");
		System.out.println("Safety Facebook Icon Passed");
	}

	@Test(priority = 28)
	public void checkSafetyTwitterIcon(Method method) throws IOException, InterruptedException {
		boolean actualResults = CoronaPage.checkTwitterkIcon();
		Assert.assertTrue(actualResults, "Safety Twitter Icon didn't show");
		System.out.println("Safety Twitter Icon Passed");
	}

}
