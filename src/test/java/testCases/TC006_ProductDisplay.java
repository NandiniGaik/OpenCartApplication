package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDisplayed;
import pageObjects.SearchHomePage;
import testBase.BaseClass;

public class TC006_ProductDisplay extends BaseClass{

	
	@Test(groups= {"Sanity"})
	public void verifyProductsDisplayedThumbnail() throws InterruptedException {
		
		logger.info("********** TC Started *********");
		SearchHomePage shp=new SearchHomePage(driver);
		
		shp.searchProduct("iMac");
		logger.info("search product");
		
		ProductDisplayed pd=new ProductDisplayed(driver);
		Assert.assertTrue(pd.verifyThumbnail());
		logger.info("passed");
		logger.info("********** TC Finished *********");
		
		
	}
}
