package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegistrationPage extends basePage {

	public accountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name="firstname") WebElement firstName;
	@FindBy(name="lastname") WebElement lastName;
	@FindBy(name="email") WebElement email;
	@FindBy(name="telephone") WebElement phone;
	@FindBy(name="password") WebElement password;
	@FindBy(name="confirm") WebElement confirm;
	@FindBy(name="agree") WebElement agree;
	@FindBy(xpath="//input[@value=\"Continue\"]") WebElement cont;
	public void fillform(CharSequence first, CharSequence last, CharSequence mail, CharSequence ph, CharSequence pass) {
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		email.sendKeys(mail);
		phone.sendKeys(ph);
		password.sendKeys(pass);
		confirm.sendKeys(pass);
		agree.click();
		cont.click();
	}

}
