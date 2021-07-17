package com.fetchr.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.fetchr.util.WebListeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebListeners webListener;
    //public static ATUTestRecorder record;
    public static ExtentReports extent;
    public static ExtentTest Logger;
	
    public TestBase() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("..\\FetchrWebsiteTest\\src\\main\\java\\com\\fetchr\\config\\config.properties");
		prop.load(fis);
	}

	public void Initalization(String browser) throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	 	    driver =new ChromeDriver();
	 	}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
 	        driver =new FirefoxDriver();}
		
 	e_driver = new EventFiringWebDriver(driver);
 	webListener = new WebListeners();
 	e_driver.register(webListener);
 	driver = e_driver;
 	driver.get(prop.getProperty("URL"));
 	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 	
 	}
}
