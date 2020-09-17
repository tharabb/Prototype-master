package com.numi.journal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.numi.qa.base.baseClass;

public class journalPg_Activity extends baseClass {

	

	private String logActivityHeaderBttn_xpath = "//span[@class='pull-right dropdown cursor_pointer activity_active']";
	private String addActivity_xpath = "//div[@id='0']//div[@class='pull-right mt5']";
	private String emptyLogActivityBttn_xpath = "//div[@quicklog_activity='null']";
	private String activeLogActivityBttn_xpath  = "//img[@class='active_activity']";
	private String activeActivityText1_xpath = "//div[@class= 'add_activity font14 bold color7']";
	private String activeActivityText2_xpath = "//div[@class= 'font12  color8 ellipse_text']";
	private String activeActivityText3_xpath = "//div[@class= 'font12 color7 activity_list']";
	private String modalHeading_xpath = "//p[text()='Log Time']";
	private String modalInput_xpath = "//input[@class='mt5 log_time_input']";
	private String modalSaveBttn_xpath= "//input[@value='Save']";
	
	private String addActPlusSign_xpath = "//img[@class='cursor_pointer activity_plus_icon']";
	
	//Caret icon to the right of logged activity
	private String caretIcon_xpath = "//img[@class='cursor_pointer activity_caret_icon']";
	
	//Do you want to unlog - Modal
	private String unlog_modal_xpath = "//p[@class='font26 color3 mt5 font700 journal_unlog_activity']";
	private String unlogYes_xpath ="//button[@class='delete_acitivty']";
	
	
	
	public WebElement findTheElement(String xpath) {
		WebElement element= driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public WebElement getemptyLogActivityBttn() {
		WebElement element= driver.findElement(By.xpath(emptyLogActivityBttn_xpath));
		return element;
	}
	
	public WebElement ActivityText1() {
		WebElement element= driver.findElement(By.xpath(activeActivityText1_xpath));
		return element;
	}
	
	public WebElement ActivityText2() {
		WebElement element= driver.findElement(By.xpath(activeActivityText2_xpath));
		return element;
	}
	
	public WebElement ActivityText3() {
		WebElement element= driver.findElement(By.xpath(activeActivityText3_xpath));
		return element;
	}
	
	public WebElement getactiveLogActivityBttn() {
		WebElement element= driver.findElement(By.xpath(activeLogActivityBttn_xpath));
		return element;
	}

	public WebElement getmodalHeading() {
		WebElement element= driver.findElement(By.xpath(modalHeading_xpath));
		return element;
	}
	
	public WebElement getmodalSaveBttn() {
		WebElement element= driver.findElement(By.xpath(modalSaveBttn_xpath));
		return element;
	}
	
	public WebElement getmodalInput() {
		WebElement element= driver.findElement(By.xpath(modalInput_xpath));
		return element;
	}
	
	public WebElement getAddActivityPlusSign() {
		WebElement element = driver.findElement(By.xpath(addActPlusSign_xpath));
		return element;
	}
	
	public WebElement getunlog_modal() {
		WebElement element = driver.findElement(By.xpath(unlog_modal_xpath));
		return element;
	}
	
	public WebElement getunlogYes() {
		WebElement element = driver.findElement(By.xpath(unlogYes_xpath));
		return element;
	}

	public WebElement getcaretIcon() {
		WebElement element = driver.findElement(By.xpath(caretIcon_xpath));
		return element;
	}

//	}

	
	
	
}
