package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class ProductCompare extends BasePage{

	public ProductCompare(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='btn-group']//button[@data-original-title='Compare this Product']")
	WebElement productCompareButtonLoc;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertProductCompareLoc;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[text()='product comparison']")
	WebElement productComaprisionLoc;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement productComparisonText;
	
	public void clickProductCompareButton() {
		productCompareButtonLoc.click();	
	}
	
	public String getAlertProductCompare() {
		return alertProductCompareLoc.getText();
	}

	public void clickProductComparisonLink() {
		productComaprisionLoc.click();
	}
	
	public String getTextProductComparisonText() {
		return productComparisonText.getText();
	}
	
}
