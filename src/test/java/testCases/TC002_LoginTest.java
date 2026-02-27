package testCases;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.MyAccountPage;
import pageObject.accountRegistrationPage;
import pageObject.homePage;
import pageObject.loginpage;

public class TC002_LoginTest {
	WebDriver driver;
	public Logger logger;
	public Properties p;
		
		@BeforeTest
		public void setup() throws Exception{
			p = new Properties();
			p.load(new FileReader(".//src//test//resources//config.properties"));
			logger = LogManager.getLogger(this.getClass());
			driver = new ChromeDriver(); 
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
			return;
		}
	
	
	@Test(groups= {"Sanity", "Master"})
	public void login() {
		homePage hp = new homePage(driver);
			logger.info("***Starting test case***");
		hp.clickMyAccount();
		logger.info("***Clicking my account***");
		hp.clickLogin();;
		logger.info("***click login**");
		loginpage lg = new loginpage(driver);
		logger.info("***giving test input***");
		lg.setEmail(p.getProperty("email"));
		lg.setPassword(p.getProperty("password"));
		lg.login();
		MyAccountPage ap = new MyAccountPage(driver);
		ap.loginsuccess();
	}

}
