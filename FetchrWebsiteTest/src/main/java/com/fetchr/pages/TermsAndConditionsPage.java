package com.fetchr.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fetchr.Base.TestBase;



public class TermsAndConditionsPage extends TestBase{

	
	public TermsAndConditionsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy (xpath = "//img[@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/logo.svg']")
	WebElement TermsLogo;
	
	@FindBy (xpath = "//img[@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/lang_ar.svg']")
	WebElement ChangeLanguage;
	
	@FindBy (xpath = "//img[@src = 'https://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/icn_language_english.pnghttps://s3-eu-west-1.amazonaws.com/staticprod.fetchr.us/mweb_master/image/icn_language_english.png']")
	WebElement EnglishChangeLanguage;
	
	
	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
		}
		
	
	public String getUrl() {
		
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
	
	
	public boolean logoIsDisplayed() {
		
		boolean logoIsDisplayed = TermsLogo.isDisplayed();
		return logoIsDisplayed;
	}
	
    public boolean checkchangeLanguageToArabic() throws InterruptedException {	
		ChangeLanguage.click();
		boolean actualResults = EnglishChangeLanguage.isDisplayed();
		return actualResults;
	}
    
   
 
    		
    }


