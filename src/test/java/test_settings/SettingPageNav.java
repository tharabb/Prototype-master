package test_settings;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.settings.pages.Settings;

public class SettingPageNav extends baseClass {
	
	signInPage signInPg;
	journalPage jp = new journalPage();
	Settings set = new Settings();
	 

	public SettingPageNav() {
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
	public void signIn() throws Throwable {
		jp = signInPg.signIn(prop.getProperty("fn"), prop.getProperty("pwd"));
		Assert.assertTrue(jp.verify_journalPg_Heading(), "Journal page title is incorrect");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void clickOnSettingsBttn() {
		set.clickOnSettings();
			}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
