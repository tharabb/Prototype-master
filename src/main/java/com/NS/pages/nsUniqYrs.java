package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsUniqYrs extends baseClass {

	private String womenSelected = "//button[@class='btn-interstitial text-futura selected'and@value='women']";
	private String menSelected = "//button[@class='btn-interstitial text-futura selected'and@value='men']";
	private String checkPPcheckBox = "personal";
	private String personalBttn = "personalizeBtn";

	public WebElement getWomenBttn() {
		WebElement element = driver.findElement(By.xpath(womenSelected));
		return element;
	}

	public WebElement getMenBttn() {
		WebElement element = driver.findElement(By.xpath(menSelected));
		return element;
	}

	public WebElement getPPcheckBox() {
		WebElement element = driver.findElement(By.id(checkPPcheckBox));
		return element;
	}
	
	public WebElement getPersonalBttn() {
		WebElement element = driver.findElement(By.id(personalBttn));
		return element;
	}

}
