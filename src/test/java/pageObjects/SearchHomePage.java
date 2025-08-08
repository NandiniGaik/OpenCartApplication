package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class SearchHomePage extends BasePage{

	public SearchHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']")
	WebElement productSearched;
	
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//h4//a")
	WebElement productName;
	
	
	public boolean productExist() {
		try {
		return productSearched.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	public void clickProductSearched() {
		productName.click();
	}
	
	public void searchProduct(String productToBeSeacrhed) {
	    HomePage hp=new HomePage(driver);
	    hp.typeSearch(productToBeSeacrhed);
	    hp.clickSearch();
		
	   // SearchHomePage shp=new SearchHomePage(driver);
	    clickProductSearched();
	  
	    //Thread.sleep(4000);
	}
	
	
}
