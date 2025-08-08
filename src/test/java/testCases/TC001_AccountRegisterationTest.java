package testCases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Registeration;
import testBase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {


	Registeration reg;
	
	@Test(groups= {"Regression","Master"})
	public void verifyAccountRegisteration() {
		
		logger.info("********** TC Started *********");
		try {
		goToRegistrationPage();
		
		reg=new Registeration(driver);
		
		reg.setFirstName(generateRandomString().toUpperCase());
		
		reg.setLastName(generateRandomString().toUpperCase());
		
		reg.setEmail(generateRandomString()+"@gmail.com");
		reg.setTelephone(generateRandomNumber());
		reg.setPassword("Password@123");
		reg.setConfirmPassword("Password@123");
		reg.clickTermsAndConditions();
		reg.clickContinue();
		String msg=reg.getConfirmationMsg();
		
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("Account created successfully.");
			
			reg.clickSuccessAccountRegContinue();
			Assert.assertTrue(reg.isMyAccountDisplayed());
			logger.info("My Account displayed");
			
			
		}else {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
			
		}
		
		
		//Assert.assertEquals(msg, "Your Account Has Been Created!");
		//logger.info("Passed");
		}catch (Exception e) {
			//logger.error("Test failed");
			//logger.debug("Debug logs");
			AssertJUnit.fail();
		}
		
		logger.info("************ TC Finisdhed********");
	}
	
	@Test(groups= {"Sanity"})
	public void validateErrorMsgEmptyData() {
		logger.info("********** TC Started *********");
		goToRegistrationPage();
		reg=new Registeration(driver);
		reg.clickContinue();
		Assert.assertTrue(reg.validateErrorMsg() && reg.validatePrivacyError());
		
		logger.info("********** TC Finished *********");
		
		
	}
	
	
}
