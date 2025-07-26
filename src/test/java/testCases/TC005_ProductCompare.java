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
		HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    hp.clickLogin();

	    LoginPage lp = new LoginPage(driver);
	    lp.setEmail(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    lp.clickLogin();
	   
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
