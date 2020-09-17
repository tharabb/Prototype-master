package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;
import com.numi.qa.base.randomEmail;

public class setUpAcctPage extends baseClass{

	@FindBy(xpath="//h5[contains(text(),'setting up your account')]")
	private WebElement setUpacctPage_heading;
	
	@FindBy (xpath="//input[@class='field_mandatory profile_first_name_text']")
	private WebElement firstNameInputBox;
	
	@FindBy (xpath="//input[@class='field_mandatory profile_last_name_text']")
	private WebElement lastNameInputBox;
	
	@FindBy (xpath="//span[@class='men']")
	private WebElement maleGender;
	
	@FindBy (xpath="//input[@id='female']")
	private WebElement femaleGender;
	
	@FindBy (xpath="//input[@class='continue_text btn disabled']")
	private WebElement continueDisabled;
	
	@FindBy (xpath="//input[@class='continue_text']")
	private WebElement continueEnabled;
	
	public setUpAcctPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_setUpAcctPageHeading() {
		return(setUpacctPage_heading.isDisplayed()) ;		
	}
	
	public acctDetailsPage setUpNewUserAcct() {
		firstNameInputBox.sendKeys(randomEmail.generateFirstName());
		lastNameInputBox.sendKeys(prop.getProperty("lastName"));
		maleGender.click();
		if (continueEnabled.isDisplayed()) {
			System.out.println("Continue button is Enabled on entering firstName, lastName and selecting gender");
		}else System.out.println("Continue button is disabled");
		continueEnabled.click();
		return new acctDetailsPage();
		
	}
	
	
	
	
	
}
