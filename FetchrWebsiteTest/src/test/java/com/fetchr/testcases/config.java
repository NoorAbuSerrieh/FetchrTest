package com.fetchr.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.fetchr.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;

public class config extends TestBase {
	
	public config() throws IOException {
		super();
	}
	
	@BeforeSuite
    public void start() {
		extent = new ExtentReports( "..\\FetchrWebsiteTest\\TestReport\\index.html", true);
		extent.addSystemInfo("OS", "Windows");
		extent.addSystemInfo("Owner", "Noor AbuSerrieh");
		extent.addSystemInfo("Test Name", "Fetchr Test");
		extent.addSystemInfo("Language", "Java");
		
	}
	
	@AfterSuite
	public void End() {
		extent.flush();
		
	}
}
