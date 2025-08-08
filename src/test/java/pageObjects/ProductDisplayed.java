package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class ProductDisplayed extends BasePage{

	public ProductDisplayed(WebDriver driver) {
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
	
	@FindBy(xpath="//ul[@class='thumbnails']//a")
	List<WebElement> thumbnails;
	
	@FindBy(xpath="//img[@class='mfp-img']")
	WebElement whiteBox;
	
	@FindBy(xpath="//button[@class='mfp-arrow mfp-arrow-right mfp-prevent-close']")
	WebElement nextButton;
	
	@FindBy(xpath="//button[@class='mfp-arrow mfp-arrow-left mfp-prevent-close']")
	WebElement backButton;
	
	@FindBy(xpath="//button[@class='mfp-close']")
	WebElement closeButton;
	
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
	
	public boolean verifyThumbnail() throws InterruptedException {
		for(WebElement we:thumbnails) {
			we.click();
			Thread.sleep(4000);
			boolean b=whiteBox.isDisplayed();
			nextButton.click();
			backButton.click();
			closeButton.click();
			if(b==false) {
				return false;
			}
			
		}
		return true;
		
		
		
	}
	
	
	
}
