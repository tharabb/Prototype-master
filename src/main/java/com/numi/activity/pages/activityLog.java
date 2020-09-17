package com.numi.activity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class activityLog extends baseClass {
	private String pageHeading_xpath = "//h1[@id='header_activity']";
	private String distance_xpath = "//input[@type='text' and @id='activity_distance']";
	private String speed_xpath = "//input[@id='activity_speed']";
	private String duration_xpath = "//input[@type='text' and @id='activity_dur']";
	private String logItBttn_xpath = "//button[@class='undefined avtivity_log_it_btn log_it_text']";

	// Update and Ren=move button xpath
	private String upDateBttn_xpath = "//button[@class='undefined create_food_update_text']";
	private String removeBttn_xpath = "//button[@class='undefined remove_text']";

	public WebElement getPageHeading() {
		WebElement element = driver.findElement(By.xpath(pageHeading_xpath));
		return element;
	}

	public WebElement getDistanceInputBox() {
		WebElement element = driver.findElement(By.xpath(distance_xpath));
		return element;
	}

	public WebElement getSpeedInputBox() {
		WebElement element = driver.findElement(By.xpath(speed_xpath));
		return element;
	}

	public WebElement getDurationInputBox() {
		WebElement element = driver.findElement(By.xpath(duration_xpath));
		return element;
	}

	public WebElement getLogItBttn() {
		WebElement element = driver.findElement(By.xpath(logItBttn_xpath));
		return element;
	}

	public WebElement getUpdateBttn() {
		WebElement element = driver.findElement(By.xpath(upDateBttn_xpath));
		return element;
	}

	public WebElement getRemoveBttn() {
		WebElement element = driver.findElement(By.xpath(removeBttn_xpath));
		return element;
	}
}
