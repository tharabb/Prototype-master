package test_onboarding;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

public class Onb_verfiyErrMsg_setUpAcctDetailPg extends baseClass {
	signInPage signInPg;
	keywordFunctions kf = new keywordFunctions();
	
	public Onb_verfiyErrMsg_setUpAcctDetailPg() {
		super();
	}
	
	@BeforeClass
	public void initiateDriver() {
		initialization();
		signInPg = new signInPage();
		kf.getUrl("url");
	
		
	}

	@Test 
	public void verfiyErrorMsg_setUpAcctDetailsPage() {
		System.out.println("verfiyErrorMsg_setUpAcctDetailsPage");
	}
	
	
	@AfterClass
	public void teardown() {
		kf.closeSession();	
	}
}
