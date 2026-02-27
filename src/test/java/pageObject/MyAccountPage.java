package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends basePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//h2[text()=\"My Account\"]") WebElement msg;
	@FindBy(xpath = "//a[text()=\"Logout\"]") WebElement logout;
	public boolean loginsuccess() {
		try {
			return msg.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	public void logout() {
		logout.click();
	}

}
