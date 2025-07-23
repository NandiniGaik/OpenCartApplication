package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class Registeration extends BasePage{

	public Registeration(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstNameLoc;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastNameLoc;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailLoc;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement telephoneLoc;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordLoc;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement confirmPasswordLoc;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement termsAndConditionLoc;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueLoc;
	
	@FindBy(xpath="//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	WebElement successRegisterationLoc;
	
	public void setFirstName(String firstName) {
		firstNameLoc.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastNameLoc.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		emailLoc.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		telephoneLoc.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		passwordLoc.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		confirmPasswordLoc.sendKeys(confirmPassword);
	}
	
	public void clickTermsAndConditions() {
		termsAndConditionLoc.click();
	}
	
	public void clickContinue() {
		continueLoc.click();
	}
	
	public String getConfirmationMsg() {
		String msg;
		try {
		msg= successRegisterationLoc.getText();
		}catch(Exception e) {
			msg=e.getMessage();
			
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
