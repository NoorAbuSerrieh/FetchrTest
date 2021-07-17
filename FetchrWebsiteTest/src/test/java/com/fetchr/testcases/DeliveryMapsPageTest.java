package com.fetchr.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.fetchr.Base.TestBase;
import com.fetchr.pages.DeliveryMapsPage;
import com.fetchr.pages.TrackingPage;
import com.fetchr.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;

public class DeliveryMapsPageTest extends TestBase {

	TrackingPage trackingPage;
	DeliveryMapsPage deliveryMapsPage;

	public DeliveryMapsPageTest() throws IOException {
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
	}

	@AfterMethod()
	public void close(Method method, ITestResult result) throws IOException {
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

}