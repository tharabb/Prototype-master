package test_activity;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.activity.pages.activityLog;
import com.numi.activity.pages.logActivity;
import com.numi.journal.pages.journalPage;
import com.numi.journal.pages.journalPg_Activity;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

/* Test Scenario: Log Activity Via Plus Sign
Steps: 1. Click on small plus sign icon << Navigate to Log Activity page. 
2. Select Walk activity << Navigate to Activity Detail page
3. Click on save button << Navigate to Journal page and verify logged activity details. E.g. min and name */

public class Act_logViaPlusSign extends baseClass {
	signInPage signInPg;
	journalPage jp = new journalPage();
	keywordFunctions kf = new keywordFunctions();
	journalPg_Activity jpAct = new journalPg_Activity();
	logActivity logAct = new logActivity();
	activityLog actLog = new activityLog();

	public Act_logViaPlusSign() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
		driver.get(prop.getProperty("url"));
		waitForPageLoad(js);
		jp = signInPg.signIn(prop.getProperty("fn2"), prop.getProperty("pwd2"));
		Assert.assertEquals(jp.actualProfileNameDisplay(), prop.getProperty("profileName2"));
	}

	@Test(priority = 510)
	public void LogActivityViaPlusSign() {
		kf.click(jpAct.getAddActivityPlusSign(), "AddActivityPlusSign");
		kf.verifyPageHeading(logAct.getlogActivityHeading());
		kf.click(logAct.getWalkingImage(), "WalkingImage");
		// Verify clicking on walk navigates to activity page - Verify the heading is
		// WALK
		kf.verifyPageHeading(actLog.getPageHeading());
		if (actLog.getDistanceInputBox().isDisplayed()) {
			actLog.getDistanceInputBox().clear();
			actLog.getDistanceInputBox().sendKeys("2");
		} else
			System.out.println("Distance Input box is not displayed!!");
		if (actLog.getDurationInputBox().isDisplayed()) {
			actLog.getDurationInputBox().clear();
			actLog.getDurationInputBox().sendKeys("30");
		} else
			System.out.println("Duration Input box is not displayed");
		kf.click(actLog.getLogItBttn(), "LogItBttn");
		kf.verifyPageHeading(jp.getJournalPg_Heading());

		// verify if the logged activity icon is appearing in Activities section
		if (jpAct.getactiveLogActivityBttn().isDisplayed()) {
			System.out.println("Logged activity icon is displayed as expected");
		} else
			System.out.println("Logged activity icon is not displayed!!");
		// Get text
		System.out.println("Text appeared in activity line 2 is : " + jpAct.ActivityText2().getText());
		System.out.println("Text appeared in activity line 3 is : " + jpAct.ActivityText3().getText());
	}

	@Test(priority = 511)
	public void updateLoggedActivity() {
		kf.click(jpAct.getcaretIcon(), "caretIcon");
		kf.verifyCurrentUrl("edit_calculated_activity");
		kf.verifyPageHeading(actLog.getPageHeading());
		if (actLog.getDistanceInputBox().isDisplayed()) {
			actLog.getDistanceInputBox().clear();
			actLog.getDistanceInputBox().sendKeys("2.5");
		} else
			System.out.println("Distance Input box is not displayed!!");
		if (actLog.getDurationInputBox().isDisplayed()) {
			actLog.getDurationInputBox().clear();
			actLog.getDurationInputBox().sendKeys("60");
		} else
			System.out.println("Duration Input box is not displayed");
		kf.click(actLog.getUpdateBttn(), "UpdateBttn");
		kf.verifyCurrentUrl("journal");

		System.out.println("Text appeared in activity line 2 is : " + jpAct.ActivityText2().getText());
		System.out.println("Text appeared in activity line 3 is : " + jpAct.ActivityText3().getText());
	}

	@Test(priority = 512)
	public void unLogActivity() {
		// Un-log the activity to run the test case again
		kf.click(jpAct.getactiveLogActivityBttn(), "activeLogActivityBttn");
		kf.click(jpAct.getunlogYes(), "Unlog_YES");
		Assert.assertEquals(jpAct.getemptyLogActivityBttn().isDisplayed(), true,
				"Empty log activity icon is not displayed");
	}

	@AfterClass
	public void tearDown() {
		kf.closeSession();

	}
}
