package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends basePage {

	public loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name="email") WebElement email;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@value=\"Login\"]") WebElement login;
	public void setEmail(CharSequence mail) {
		email.sendKeys(mail);
	}
	public void setPassword(CharSequence pass) {
		password.sendKeys(pass);
	}
	public void login() {
		login.click();
	}

}
