package test_journal;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;

public class J_appTutorial extends baseClass {

	signInPage signInPg;
	journalPage jp = new journalPage();
	 

	public J_appTutorial() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
		driver.get(prop.getProperty("url"));
		waitForPageLoad(js);
	}

	@Test(priority = 1)
	public void signIn() {
		jp = signInPg.signIn(prop.getProperty("fn"), prop.getProperty("pwd"));
		
		Assert.assertTrue(jp.verify_journalPg_Heading(), "Journal page title is incorrect");
	}

		
	@Test (priority =2)
	
	public void clickonHelp() {
		jp.getJournalHelp().click();
	
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}