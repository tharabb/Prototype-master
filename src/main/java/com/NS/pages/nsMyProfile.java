package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsMyProfile extends baseClass{
	
	private String myProfileHeading = "//strong[text()='My Profile']";
	private String shopPlans= "//span[text()='Shop Plans']";
	private String howItWorks = "//span[text()='How It Works']";
	private String viewMenu = "//span[text()='View Menu']";
	private String successStories = "//span[text()='Success Stories']";
	
	public WebElement getMyProfileHeading() {
		WebElement element = driver.findElement(By.xpath(myProfileHeading));
		return element;
	} 
	public WebElement getShopPlans() {
		WebElement element = driver.findElement(By.xpath(shopPlans));
		return element;
	}
	
	public WebElement getHowItWorks() {
		WebElement element = driver.findElement(By.xpath(howItWorks));
		return element;
	}
	
	public WebElement getViewMenu() {
		WebElement element = driver.findElement(By.xpath(viewMenu));
		return element;
	}
	
	public WebElement getSuccessStories() {
		WebElement element = driver.findElement(By.xpath(successStories));
		return element;
	}

}
