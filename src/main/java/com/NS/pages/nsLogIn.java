package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsLogIn extends baseClass {
	private String newAcctSignUpBttn = "sign-up";
	
	
	public WebElement getSignUpBttn() {
		WebElement element = driver.findElement(By.id(newAcctSignUpBttn));
		return element;
	}

}
