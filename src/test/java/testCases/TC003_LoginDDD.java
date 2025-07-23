package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDD extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"DataDriven"})
	public void verifyLoginDDT(String email,String password,String exp){
		logger.info("*******TC Started***********");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Click MyAccount");
		hp.clickLogin();
		logger.info("Click Login in My Account ");
		
		LoginPage lp=new LoginPage(driver);	
		lp.setEmail(email);
		logger.info("Entered email");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean v=mp.myAccountPageExists();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(v==true) {
				mp.clickLogout();
				Assert.assertTrue(true);
				logger.info("******TC PASSED********");
			}else {
				logger.info("******TC Failed********");
				Assert.assertTrue(false);
			}
		}else {
			if(v==false) {
				logger.info("******TC PASSED********");
				Assert.assertTrue(true);
			}else {
				logger.info("******TC Failed********");
				mp.clickLogout();
				Assert.assertTrue(false);
			}
		}}catch(Exception e) {
			e.printStackTrace(); // Show in console
			logger.error("Exception occurred: " + e.getMessage(), e); // Show in log
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		logger.info("******TC Finished********");
	}
}
