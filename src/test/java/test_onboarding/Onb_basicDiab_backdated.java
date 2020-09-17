package test_onboarding;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.acctDetailsPage;
import com.numi.onboarding.pages.allSetPage;
import com.numi.onboarding.pages.chooseNSPlan;
import com.numi.onboarding.pages.chooseNsPlanListPage;
import com.numi.onboarding.pages.connectDevicePage;
import com.numi.onboarding.pages.firstWeekStagePage;
import com.numi.onboarding.pages.lowBloodSugarPage;
import com.numi.onboarding.pages.newSignUpPage;
import com.numi.onboarding.pages.setUpAcctPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.onboarding.pages.stayOnTrackEMailNotifyPage;
import com.numi.onboarding.pages.tellUsprofilePage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

/*----------------------------------------------------
 * Scenario: SignUp for NUMI <<Create a new NUMI account
 * Plan Details: Male<< Basic Diabetes Plan << less than 100 pounds to lose<< Backdated 
 * Verification: 1) User is able to complete on-boarding and land in Journal Page
------------------------------------------------------*/

public class Onb_basicDiab_backdated extends baseClass {
	keywordFunctions kfPg;
	signInPage signInPg;
	newSignUpPage newSignUpPg;
	setUpAcctPage setUpAcctPg;
	acctDetailsPage acctDetailsPg;
	tellUsprofilePage tellUsprofilePg;
	chooseNSPlan chooseNsPln;
	chooseNsPlanListPage chooseNsPlanListPg;
	firstWeekStagePage firstWeekStagePg;
	lowBloodSugarPage lowBloodSugarPg;
	stayOnTrackEMailNotifyPage stayOnTrackEMailNotifyPg;
	connectDevicePage connectDevicePg;
	allSetPage allSetPg;
	journalPage journalPg;

	
	public Onb_basicDiab_backdated() {
		super();
	}
	@Parameters({"URL"})
	@BeforeMethod
	public void onboardingUpto_setUpacctPg(String URL) {
		initialization();
		signInPg = new signInPage();
		driver.get(URL);
		waitForPageLoad(js);
		
		
	}
	
	@Test 
	public void lessThanHundredWtLoss_DBplan_backdated() {
		newSignUpPg = signInPg.signUpForNumiClick(); // returns new signup page
		setUpAcctPg = newSignUpPg.createNewNumiAcctBttnClick(); // returns setup account page
		acctDetailsPg = setUpAcctPg.setUpNewUserAcct();
		tellUsprofilePg = acctDetailsPg.setUpaccntDetailsPage();
		chooseNsPln = tellUsprofilePg.tellUsProfPage_LessThan100_backdated();
		chooseNsPlanListPg = chooseNsPln.choosePlanButton();
		//Since the goal weights less than 100, thus Email notification page appears.
		stayOnTrackEMailNotifyPg= chooseNsPlanListPg.chooseDBPlan_lessthan100(chooseNsPlanListPg.getBasicDB());	
		Assert.assertTrue(stayOnTrackEMailNotifyPg.verify_stayOnTrackEMailNotifyPg_Heading(), "Email page title is incorrect");
		connectDevicePg = stayOnTrackEMailNotifyPg.yesEmailNotify();
		Assert.assertTrue(connectDevicePg.verify_connectDevicePg_Heading(), "Connect device page title is incorrect");
		allSetPg = connectDevicePg.connectDeviceNotNow();
		journalPg = allSetPg.noTourNow();
		System.out.println("==================================================================================");
		Assert.assertTrue(journalPg.verify_journalPg_Heading(), "Journal page title is incorrect");
		journalPg.checkProfileNameDisplay();
		
		
	} 
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
