package com.numi.journal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;
import com.numi.qa.base.randomEmail;

public class journalPage extends baseClass {
	
	@FindBy(xpath="//h1[contains(text(),'Journal')]")
	private WebElement journalPg_Heading; 
	
	@FindBy (xpath= "//span[@class='relative cursor_pointer']")
	private WebElement userFirstname;
	
	@FindBy(xpath ="//img[@class='cursor_pointer journal_help']")
	private WebElement journalHelp;
	
	public journalPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verify_journalPg_Heading() {
		return(journalPg_Heading.isDisplayed());
	}
	
	public WebElement getJournalPg_Heading() {
		return journalPg_Heading;
	}
	
	public String actualProfileNameDisplay() {
		String actualProfileName= userFirstname.getText();
		System.out.println("Actual Profile name: " +actualProfileName);
		return actualProfileName;
		}
	
	public void checkProfileNameDisplay() {
		String actualProfileName= userFirstname.getText();
		System.out.println("Actual Profile name: " +actualProfileName);
		String ExpectedProfileName = randomEmail.generateFirstName();
		if(actualProfileName.equalsIgnoreCase(ExpectedProfileName)) {
			System.out.println("Profile name in journal page displays correctly");
		} else {
			System.out.println("Profile name displays incorrectly!!");
		}
		//return ActualFn;
//		if (ActualFn.equalsIgnoreCase(prop.getProperty("firstName"))) {
//			System.out.println("Onboarding for "+ActualFn+" is successfull!!");
//		}else System.out.println("Firstname is not matching, onboarding unsuccessfull!!");
			
	}

	public WebElement getJournalHelp() {
		return journalHelp;
	}
}
