package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsSignUpToday extends baseClass {

	private String nsFirstName = "FirstName";
	private String email = "email_address";
	private String pswd = "nutrisystem_password";
	private String female = "//input[@value='female']";
	private String male = "//input[@value='male']";
	private String createMyAcct = "submitMembership";

	//
	
	
	public WebElement nsFN() {
		WebElement element = driver.findElement(By.id(nsFirstName));
		return element;
	}

	public WebElement email() {
		WebElement element = driver.findElement(By.id(email));
		return element;
	}
	
	public WebElement pwd() {
		WebElement element = driver.findElement(By.id(pswd));
		return element;
	}
	
	public WebElement female() {
		WebElement element = driver.findElement(By.xpath(female));
		return element;
	}
	
	public WebElement male() {
		WebElement element = driver.findElement(By.xpath(male));
		return element;
	}
	
	public WebElement createMyAcct() {
		WebElement element = driver.findElement(By.id(createMyAcct));
		return element;
	}

}
