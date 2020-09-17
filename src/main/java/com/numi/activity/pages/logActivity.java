package com.numi.activity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class logActivity extends baseClass {

	private String logActivityHeading_xpath = "//h1[@id='header_change']";
	private String runningImage_xpath= "//p[@class='numi_running']";
	private String walkingImage_xpath= "//p[@class='numi_walking']";
	

	public WebElement getlogActivityHeading() {
		WebElement element = driver.findElement(By.xpath(logActivityHeading_xpath));
		return element;
	}
	 
	public WebElement getrunningImage() {
		WebElement element = driver.findElement(By.xpath(runningImage_xpath));
		return element;
	}
	
	public WebElement getWalkingImage() {
		WebElement element = driver.findElement(By.xpath(walkingImage_xpath));
		return element;
	}
	
}