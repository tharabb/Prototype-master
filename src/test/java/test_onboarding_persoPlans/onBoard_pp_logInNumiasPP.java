package test_onboarding_persoPlans;

import org.testng.annotations.Test;

import com.NS.pages.nsHome;
import com.NS.pages.nsLogIn;
import com.NS.pages.nsMyProfile;
import com.NS.pages.nsPPquestionaire;
import com.NS.pages.nsSignUpToday;
import com.NS.pages.nsUniqYrs;
import com.NS.pages.nsWeightLossPgm;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;
import com.numi.qa.base.randomEmail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/*----------------------------------------------------
 * Scenario: Login using PP account
 * Create a new PP account in NS 
 * Login to NUMI web using the above PP plan 
 * Say NO to week1<<Verify the stage2 activity question screens (activity1, activity2) are appearing
 * Verify the CIPD calculation appears with calculated value 
 * Verify the user lands in JOurnal and Calorie goal syn with CIPD value 
------------------------------------------------------*/

public class onBoard_pp_logInNumiasPP extends baseClass {

	signInPage signInPg;
	nsHome nsHom = new nsHome();
	nsLogIn nsLog = new nsLogIn();
	keywordFunctions kf = new keywordFunctions();
	nsLogIn nsLgIn = new nsLogIn();
	nsSignUpToday nsSign = new nsSignUpToday();
	randomEmail randomGen = new randomEmail();
	nsMyProfile nsProf = new nsMyProfile();
	nsWeightLossPgm nsProgm = new nsWeightLossPgm();
	nsUniqYrs UniqYrs = new nsUniqYrs();
	nsPPquestionaire questionPg = new nsPPquestionaire();
	
	public onBoard_pp_logInNumiasPP() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();

	}

	@Parameters({ "URL" })
	@Test(priority = 1)
	public void createPPAcct_carbConsMen(String URL) throws Throwable {
		driver.get(URL);
		waitForPageLoad(js);
		kf.click(nsHom.getnsSignIn(), "SignInBttn");
		kf.click(nsLgIn.getSignUpBttn(), "SignUpBttn");
		kf.waitForVisibility(nsSign.nsFN());
		nsSign.nsFN().sendKeys(randomGen.generatePPfn());
		
		kf.waitForVisibility(nsSign.email());
		nsSign.email().sendKeys(randomGen.generatePPEmail());
	
		nsSign.pwd().sendKeys("test1234");
		System.out.println("Gender is: Female");
		kf.click(nsSign.createMyAcct(), "Create My Acct");
		
		//Verify the application navigates to MyProfile page
		kf.verifyPageHeading(nsProf.getMyProfileHeading());
		kf.click(nsProf.getShopPlans(), "ShopPlans button");
		
		//Verify the application navigates to "Weight loss programs" where it displays "choose your 4 week program"
		kf.click(nsProgm.getUniqYrsPlan(), "Uniq Yrs Plan");
		
		//Verify if the womens pan is selected by default
		kf.waitForVisibility(UniqYrs.getWomenBttn());
		kf.click(UniqYrs.getPPcheckBox(), "PP check box");
		kf.click(UniqYrs.getPersonalBttn(), "Personalization Bttn");
		
		//Verify if the application navigates to questionaire page 
		waitForPageLoad(js);
		kf.verifyPageHeading(questionPg.getquesPgHeading());
		questionPg.getWeightInputBox().sendKeys("300");
		questionPg.getHeightFeetInpBox().sendKeys("6");
		questionPg.getHeightInchInpBox().sendKeys("1");
		Thread.sleep(100);
		questionPg.getBdayInpBox().sendKeys("11/11/1981");
		Thread.sleep(100);
		kf.click(questionPg.getLessthan15(), "lessThan15lbs");
		Thread.sleep(100);
		kf.click(questionPg.getApple(), "Apple Shape");
		Thread.sleep(100);
		kf.click(questionPg.getNeither(), "Neither Bttn");
		Thread.sleep(100);
		kf.click(questionPg.getActSedentary(), "Sedentary");
		Thread.sleep(100);
		kf.click(questionPg.getLittleToNone(), "littleToNone");
		Thread.sleep(100);
		kf.click(questionPg.getDescribesYou1(), "getDescribesYou1");
		Thread.sleep(100);
		kf.click(questionPg.getProteinShakes2(), "ProteinShakes2");
		Thread.sleep(100);
		kf.click(questionPg.getGetMyPlanBttn(), "Get My Plan");
		Thread.sleep(100);
		kf.verifyPageHeading(questionPg.getReviewText());
	}

	@AfterClass
	public void beforeClass() {
		driver.quit();
	}

}
