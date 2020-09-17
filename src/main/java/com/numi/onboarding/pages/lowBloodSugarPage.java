package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class lowBloodSugarPage extends baseClass {
	@FindBy(xpath = "//h3[@id='LOW_BLOOD_SUGAR']")
	private WebElement bldSugarPage;

	@FindBy(xpath="//label[@for='blood_yes' and @class='yes_text']")
	private WebElement yesLowBldSugar;

	

	@FindBy(className = "no_text")
	private WebElement noLowBldSugar;

	@FindBy(xpath = "//button[@class='tap_d_plan_over100_continue continue_text']")
	private WebElement continueBttn;

	public lowBloodSugarPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getYesLowBldSugar() {
		return yesLowBldSugar;
	}

	public WebElement getNoLowBldSugar() {
		return noLowBldSugar;
	}
	
	public void verifyHeading_lowBSugarPg() {
		String actual_headinglowBSPg = bldSugarPage.getText();
		System.out.println("Title of page is:" + actual_headinglowBSPg);
		if (actual_headinglowBSPg.equalsIgnoreCase(prop.getProperty("exp_headinglowBSPg"))) {
			System.out.println("Low blood sugar page: Title is correct");
		} else
			System.out.println("Low blood sugar page: Title is incorrect");

	}

	public stayOnTrackEMailNotifyPage bloodSugarResposne(WebElement element) {
		if (element.equals(yesLowBldSugar)) {
			w.until(ExpectedConditions.elementToBeClickable(yesLowBldSugar));
			yesLowBldSugar.click();
			System.out.println("Low Blood Sugar Page: Yes button is clicked");
		} else if (element.equals(noLowBldSugar)) {
			w.until(ExpectedConditions.elementToBeClickable(noLowBldSugar));
			noLowBldSugar.click();
			System.out.println("Low Blood Sugar Page: Yes button is not available");
		} else
			System.out.println("Low blood sugar page: Yes or No button are not available");

		continueBttn.click();
		
		return new stayOnTrackEMailNotifyPage();
	}
}
