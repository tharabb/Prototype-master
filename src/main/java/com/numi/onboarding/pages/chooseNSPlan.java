package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class chooseNSPlan extends baseClass {
	@FindBy(xpath="//h3[contains(text(),'Choose Nutrisystem Plan')]")
	private WebElement chooseNSPlanPg_Heading;
	
	@FindBy(xpath = "//button[@class='mt10p link_nutrisystem_account']")
	private WebElement linkNsAcctBttn;
	
	@FindBy(xpath="//button[@class='choose_a_new_plan']")
	private WebElement choosePlanBttn;
	
	public chooseNSPlan() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_chooseNSPlanPg_Heading() {
		return(chooseNSPlanPg_Heading.isDisplayed());
	}
	
	public chooseNsPlanListPage choosePlanButton() {
		w.until(ExpectedConditions.elementToBeClickable(choosePlanBttn));
		if(choosePlanBttn.isDisplayed()) {
			choosePlanBttn.click();
			System.out.println("Choose plan button is clicked");
		}else 
			System.out.println("Choose plan button is not available");
		
		return new chooseNsPlanListPage();
	}
	
	
	
}
