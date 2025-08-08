package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDisplayed;
import pageObjects.SearchHomePage;
import testBase.BaseClass;

public class TC005_ProductCompare extends BaseClass {

	
	
	@Test
	public void testProductCompare() throws InterruptedException {

	    LoginPage lp = new LoginPage(driver);
	    logger.info("********** TC Started *********");
	    lp.loginToApplication(p.getProperty("email"), p.getProperty("password"));
	    
	    SearchHomePage shp=new SearchHomePage(driver);
	    
	    ProductDisplayed pc=new ProductDisplayed(driver);
	    
	    shp.searchProduct("iMac");
	    pc.clickProductCompareButton();
	    
	    String txt=pc.getAlertProductCompare();
	    //System.out.print(txt);
	    Assert.assertTrue(txt.contains("Success: You have added iMac to your product comparison!"));

	    
	   pc.clickProductComparisonLink();
	   
	   Assert.assertEquals(pc.getTextProductComparisonText(), "Product Comparison");
	   
	   logger.info("********** TC Finished *********");
		
		
		
	}
}
