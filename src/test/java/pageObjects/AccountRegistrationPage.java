package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkPrivacy;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirmation;
	
	
	//Action Methods
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txtLastname.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelePhone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void setPrivacyPolicy() {
		chkPrivacy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
