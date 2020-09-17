package com.numi.onboarding.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class tellUsprofilePage extends baseClass {
	@FindBy(xpath = "//h3[contains(text(),'Tell us about yourself')]")
	private WebElement tellUsProfPg_heading;

	@FindBy(xpath = "//select[@id='month_drop']")
	private WebElement DOBMonth;

	@FindBy(xpath = "//select[@id='month_drop']//option[@value='1']")
	private WebElement January;

	@FindBy(xpath = "//select[@id='pick_date']")
	private WebElement DOBDay;

	@FindBy(xpath = "//select[@id='pick_date']//option[@value='2']")
	private WebElement DOBDay2;

	@FindBy(xpath = "//select[@id='Year_drop']")
	private WebElement DOBYear;

	@FindBy(xpath = "//select[@id='Year_drop']//option[@value='50']")
	private WebElement DOBYear50;

	@FindBy(xpath = "//input[@id='height_feet']")
	private WebElement hghtFeet;

	@FindBy(xpath = "//input[@id='height_inch']")
	private WebElement hghtInch;

	@FindBy(xpath = "//input[@id='current_weight']")
	private WebElement crntWeight;

	@FindBy(xpath = "//input[@id='goal_weight']")
	private WebElement goalWeight;

	@FindBy(xpath = "//div[@class='react-datepicker__input-container']")
	private WebElement startDate;

	@FindBy(xpath = "//div[@class='react-datepicker__month-container']")
	private WebElement monthCalendar;

	@FindBy(xpath = "//div[contains(@aria-label, 'Choose')]")
	private WebElement validDates;

	@FindBy(xpath = "//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")
	private WebElement prevsMonthBttn;

	@FindBy(xpath = "//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")
	private WebElement nextMonthBttn;

	@FindBy(xpath = "//input[@id='start_weight']")
	private WebElement startWeight;

	@FindBy(xpath = "//input[@class='submit_btn continue_text']")
	private WebElement continueBttn;

	@FindBy(xpath = "//input[@class='submit_btn continue_text btn disabled']")
	private WebElement continueDisable;

	public tellUsprofilePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verify_tellUsAboutPageHeading() {
		return (tellUsProfPg_heading.isDisplayed());
	}

	public void startDate_backdated() {
		startDate.click();
		System.out.println("Start button is clicked");
		w.until(ExpectedConditions.visibilityOf(monthCalendar));
		if (monthCalendar.isDisplayed()) {
			System.out.println("Month calendar is displayed");
		}else {
			System.out.println("Month calendar is not displayed");
		}
		
		
		//Temporary fix, But we should find why isDisplayed is not working
		boolean isprevsMonthBttnExist = false;
		try {
			isprevsMonthBttnExist = prevsMonthBttn.isDisplayed();
		}catch(NoSuchElementException nsee) {
			isprevsMonthBttnExist = false;
		}

		if (monthCalendar.isDisplayed() && isprevsMonthBttnExist) {
			prevsMonthBttn.click();
			validDates.click();
			System.out.println("Calendar is open and first valid date in previous month is clicked");
		} else {
			validDates.click();
			System.out.println("First valid date in the current month is clicked");// click on valid date
		}
	}

	public void startDate_futuredated() {
		startDate.click();
		w.until(ExpectedConditions.visibilityOf(monthCalendar));
		if (monthCalendar.isDisplayed()) {
			System.out.println("Calendar is open");
			nextMonthBttn.click();
			System.out.println("nextMonthBttn in clicked");
		} else
			System.out.println("Calendar is not available");
		validDates.click(); // click on valid date
	}

	public chooseNSPlan tellUsProfPage_LessThan100_backdated() {
		DOBMonth.click();
		January.click();
		DOBDay.click();
		DOBDay2.click();
		DOBYear.click();
		DOBYear50.click();
		hghtFeet.sendKeys(prop.getProperty("hghtFeet"));
		hghtInch.sendKeys(prop.getProperty("hghtInch"));
		crntWeight.sendKeys(prop.getProperty("crtWght"));
		goalWeight.sendKeys(prop.getProperty("lessThan100goalWght"));
		startDate_backdated();
		startWeight.sendKeys(prop.getProperty("strtWght"));
		continueBttn.click();
		return new chooseNSPlan();

	}

	public chooseNSPlan tellUsProfPage_MoreThan100() {
		DOBMonth.click();
		January.click();
		DOBDay.click();
		DOBDay2.click();
		DOBYear.click();
		DOBYear50.click();
		hghtFeet.sendKeys(prop.getProperty("hghtFeet"));
		hghtInch.sendKeys(prop.getProperty("hghtInch"));
		crntWeight.sendKeys(prop.getProperty("crtWght"));
		goalWeight.sendKeys(prop.getProperty("moreThan100goalWght"));
		continueBttn.click();
		return new chooseNSPlan();

	}

	public chooseNSPlan tellUsProfPage_MoreThan100_futureDated() {
		DOBMonth.click();
		January.click();
		DOBDay.click();
		DOBDay2.click();
		DOBYear.click();
		DOBYear50.click();
		hghtFeet.sendKeys(prop.getProperty("hghtFeet"));
		hghtInch.sendKeys(prop.getProperty("hghtInch"));
		crntWeight.sendKeys(prop.getProperty("crtWght"));
		goalWeight.sendKeys(prop.getProperty("moreThan100goalWght"));
		startDate_futuredated();
		w.until(ExpectedConditions.elementToBeClickable(continueBttn));
		if (continueBttn.isDisplayed()) {
			continueBttn.click();
			System.out.println("Tell us profile page: continue button is clicked!!");
		} else
			System.out.println("Tell us profile page: continue button is not clicked!!");

		return new chooseNSPlan();

	}

}
