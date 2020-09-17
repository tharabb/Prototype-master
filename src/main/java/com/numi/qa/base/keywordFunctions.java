package com.numi.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class keywordFunctions extends baseClass {

	public void getUrl(String url) {
		driver.get(prop.getProperty(url));
	}

	public void click(WebElement elemnt, String elementName) {
		w.until(ExpectedConditions.visibilityOf(elemnt));
		if (elemnt.isDisplayed()) {
			elemnt.click();
			System.out.println("The element " + elementName + " is clicked successfully");
		} else
			System.out.println("The click method on " + elementName + " is unsuccessful");
	}

	public void waitForVisibility(WebElement element) {
		w.until(ExpectedConditions.visibilityOf(element));
		if(element.isDisplayed()) {
			System.out.println(element+" is displayed.");
		}else System.out.println(element+" is not displayed.");
	}

	public void verifyPageHeading(WebElement element1) {
		w.until(ExpectedConditions.visibilityOf(element1));
		if (element1.isDisplayed()) {
			String ActualHeadingText = element1.getText();
			System.out.println("PageHeading " + ActualHeadingText + " is displayed.");
		} else
			System.out.println("PageHeading is NOT displayed.");

	}
	
	public void verifyCurrentUrl (String urltext) {
		String actualCurrentURL = driver.getCurrentUrl();
		System.out.println(actualCurrentURL);
		if(actualCurrentURL.contains(urltext)) {
			System.out.println("Current url is: "+actualCurrentURL);
		}else System.out.println("Not navigated to expected page!!");
	}

	public void takeScreenShotOnTestFail() {
		System.out.println("Test is failed");
		File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(outputFile, new File("\\eclipse-workspace\\Prototype\\ScreenShots\\ScreenShots.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeSession() {
		driver.quit();
	}
}
