package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.extentReportManager;
import pageObject.accountRegistrationPage;
import pageObject.homePage;

@Listeners(Utilities.extentReportManager.class)
public class TC_001_Account_Registration extends baseClass {
	WebDriver driver;
	public Logger logger;
	public Properties p;
		
		@BeforeTest
		public void setup(String OS,String browser) throws Exception{
			p = new Properties();
			p.load(new FileReader(".//src//test//resources//config.properties"));
			logger = LogManager.getLogger(this.getClass());
			if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
				DesiredCapabilities capabilities =  new DesiredCapabilities();
				if(OS.equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN11);
				}else if(OS.equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				}
				switch(browser.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome");
				break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");
				break;
				}
				driver = new RemoteWebDriver(new URL("http://192.168.18.41:4444"),capabilities);
			}
			if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
				DesiredCapabilities capabilities =  new DesiredCapabilities();
				if(OS.equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN11);
				}else if(OS.equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				}
				switch(browser.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome");
				break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");
				break;
				}
				driver = new RemoteWebDriver(new URL("http://192.168.18.41:4444"),capabilities);
			}
		   driver = new ChromeDriver(); 
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
			return;
		}
	
	
	@Test(groups= {"Regression", "Master"})
	public void acountRegister() {
		homePage hp = new homePage(driver);
		try {
			logger.info("***Starting test case***");
		hp.clickMyAccount();
		logger.info("***Clicking my account***");
		hp.clickRegister();
		logger.info("***click register**");
		accountRegistrationPage accregPg = new accountRegistrationPage(driver);
		logger.info("***giving test input***");
		accregPg.fillform(randomString(), randomString(), randomString()+"@gmail.com", randomNumber(), randomString());
		String confmsg = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		logger.info("***Validating output***");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
		catch(Exception e) {
			logger.error("TestFailed");
			logger.debug("debug logs...");
			Assert.fail();
		}
		logger.info("Test Completed");
		}

}
