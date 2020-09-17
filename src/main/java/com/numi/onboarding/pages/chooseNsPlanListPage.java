package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;

public class chooseNsPlanListPage extends baseClass {

	@FindBy(xpath = "//h3[contains(text(),'Choose Nutrisystem Plan')]")
	private WebElement chooseNSPlnListPg_Heading;

	@FindBy(xpath = "//li[@id='NS_BASIC']")
	private  WebElement BASICplan;

	@FindBy(xpath = "//li[@id='NS_UNIQUELY_YOURS']")
	private WebElement uniqYrs;

	@FindBy(xpath = "//li[@id='NS_DIABETIC_BASIC']")
	private  WebElement basicDB;

	@FindBy(xpath = "//li[@id='NS_DIABETIC_CORE']")
	private  WebElement coreDB;

	@FindBy(xpath = "//li[@id='NS_DIABETIC_UNIQUELY_YOURS']")
	private  WebElement uniquelyYrsDB;

	@FindBy(id = "AMZN_BLUEPRINT_BALANCED_PLAN")
	private WebElement bp_balancedPlan;

	public chooseNsPlanListPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verify_chooseNSPlnListPg_Heading() {
		return (chooseNSPlnListPg_Heading.isDisplayed());
	}

	public firstWeekStagePage choosePlan(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
			System.out.println(element + " plan is selected");
		} else
			System.out.println("Unable to find element" + element);
		return new firstWeekStagePage();
	}

	public stayOnTrackEMailNotifyPage chooseDBPlan_lessthan100(WebElement element) {
		// if user entered goal weight < 100lbs, email notification page should appear.
		if (element.isDisplayed()) {
			element.click();
			System.out.println(element + " plan is selected");
		} else
			System.out.println("Unable to find plan: " + element);
		return new stayOnTrackEMailNotifyPage();
	}

	public lowBloodSugarPage chooseDBPlan_verifyLowBPPgDisplay(WebElement element) {
		// if user entered goal weight to lose > 100lbs, it returns low BD sugar page.
		if (element.isDisplayed()) {
			element.click();
			System.out.println(element + " plan is selected");
		} else
			System.out.println("Unable to find element" + element);
		return new lowBloodSugarPage();
	}

	public stayOnTrackEMailNotifyPage choose_BluePrint_Plan(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
			System.out.println(element + " plan is selected");
		} else
			System.out.println("Unable to find element" + element);
		return new stayOnTrackEMailNotifyPage();
	}

	public WebElement getBasicDB() {
		return basicDB;
	}

	public WebElement getBASICplan() {
		return BASICplan;
	}

	public WebElement getBp_balancedPlan() {
		return bp_balancedPlan;
	}

	public WebElement getUniqYrs() {
		return uniqYrs;
	}
	public WebElement getCoreDB() {
		return coreDB;
	}
}
