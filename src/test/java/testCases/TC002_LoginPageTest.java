package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginPageTest extends BaseClass {

	@Test(groups= {"Sanity", "Master"})
	public void verifyLogin() {
		try {	
			logger.info("***** Starting TC002_LoginPageTest *****");
			
			//Home Page
			HomePage hp = new HomePage(driver);
			logger.info("Clicked MyAccount link...");
			hp.clickMyAccount();
			logger.info("Clicked Login link...");
			hp.clickLogin();
			
			// login page
			LoginPage login = new LoginPage(driver);
			login.setEmail(p.getProperty("email"));
			login.setPassword(p.getProperty("password"));
			login.clickLogin();
			
			//MyAccount page
			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean targetPage = myAcc.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
	//		Assert.assertEquals(targetPage, true);
			
			logger.info("*** Finished TC002_LoginPageTest ***");
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
}
