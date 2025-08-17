package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression", "Master"})
	public void verifyAccountRegistration() {
		try {
			logger.info("**** Starting TC001_AccountRegistrationTest ****");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link...");
			
			hp.clickRegister();
			logger.info("Clicked on Register link...");
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details...");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setTelePhone(randomNumber());
			
			String password = randomAlphaNum();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected message...");
			String message = regpage.getConfirmationMessage();
			Assert.assertEquals(message, "Your Account Has Been Created!");
			
			logger.info("**** Finished TC001_AccountRegistrationTest ****");
		}
		catch(Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}
}
