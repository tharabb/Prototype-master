package com.numi.journal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;

public class journalPg_Activity1 extends baseClass{

	
	
	@FindBy(xpath="//span[@class='pull-right dropdown cursor_pointer activity_active']")
	private WebElement logActivityHeaderBttn; 
	
	@FindBy(xpath="//div[@id='0']//div[@class='pull-right mt5']")
	private WebElement addActivity;
		
	@FindBy(xpath="//div[@quicklog_activity='null']")
	private WebElement emptyLogActivityBttn;
		
	@FindBy(xpath="//img[@class='active_activity']")
	private WebElement activeLogActivityBttn;
	
	@FindBy (xpath="//input[@class='mt5 log_time_input']")
	private WebElement modalInput;
	
	@FindBy (xpath="//input[@value='Save']")
	private WebElement modalSaveBttn;

	
public journalPg_Activity1() {
	PageFactory.initElements(driver, this);
}

public WebElement getemptyLogActivityBttn() {
	return emptyLogActivityBttn;
}

public WebElement getmodalInput() {
	return modalInput;	
}

public WebElement getmodalSaveBttn() {
	return modalSaveBttn;
}

public WebElement getactiveLogActivityBttn() {
	return activeLogActivityBttn;
}


}
