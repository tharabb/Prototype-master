package com.NS.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsWeightLossPgm extends baseClass {
	private String title = "//strong[text()='Choose Your 4-Week Plan']";
	private String basicpln = "//li[@id='basic-plan']";
	private String uniQYrs = "//li[@id='select-plan']//a[text()='Uniquely Yours']";
	private String plansList = "//ul[@class='nav']//li//a";
	
	
	
	public WebElement getPageTitle() {
		WebElement element = driver.findElement(By.id(title));
		return element;
		
	}
	
	public WebElement getUniqYrsPlan() {
		WebElement element = driver.findElement(By.xpath(uniQYrs));
		return element;
		
	}
	
	public void selectPlan (String planName) {
		List<WebElement> plans= driver.findElements(By.xpath(plansList));
		for (int i =0; i<plans.size(); i++ ) {
				if(plans.get(i).getText().equals(planName)) {
				System.out.println("Plan Selected: "+plans.get(i).getText());
				plans.get(i).click();
					
			}else System.out.println("Plan name mentioned is incorrect!!");
		}
	}
	
	
}