package com.NS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.qa.base.baseClass;

public class nsPPquestionaire extends baseClass {

	private String quesPgHeading = "//h1[@class='text-center fw-700']";
	private String weightInputBox = "weight";
	private String heightFeetInpBox = "height";
	private String heightInchInpBox = "inches";
	private String bDayInputBox = "bDay";
	// Weight to loss
	private String lessthan15 = "less-15lbs";
	private String loss15To20Lbs = "15-20lbs";
	private String loss21To30lbs = "21-30lbs";
	private String loss31To40lbs = "31-40lbs";
	private String loss41To50lbs = "41-50lbs";
	private String loss50plus = "50-plus";
	// BodyType
	private String apple = "//button[@id='bodyType1'and@data-name='Apple']";
	private String pear = "//button[@id='bodyType2'and@data-name='Pear']";
	private String rectangle = "//button[@id='bodyType4'and@data-name='Rectangle']";
	private String hourGlass = "//button[@id='bodyType3'and@data-name='Hourglass']";
	// dietery needs
	private String dietNeither = "//button[@id='neither']";
	// Activity
	private String actSedentary = "//button[@data-name='Sedentary']";
	private String lightActivity = "//button[@data-name='Light Activity']";
	private String active = "//button[@data-name='Active']";
	private String veryActive = "//button[@data-name='Very Active']";

	// Exercise
	private String littleToNone = "//button[@data-name='LittleToNone']";
	private String light = "//button[@data-name='Light']";
	private String moderate = "//button[@data-name='Moderate']";
	private String intense = "//button[@data-name='Intense']";
	private String extreme = "//button[@data-name='Extreme']";

	// Best describes you
	private String describesYou1 = "//button[@id='describesYou1']";

	// Protein shakes
	private String proteinShakes2 = "//button[@id='proteinShakes2']";
	
	//Button 
	private String reviewPlan="//button[@id='reviewPlan']";

	//Review page heading
	private String reviewText = "//li[@class='text-center active'and text()=' Review']";
	
	public WebElement getquesPgHeading() {
		WebElement element = driver.findElement(By.xpath(quesPgHeading));
		return element;
	}

	public WebElement getWeightInputBox() {
		WebElement element = driver.findElement(By.id(weightInputBox));
		return element;
	}

	public WebElement getHeightFeetInpBox() {
		WebElement element = driver.findElement(By.id(heightFeetInpBox));
		return element;
	}

	public WebElement getHeightInchInpBox() {
		WebElement element = driver.findElement(By.id(heightInchInpBox));
		return element;
	}

	public WebElement getBdayInpBox() {
		WebElement element = driver.findElement(By.id(bDayInputBox));
		return element;
	}

	public WebElement getLessthan15() {
		WebElement element = driver.findElement(By.id(lessthan15));
		return element;
	}

	public WebElement getLoss15To20Lbs() {
		WebElement element = driver.findElement(By.id(loss15To20Lbs));
		return element;
	}

	public WebElement getLoss21To30lbs() {
		WebElement element = driver.findElement(By.id(loss21To30lbs));
		return element;
	}

	public WebElement getLoss31To40lbs() {
		WebElement element = driver.findElement(By.id(loss31To40lbs));
		return element;
	}

	public WebElement getLoss41To50lbs() {
		WebElement element = driver.findElement(By.id(loss41To50lbs));
		return element;
	}

	public WebElement getLoss50plus() {
		WebElement element = driver.findElement(By.id(loss50plus));
		return element;
	}

	public WebElement getApple() {
		WebElement element = driver.findElement(By.xpath(apple));
		return element;
	}

	public WebElement getPear() {
		WebElement element = driver.findElement(By.xpath(pear));
		return element;
	}

	public WebElement getRectangle() {
		WebElement element = driver.findElement(By.xpath(rectangle));
		return element;
	}

	public WebElement getHourGlass() {
		WebElement element = driver.findElement(By.xpath(hourGlass));
		return element;
	}

	public WebElement getNeither() {
		WebElement element = driver.findElement(By.xpath(dietNeither));
		return element;
	}

	public WebElement getActSedentary() {
		WebElement element = driver.findElement(By.xpath(actSedentary));
		return element;
	}

	public WebElement getLightActivity() {
		WebElement element = driver.findElement(By.xpath(lightActivity));
		return element;
	}

	public WebElement getActive() {
		WebElement element = driver.findElement(By.xpath(active));
		return element;
	}

	public WebElement getVeryActive() {
		WebElement element = driver.findElement(By.xpath(veryActive));
		return element;
	}

	public WebElement getLittleToNone() {
		WebElement element = driver.findElement(By.xpath(littleToNone));
		return element;
	}

	public WebElement getLight() {
		WebElement element = driver.findElement(By.xpath(light));
		return element;
	}

	public WebElement getModerate() {
		WebElement element = driver.findElement(By.xpath(moderate));
		return element;
	}

	public WebElement getIntense() {
		WebElement element = driver.findElement(By.xpath(intense));
		return element;
	}

	public WebElement getExtreme() {
		WebElement element = driver.findElement(By.xpath(extreme));
		return element;
	}

	public WebElement getDescribesYou1() {
		WebElement element = driver.findElement(By.xpath(describesYou1));
		return element;
	}

	public WebElement getProteinShakes2() {
		WebElement element = driver.findElement(By.xpath(proteinShakes2));
		return element;
	}
	
	
	public WebElement getGetMyPlanBttn() {
		WebElement element = driver.findElement(By.xpath(reviewPlan));
		return element;
	}
	
	public WebElement getReviewText() {
		WebElement element = driver.findElement(By.xpath(reviewText));
		return element;
	}
}
