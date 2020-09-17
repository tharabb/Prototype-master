package test_activity;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.journal.pages.journalPg_Activity;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

public class Act_quickLogAct extends baseClass {

	signInPage signInPg;
	journalPage jp = new journalPage();
	keywordFunctions kf = new keywordFunctions();
	journalPg_Activity jpAct = new journalPg_Activity();

	public Act_quickLogAct() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
		driver.get(prop.getProperty("url"));
		waitForPageLoad(js);
	}

	@Test(priority = 500)
	public void signIn() {
		jp = signInPg.signIn(prop.getProperty("fn2"), prop.getProperty("pwd2"));
		Assert.assertEquals(jp.actualProfileNameDisplay(), prop.getProperty("profileName2"));
	}

	@Test(priority = 501)
	public void Verify_log_quickLog() {
		// Verify empty log activity button is available
		kf.click(jpAct.getemptyLogActivityBttn(), "emptyLogActivityBttn");

		// Verify modal window is appearing when clicking on EmptyLogActivity button
		jpAct.getmodalInput().sendKeys("10");
		kf.click(jpAct.getmodalSaveBttn(), "modalSaveBttn");

		// Verify the activity is logged
		Assert.assertEquals(jpAct.getactiveLogActivityBttn().isDisplayed(), true,
				"Active Log Activity Bttn is not found!!");

		// Verify Activity text
		String actualText1 = jpAct.ActivityText1().getText();
		String actualText2 = jpAct.ActivityText2().getText();
		String actualText3 = jpAct.ActivityText3().getText();

		System.out.println(actualText1);
		Assert.assertEquals(actualText1, "QuickLogged");
		System.out.println(actualText2);
		Assert.assertEquals(actualText2, "Unspecified");
		System.out.println(actualText3);
		Assert.assertEquals(actualText3, "10 mins");

	}

	@Test(priority = 502)
	public void Verify_unLog_quickLog() {
		// Verify unlog
		kf.click(jpAct.getactiveLogActivityBttn(), "activeLogActivityBttn");

		// kf.waitForVisibility(jpAct.getemptyLogActivityBttn());
		Assert.assertEquals(jpAct.getemptyLogActivityBttn().isDisplayed(), true,
				"Empty Log activity bttn is not displayed");
	}

	@AfterClass
	public void tearDown() {
		kf.closeSession();
	}

}
