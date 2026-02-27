package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.baseClass;

public class extentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter("C:\\Users\\Stuti\\eclipse-workspace\\opencart\\Report\\myreport.html");
		sparkReporter.config().setDocumentTitle("OpenCart Report");
		sparkReporter.config().setReportName("OpenCart");
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Cart");
		extent.setSystemInfo("Computer Name", "LocalHost");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, "Test Case Passed is:"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, "Test Case failed is:"+result.getName());
		test.log(Status.INFO, "Test Case failed due to:"+result.getThrowable().getMessage());
		try {
			String imgPath = new baseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, "Test Case skipped is:"+result.getName());
		test.log(Status.INFO, "Test Case skipped due to:"+result.getThrowable().getMessage());
	}

	public void onTestFinish(ITestContext context) {
		extent.flush();
		/**String pathOfExtentReport = "C:\\Users\\Stuti\\eclipse-workspace\\opencart\\Report\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
	} catch(IOException e) {
		e.printStackTrace();
	}**/


}


}
