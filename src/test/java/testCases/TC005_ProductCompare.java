package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductCompare;
import pageObjects.SearchHomePage;
import testBase.BaseClass;

public class TC005_ProductCompare extends BaseClass {

	
	
	@Test
	public void testProductCompare() throws InterruptedException {

	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApplication(p.getProperty("email"), p.getProperty("password"));
	    HomePage hp=new HomePage(driver);
	    hp.typeSearch("iMac");
	    hp.clickSearch();
		
	    SearchHomePage shp=new SearchHomePage(driver);
	    shp.clickProductSearched();
	    
	    Thread.sleep(4000);
	    
	    ProductCompare pc=new ProductCompare(driver);
	    pc.clickProductCompareButton();
	    
	    String txt=pc.getAlertProductCompare();
	    //System.out.print(txt);
	    Assert.assertTrue(txt.contains("Success: You have added iMac to your product comparison!"));

	    
	   pc.clickProductComparisonLink();
	   
	   Assert.assertEquals(pc.getTextProductComparisonText(), "Product Comparison");
	   
	    
		
		
		
	}
}
