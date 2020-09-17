package com.numi.journal.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.numi.excel.utilities.ExcelReader;
import com.numi.qa.base.baseClass;


/* Page Object without Page factory  */


public class JournalPg_meals extends baseClass {

//	public static Properties pt1_Prop;
	ExcelReader excel = new ExcelReader(
			"C:\\Users\\tkannan\\eclipse-workspace\\Prototype-master\\src\\main\\java\\com\\numi\\config\\mealPlanConfig.xlsx");

	// BREAKFAST
	private String meal1_xpath = "//div[@id='meal1']//div[@meal_occasion_name='BREAKFAST']";
	private String bkfast_entree_xpath = "//div[@id='meal1']//div[@food_categories='NS_ENTREE']";
	private String bkfast_PF_xpath = "//div[@id='meal1']//div[@food_categories='POWERFUEL']";
	private String bkfast_SC_xpath = "//div[@id='meal1']//div[@food_categories='SMARTCARB']";

	// AM SNACK
	private String meal2_xpath = "//div[@id='meal2']//div[@meal_occasion_name='BREAKFAST_SNACK']";
	private String amSnack_PF_xpath = "//div[@id='meal2']//div[@food_categories='POWERFUEL']";
	private String amSnack_SC_xpath = "//div[@id='meal2']//div[@food_categories='SMARTCARB']";

	// LUNCH
	private String meal3_xpath = "//div[@id='meal3']//div[@meal_occasion_name='LUNCH']";
	private String lunch_entree_xpath = "//div[@id='meal3']//div[@food_categories='NS_ENTREE']";
	private String lunch_PF_xpath = "//div[@id='meal3']//div[@food_categories='POWERFUEL']";

	// NOON SNACK
	private String meal4_xpath = "//div[@id='meal4']//div[@food_categories='NS_SNACK']";

	// DINNER
	private String meal5_xpath = "//div[@id='meal5']//div[@food_categories='NS_ENTREE']";
	private String dinner_SC_xpath = "//div[@id='meal5']//div[@food_categories='SMARTCARB']";

	public List<WebElement> breakfast() {
		List<WebElement> meal1 = driver.findElements(By.xpath(meal1_xpath));
		System.out.println("Number of meals in breakfast is: " + meal1.size());
		System.out.println("--------------------------------------------------");
		return meal1;
	}

	public List<WebElement> amSnack() {
		List<WebElement> meal2 = driver.findElements(By.xpath(meal2_xpath));
		System.out.println("Number of meals in amSnack is: " + meal2.size());
		System.out.println("--------------------------------------------------");
		return meal2;
	}

	public List<WebElement> lunch() {
		List<WebElement> meal3 = driver.findElements(By.xpath(meal3_xpath));
		System.out.println("Number of meals in lunch is: " + meal3.size());
		System.out.println("--------------------------------------------------");
		return meal3;
	}

	public List<WebElement> noonSnack() {
		List<WebElement> meal4 = driver.findElements(By.xpath(meal4_xpath));
		System.out.println("Number of meals in lunch is: " + meal4.size());
		System.out.println("--------------------------------------------------");
		return meal4;
	}

	public List<WebElement> dinner() {
		List<WebElement> meal5 = driver.findElements(By.xpath(meal5_xpath));
		System.out.println("Number of meals in lunch is: " + meal5.size());
		System.out.println("--------------------------------------------------");
		return meal5;
	}

	public int actual_itemCount(String xpathValues, String foodName) {
		List<WebElement> mealName1 = driver.findElements(By.xpath(xpathValues));
		int actual_item_Count = mealName1.size();
		System.out.println("Actual count of " + foodName + " is: " + actual_item_Count);
		return actual_item_Count;

	}

	public String getBkfast_entree_xpath() {
		return bkfast_entree_xpath;
	}

	public String getBkfast_PF_xpath() {
		return bkfast_PF_xpath;
	}

	public String getBkfast_SC_xpath() {
		return bkfast_SC_xpath;
	}

	public String getAmSnack_PF_xpath() {
		return amSnack_PF_xpath;
	}

	public String getAmSnack_SC_xpath() {
		return amSnack_SC_xpath;
	}

	public String getMeal3_xpath() {
		return meal3_xpath;
	}

	public String getLunch_entree_xpath() {
		return lunch_entree_xpath;
	}

	public String getLunch_PF_xpath() {
		return lunch_PF_xpath;
	}

	public String getMeal4_xpath() {
		return meal4_xpath;
	}

	public String getDinner_entree_xpath() {
		return meal5_xpath;
	}

	public String getDinner_SC_xpath() {
		return dinner_SC_xpath;
	}

//	public int expected_itemCount(String valueFromPropFile, String foodName) {
//		// converting string from property to Integer
//		String valueFromProperty = (pt1_Prop.getProperty(valueFromPropFile));
//		int expected_item_Count = Integer.parseInt(valueFromProperty);
//		System.out.println("Expected count of " + foodName + " is: " + expected_item_Count);
//		return expected_item_Count;
//
//	}

}
