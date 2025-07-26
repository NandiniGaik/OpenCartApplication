package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchHomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_Search extends BaseClass{

	@Test(dataProvider="SearchData",dataProviderClass=DataProviders.class,groups={"Master"})
	public void searchBoxTestHomePage(String data,String exp) throws InterruptedException {
		logger.info("********** TC Started *********");
		//String searchData="iMac";
		HomePage hp=new HomePage(driver);
		SearchHomePage shp=new SearchHomePage(driver);
		hp.typeSearch(data);
		logger.info("Search data");
		hp.clickSearch();
		logger.info("Click search icon");
		Thread.sleep(5000);
		boolean actual=shp.productExist();
		if(exp.equalsIgnoreCase("valid")) {
		    if(actual==true) {
				Assert.assertTrue(true);
				hp.backspaceSearchField();
				logger.info("********** TC Passed *********");
			}else {
				Assert.assertFalse(false);
				logger.info("********** TC Failed *********");
				
			}
		}else{
				if(actual==false) {
					Assert.assertTrue(true);
					hp.backspaceSearchField();
					logger.info("********** TC Passed *********");
				}else {
					Assert.assertFalse(false);
					logger.info("********** TC Failed *********");
				}
			}
		
		
        logger.info("********** TC Finished *********");
		
		
	}
	
	@Test(dataProvider="SearchData",dataProviderClass=DataProviders.class,groups={"Master"})
	public void searchBoxTestHomePageAfterLogin(String data,String exp) throws InterruptedException {
		logger.info("********** TC Started *********");
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		//String searchData="iMac";
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		SearchHomePage shp=new SearchHomePage(driver);
		hp.typeSearch(data);
		logger.info("Search data");
		hp.clickSearch();
		logger.info("Click search icon");
		Thread.sleep(5000);
		boolean actual=shp.productExist();
		if(exp.equalsIgnoreCase("valid")) {
		    if(actual==true) {
				Assert.assertTrue(true);
				hp.clickMyAccount();
				lp.clickLogout();
				hp.backspaceSearchField();
				
				logger.info("********** TC Passed *********");
			}else {
				Assert.assertFalse(false);
				logger.info("********** TC Failed *********");
				
			}
		}else{
				if(actual==false) {
					Assert.assertTrue(true);
					hp.clickMyAccount();
					lp.clickLogout();
					hp.backspaceSearchField();
					logger.info("********** TC Passed *********");
				}else {
					Assert.assertFalse(false);
					logger.info("********** TC Failed *********");
				}
			}
		
		
        logger.info("********** TC Finished *********");
		
		
	}
	
}
