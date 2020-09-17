package com.numi.settings.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

public class Settings extends baseClass {
	keywordFunctions kf = new keywordFunctions();

	@FindBy (xpath = "//a[contains(text(),'Settings')]")
	WebElement settingsBttn; 
	
	@FindBy (xpath = "//h1[@class='journal_hdr pull-left settings_title']")
	WebElement settingsHeading; 
	
	public Settings(){
		PageFactory.initElements(driver, this);		
	}
	
	public void verify_settingPg_Heading() {
		if(settingsHeading.isDisplayed()==true) {
			System.out.println("Settings heading is displayed");
		}else System.out.println("Settings heading is not displayed");
	}
	
	public void clickOnSettings() {
		kf.click(settingsBttn, "settingsButton");
		//verify if the application is navigating to settings page
		verify_settingPg_Heading();	
	}

	
	
	
	
	
	
}
