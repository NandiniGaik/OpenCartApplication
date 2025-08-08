package pageObjects;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='text-danger']")
	List<WebElement> errorMessages; 
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyError;
	
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
	
	public void clickSuccessAccountRegContinue(){
		continuebtn.click();
	}
	
	public boolean isMyAccountDisplayed() {
		return MyAccount.isDisplayed();
	}
	
	
	public boolean validateErrorMsg() {
		List<String> errorMsg=new ArrayList<>();
		for(WebElement we:errorMessages) {
			errorMsg.add(we.getText());
		}
		
		if(errorMsg.get(0).equals("First Name must be between 1 and 32 characters!") 
				&& errorMsg.get(1).equals("Last Name must be between 1 and 32 characters!") 
				&& errorMsg.get(2).equals("E-Mail Address does not appear to be valid!") 
				&& errorMsg.get(3).equals("Telephone must be between 3 and 32 characters!")
				&& errorMsg.get(4).equals("Password must be between 4 and 20 characters!")) {
			return true;
		}
		return false;
		
	}
	
	
	public boolean validatePrivacyError() {
		if(privacyError.getText().equals("Warning: You must agree to the Privacy Policy!")) {
			return true;
		}
		return false;
	}
	
	
	
	

}
