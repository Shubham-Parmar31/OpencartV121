package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verifyLoginDDT(String email, String pwd, String exp) {
		logger.info("*** Starting TC003_LoginTestDDT ***");
		
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			// Login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("valid")) {
				if(targetPage == true) {
					mp.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")){
				if(targetPage==true) {
					mp.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC003_LoginTestDDT ***");
	}
}
