package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountLoc;
	
	@FindBy(xpath="//a[@title='My Account']") 
	WebElement myAccountHeaderLoc;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement logoutLoc;
	
	public boolean myAccountPageExists() {
		try {
		return myAccountLoc.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		myAccountHeaderLoc.click();
		logoutLoc.click();
	}
	
	
}
