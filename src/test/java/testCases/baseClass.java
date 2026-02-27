package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class baseClass {
	WebDriver driver;

	public String randomString() {
		String r = RandomStringUtils.randomAlphabetic(5);
		return r;
		
	}
	public String randomNumber() {
		String r = RandomStringUtils.randomNumeric(10);
		return r;
		
	}
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = "C:\\Users\\Stuti\\eclipse-workspace\\opencart\\Screenshot\\"+tname+"-"+timeStamp;
	    File targetFile = new File(targetFilePath);
	    sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
