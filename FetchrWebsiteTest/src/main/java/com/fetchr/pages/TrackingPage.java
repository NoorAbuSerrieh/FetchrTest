package com.fetchr.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fetchr.Base.TestBase;

public class TrackingPage extends TestBase {
	
	public TrackingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//img[@class = 'logo-homepage text-center']")
	WebElement Logo; 
	
	@FindBy(xpath = "//a[@class = 'corona-close']")
	WebElement CoronaClose;
	
	@FindBy(linkText = "Terms & Conditions")
	WebElement TermsAndConditions;
	
	@FindBy(linkText = "Privacy policy")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath = "//img [@id = 'changeAppLang']")
	WebElement ChangeLanguage;
	
	@FindBy (xpath = "//img [@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/logo-ar-fetchr.png']")
	WebElement ArabicLogo;
	
	@FindBy(id = "tracking_id")
	WebElement TrackingIdSearch;
	
	@FindBy (xpath = "//div[contains(text(),'This order')]")
	WebElement OrderStatus;
	
	@FindBy(id = "search_submit")
	WebElement SearchButton;
	
	@FindBy (linkText = "Click here")
	WebElement CoronaSafetyButton;
	
	@FindBy (linkText = "Order history")
	WebElement OrderHistoryButton;
	
	@FindBy (linkText = "Reschedule order")
	WebElement RescheduleOrderButton;
	
	@FindBy(xpath = "//img[@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/warning.png']")
	WebElement ErrorIcon;
	
	@FindBy(xpath = "//img[@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/icn_truck.png']")
	WebElement ShipmentDeliveyIcon;
	
	@FindBy (xpath = "//button[@class='btn btn-default btn-style']")
	WebElement exitIcon;
	
	@FindBy (xpath = "//div[contains(text(),'This tracking number is invalid.')]")
	WebElement InvalidNumberMessage;
	         
	
	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
		}
		
	
	public String getUrl() {
		
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
	
	public boolean logoIsDisplayed() {
		
		boolean logoIsDisplayed = Logo.isDisplayed();
		return logoIsDisplayed;
	}
	
		
	public void clickOnClose() {
		
		CoronaClose.click();
	}
	
	public boolean changeLanguageToArabic() throws InterruptedException {
		ChangeLanguage.click();
		boolean ActualResults = ArabicLogo.isDisplayed();
		return ActualResults;
		
	}
		
	public boolean checkOrderTrackingNumberStatus(String trackNum) {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		boolean actualResult = OrderStatus.isDisplayed();
		return actualResult;
	}
	
	public boolean checkInvalidInputOrderTrackingNumberStatus(String trackNum) {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		boolean actualResult = ErrorIcon.isDisplayed();
		return actualResult;
	}
	
	public boolean checkInvalidOrderTrackingNumberStatus(String trackNum) {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		boolean actualResult = InvalidNumberMessage.isDisplayed();
		return actualResult;
	}
	
	public boolean CheckEmptyOrderStatus( ) {
		TrackingIdSearch.sendKeys("");
		SearchButton.click();
		boolean actualResult = ErrorIcon.isDisplayed();
		return actualResult;
	}
	
	
	public CoronaSafetyPage clickOnCoronaSafetyPage() throws IOException {
		CoronaSafetyButton.click();
		
        Set <String> ids = driver.getWindowHandles(); 
        Iterator <String> it = ids.iterator();
        String ParentID =it.next();
        String ChildID = it.next();
        driver.switchTo().window(ChildID);
        return new CoronaSafetyPage();
	}
	
	public DeliveryMapsPage navigateToMapsPage(String trackNum) throws IOException {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		return new DeliveryMapsPage();
	} 
	
	public String checkOrderHistory(String trackNum) {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		OrderHistoryButton.click();
		String actualResult = ShipmentDeliveyIcon.getTagName();
		return actualResult;
	}
	
	public DeliveryMapsPage navigateToResheduleScreen(String trackNum) throws IOException {
		TrackingIdSearch.sendKeys(trackNum);
		SearchButton.click();
		RescheduleOrderButton.click();
		return new DeliveryMapsPage();	
	}

	
	public TermsAndConditionsPage clickOnTerms() throws IOException {
		TermsAndConditions.click();
		return new TermsAndConditionsPage();
		
	}
	
	public PrivacyPolicyPage clickOnPrivacy() throws IOException {
		PrivacyPolicy.click();
		return new PrivacyPolicyPage();
	}
  
		
	}

	
