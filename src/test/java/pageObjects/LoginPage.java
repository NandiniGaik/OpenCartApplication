package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement emailLoc;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwordLoc;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement loginButtonLoc;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()=\"Logout\"]")
	WebElement logoutbtn;
	
	public void setEmail(String email) {
		emailLoc.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordLoc.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButtonLoc.click();
	}
	
	public void clickLogout() {
		logoutbtn.click();
	}
	
    public void loginToApplication(String email,String password) {
    	HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    hp.clickLogin();

	    //LoginPage lp = new LoginPage(driver);
	    setEmail(email);
	    setPassword(password);
	    clickLogin();
    }

}
