package testCases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("********** TC Started *********");
		try {
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Click MyAccount");
			hp.clickLogin();
			logger.info("Click Login in My Account ");
			
			LoginPage lp=new LoginPage(driver);	
			lp.setEmail(p.getProperty("email"));
			logger.info("Entered email");
			lp.setPassword(p.getProperty("password"));
			logger.info("Entered password");
			lp.clickLogin();
			
			MyAccountPage mp=new MyAccountPage(driver);
			boolean v=mp.myAccountPageExists();
			//Assert.assertEquals(v, true,"Login Failed");
			Assert.assertTrue(v);
			logger.info("*********TC Passed***********");
			
		}catch(Exception e) {
			AssertJUnit.fail();
		}
		logger.info("*********TC Finished***********");
	}

}
