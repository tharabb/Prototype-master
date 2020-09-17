package test_mealConfig;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.excel.utilities.ExcelReader;
import com.numi.journal.pages.JournalPg_meals;
import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

public class PT2_Men_Morethan100lbs_noBloodSugar extends baseClass {
	keywordFunctions kf = new keywordFunctions();
	journalPage jp = new journalPage();
	JournalPg_meals jpMeals = new JournalPg_meals();
	ExcelReader excel = new ExcelReader(
			"C:\\Users\\tkannan\\eclipse-workspace\\Prototype-master\\src\\main\\java\\com\\numi\\config\\mealPlanConfig.xlsx");
	signInPage signInPg;

	public PT2_Men_Morethan100lbs_noBloodSugar() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
		kf.getUrl("url");

	}

	@Test(priority = 100)
	public void loginPage() {
		jp = signInPg.signIn(excel.getCellData("PT2-Men", "userName", 2), excel.getCellData("PT2-Men", "pwd", 2));
		System.out.println("Landed in JournalPage: " + jp.verify_journalPg_Heading());
	}

	@Test(priority = 101)
	public void PT2_Men_breakfast() {
		// Get the number of items in breakfast
		List<WebElement> meal1 = jpMeals.breakfast();

		for (int i = 0; i < meal1.size(); i++) {
			if (meal1.get(i).getText().equalsIgnoreCase("Nutrisystem Entree")) {
				System.out.println("Breakfast meal: " + meal1.get(i).getText());
				// Actual item count
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getBkfast_entree_xpath(), "NS-Entree");
				// Expected item count
				String valueFromExcel = (excel.getCellData("PT2-Men", "Bf-NS-Entree", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during Bf-NS-Entree check");
				}
			} else if (meal1.get(i).getText().equalsIgnoreCase("PowerFuel")) {
				System.out.println("Breakfast meal: " + meal1.get(i).getText());
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getBkfast_PF_xpath(), "PowerFuel");
				String valueFromExcel = (excel.getCellData("PT2-Men", "Bf-PF", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during Bf-PowerFuel check");
				}
			} else {
				System.out.println("PowerFuel OR Nutrisystem Entree name is NOT matching");
			}
		}
		System.out.println("--------------------------------------------------");
	}

	@Test (priority= 102)
	public void PT2_Men_amSnack() {
		//Get the list of meals in AM snack
		List<WebElement> meal2 = jpMeals.amSnack();
		
		for (int i = 0; i < meal2.size(); i++) {
			if (meal2.get(i).getText().equalsIgnoreCase("PowerFuel")) {
				System.out.println("AM snack meal: " + meal2.get(i).getText());
				// Actual item count
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getAmSnack_PF_xpath(), "PowerFuel");
				// Expected item count
				String valueFromExcel = (excel.getCellData("PT2-Men", "AmSnk-PF", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during AmSnk-PF check");
				}
			} else if (meal2.get(i).getText().equalsIgnoreCase("SmartCarb")) {
				System.out.println("Breakfast meal: " + meal2.get(i).getText());
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getAmSnack_SC_xpath(), "SmartCarb");
				String valueFromExcel = (excel.getCellData("PT2-Men", "AmSnk-SC", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during AmSnk-SC check");
				}
			} else {
				System.out.println("PowerFuel OR SmartCarb name is NOT matching");
			}
		}
		System.out.println("--------------------------------------------------");
	}


	@Test (priority= 103)
	public void PT2_Men_Lunch() {
		//Get the list of meals in Lunch
		List<WebElement> meal2 = jpMeals.amSnack();
		
		for (int i = 0; i < meal2.size(); i++) {
			if (meal2.get(i).getText().equalsIgnoreCase("PowerFuel")) {
				System.out.println("AM snack meal: " + meal2.get(i).getText());
				// Actual item count
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getAmSnack_PF_xpath(), "PowerFuel");
				// Expected item count
				String valueFromExcel = (excel.getCellData("PT2-Men", "AmSnk-PF", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during AmSnk-PF check");
				}
			} else if (meal2.get(i).getText().equalsIgnoreCase("SmartCarb")) {
				System.out.println("Breakfast meal: " + meal2.get(i).getText());
				int actual_Count = jpMeals.actual_itemCount(jpMeals.getAmSnack_SC_xpath(), "SmartCarb");
				String valueFromExcel = (excel.getCellData("PT2-Men", "AmSnk-SC", 2));
				try {
					int expected_Count = Integer.parseInt(valueFromExcel);
					System.out.println("Expected item count is: " + expected_Count);
					Assert.assertEquals(actual_Count, expected_Count);
				} catch (NumberFormatException nfe) {
					Assert.fail("NumberFormatException during AmSnk-SC check");
				}
			} else {
				System.out.println("PowerFuel OR SmartCarb name is NOT matching");
			}
		}
		System.out.println("--------------------------------------------------");
	}

	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
