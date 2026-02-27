package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {

	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[text()=\"Register\"]") WebElement Register;
	@FindBy(xpath="//a[text()=\"Login\"]") WebElement Login;
	@FindBy(xpath="//a[@title=\"My Account\"]") WebElement myacount;
	public void clickRegister() {
		Register.click();
	}
	public void clickLogin() {
		Login.click();
	}
	public void clickMyAccount() {
		myacount.click();
	}

}
