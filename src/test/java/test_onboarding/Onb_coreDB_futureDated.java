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
 * Plan Details: Male<< Core DB plan << FutureDated 
 * Verification: 1) User is able to complete on-boarding and land in Journal Page
------------------------------------------------------*/
public class Onb_coreDB_futureDated extends baseClass{
	
	
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
	keywordFunctions kf = new keywordFunctions();
	
	public Onb_coreDB_futureDated(){
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
	public void lessThanHundredWtLoss_coreDBplan_futureDated() {
		newSignUpPg = signInPg.signUpForNumiClick(); // returns new signup page
		setUpAcctPg = newSignUpPg.createNewNumiAcctBttnClick(); // returns setup account page
		acctDetailsPg = setUpAcctPg.setUpNewUserAcct();
		tellUsprofilePg = acctDetailsPg.setUpaccntDetailsPage();
		chooseNsPln = tellUsprofilePg.tellUsProfPage_MoreThan100_futureDated();		
		Assert.assertTrue(chooseNsPln.verify_chooseNSPlanPg_Heading(), "Choose NS plan heading is incorrect");
		chooseNsPlanListPg = chooseNsPln.choosePlanButton();
		//Since the goal weights more than 100, low blood sugar page appears.
		lowBloodSugarPg= chooseNsPlanListPg.chooseDBPlan_verifyLowBPPgDisplay(chooseNsPlanListPg.getCoreDB());
		lowBloodSugarPg.verifyHeading_lowBSugarPg();
		stayOnTrackEMailNotifyPg= lowBloodSugarPg.bloodSugarResposne(lowBloodSugarPg.getYesLowBldSugar());
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
		kf.closeSession();
		
	}
	


}
