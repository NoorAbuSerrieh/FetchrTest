package com.fetchr.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fetchr.Base.TestBase;

public class CoronaSafetyPage extends TestBase {
	
	public CoronaSafetyPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@class = 'logo col l5 xl5 s5']")
	WebElement SafetyLogo; 
	
	@FindBy(xpath = "//input[@class = 'select-dropdown dropdown-trigger']")
	WebElement LanguageList;
	
	@FindBy(xpath = "(//li[contains(@id ,'select-options-')])[2]")
	WebElement ArabicLangauageButton;
	
	@FindBy (xpath = "//i[@class = 'fa fa-twitter fa-2x']")
	List <WebElement> TwitterIcon;
	
	@FindBy (xpath = "//i[@class = 'fa fa-facebook-f fa-2x']")
	List <WebElement> FacebookButton;
	
	
	
	public String getTitle() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Safety and business continuity during COVID-19 - Fetchr"));
		String actualTitle = driver.getTitle();
		return actualTitle;
		}
	
    public String getUrl() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlMatches("https://www.fetchr.us/safety-and-business-continuity-during-covid-19/"));
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
    
   public boolean logoIsDisplayed() {
		
		boolean logoIsDisplayed = SafetyLogo.isDisplayed();
		return logoIsDisplayed;
	}
	
   public String changeLanguageToArabic() throws InterruptedException {
	  LanguageList.click();
	  ArabicLangauageButton.click();
	  String ActualResults = ArabicLangauageButton.getAttribute("class");
	  return ActualResults;
	}
   
   public boolean checkFacebookIcon() throws InterruptedException {
	   
	   boolean actualResult;
	   int size = FacebookButton.size();   
	   if (size !=0)
        {actualResult = true;}	   
	   else {actualResult = false;}
	   return actualResult;
	  
	   
   }
   
 public boolean checkTwitterkIcon() throws InterruptedException {
	   
	   boolean actualResult;
	   int size = TwitterIcon.size();   
	   if (size !=0)
	   {actualResult = true;}
	   
	   else {actualResult = false;}
	   
	   return actualResult;
	   
   }
    
    
    

	
	
}
