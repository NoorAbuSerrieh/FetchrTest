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
import com.fetchr.pages.PrivacyPolicyPage;
import com.fetchr.pages.TrackingPage;
import com.fetchr.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;

public class PrivacyPolicyPageTest extends TestBase {

	TrackingPage trackingPage;
	PrivacyPolicyPage privacyPage;

	public PrivacyPolicyPageTest() throws IOException {
		super();

	}

	@Parameters({ "browser" })
	@BeforeMethod()
	public void login(String browser, Method method) throws IOException {
		Logger = extent.startTest(method.getName());
		Initalization(browser);
		trackingPage = new TrackingPage();
		//record = new ATUTestRecorder("..\\FetchrWebsiteTest\\TestReport", method.getName(), false);
		//record.start();
		privacyPage = trackingPage.clickOnPrivacy();
	}

	@AfterMethod()
	public void close(Method method, ITestResult result) throws  IOException {
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

	@Test(priority = 19)
	public void privacyTitleTest(Method method) throws IOException {
		String expectedResults = "Fetchr Track";
		String actualResults = privacyPage.getTitle();
		Assert.assertEquals(actualResults, expectedResults, "Privacy Title is wrong");
		System.out.println("privacy Title Passed");

	}

	@Test(priority = 20)
	public void privacyUrlCheck(Method method) throws IOException

	{
		String expectedResults = "http://track.fetchr.us/privacy";
		String actualResults = privacyPage.getUrl();
		Assert.assertEquals(actualResults, expectedResults, "Privacy Url is not correct");
		System.out.println("Privacy UR LPassed");
	}

	@Test(priority = 21)
	public void privacyLogoCheck(Method method) throws IOException {

		boolean actualResults = privacyPage.logoIsDisplayed();
		Assert.assertTrue(actualResults, "Privacy logo is not displayed");
		System.out.println("Privacy Logo Passed");
	}

	@Test(priority = 22)
	public void privacySwitchLanguageToArabic(Method method) throws IOException, InterruptedException {

		boolean actualResults = privacyPage.checkchangeLanguageToArabic();
		Assert.assertTrue(actualResults, "Privacy Language is not Changed to Arabic");
		System.out.println("Privacy Change to Arabic Passed");
	}

}
