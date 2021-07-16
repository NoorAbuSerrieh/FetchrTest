package com.fetchr.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fetchr.Base.TestBase;

public class DeliveryMapsPage extends TestBase {
	
	public DeliveryMapsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id =  "confirmSchedule")
	WebElement ConfirmDeliveryLocationButton;
	
	
	public boolean CheckConfirmDeliveryLocationButton() {
		boolean actualResult = ConfirmDeliveryLocationButton.isDisplayed();
		return actualResult;
	}
	
}
