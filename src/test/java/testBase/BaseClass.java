package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"Regression","Master","DataDriven"})
	@Parameters({"browser","os"})
	public void setUp(String browser,String os) throws IOException {
		
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap= new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("Invalid os");
				return;
			}
			
			if(browser.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
			}else if(browser.equalsIgnoreCase("edge")) {
				cap.setBrowserName("MicrosoftEdge");
			}else if(browser.equalsIgnoreCase("firefox")) {
				cap.setBrowserName("firefox");
			}
			else {
				System.out.println("Invalid browser");
				return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(browser){
		case "chrome":driver=new ChromeDriver(); break;
		case "safari":driver=new SafariDriver(); break;
		case "firefox":driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		}
		
		logger=LogManager.getLogger(this.getClass());
		
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Regression","Master","DataDriven"})
	public void teardown() {
		driver.quit();
	}
	
	public String generateRandomString() {
		String str=RandomStringUtils.randomAlphabetic(5);
		return str;
		
	}
	
	public String generateRandomNumber() {
		String str=RandomStringUtils.randomNumeric(10);
		return str;
		
	}
	
	public String generateAlphaNumberic() {
		String str=RandomStringUtils.randomAlphabetic(5);	
		String str1=RandomStringUtils.randomNumeric(3);
		return str+"#"+str1;
	}
	
	public String captureScreen(String tname)throws IOException {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"/screenshots/"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}


}
