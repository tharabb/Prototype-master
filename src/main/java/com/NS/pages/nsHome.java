package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.numi.qa.base.baseClass;

public class nsHome extends baseClass{
	
	
	
	private String nsSignIn = "//a[@href='https://www.stage.nutrisystem.com/jsp/myaccount/login/login.jsp']";
	//@FindBy (xpath="//a[@href='https://www.stage.nutrisystem.com/jsp/myaccount/login/login.jsp']")
	//private WebElement nsSignIn;
	
	////span[contains(text(),'Log In')]
	
//	public nsHome() {
//		PageFactory.initElements(driver, this);
//	}
	
	public WebElement getnsSignIn() {
		WebElement Element = driver.findElement(By.xpath(nsSignIn));
		return Element;
	}

}
