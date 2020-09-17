package test_onboarding;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.newSignUpPage;
import com.numi.onboarding.pages.setUpAcctPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;

/*----------------------------------------------------
 * Scenario: Login as NutriSystem user
 * Verification: User is able to land in Journal Page
------------------------------------------------------*/


public class Onb_using_NSacct extends baseClass {
	signInPage signInPg;
	newSignUpPage newSignUpPg;
	setUpAcctPage setUpAcctPg;
	journalPage journalPg;

	public Onb_using_NSacct() {
		super();
	}
	
	@Parameters({"URL"})
	@BeforeClass
	public void onboardingUpto_setUpacctPg(String URL) {
		initialization();
		signInPg = new signInPage();
		driver.get(URL);
		waitForPageLoad(js);

	}

	@Test
	public void useYrNsAccount() {
		newSignUpPg = signInPg.signUpForNumiClick(); // returns new signup page
		journalPg = newSignUpPg.UseYourNutriAcctBttnClick();
		Assert.assertTrue(journalPg.verify_journalPg_Heading(), "Journal page title is incorrect");
		journalPg.checkProfileNameDisplay();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}
