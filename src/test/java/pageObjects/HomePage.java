package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import testBase.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']") 
	WebElement myAccountLoc;
	
	@FindBy(xpath="//a[text()='Register']") 
	WebElement registerLoc;
	
	@FindBy(xpath="//a[text()='Login']") 
	WebElement loginLoc;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchLoc;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchIcon;
	
	public void clickMyAccount() {
	
		myAccountLoc.click();
	}
	
	public void clickRegister() {
		registerLoc.click();
	}
	
	public void clickLogin() {
		loginLoc.click();
	}
	
	public void typeSearch(String text) {
		BaseClass.waitUntilElementIsVisible(searchLoc);
		searchLoc.sendKeys(text);
	}
	
	public void clickSearch() {
		searchIcon.click();
	}
	public void backspaceSearchField() {
		BaseClass.controlABackSpace(searchLoc);
	}
	
	
	
	

}
