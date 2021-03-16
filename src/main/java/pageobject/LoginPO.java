package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='signin_userName']")
	WebElement emailInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='signin_password']")
	WebElement passwordInputElem;

	@FindBy(how = How.XPATH, xpath = "//button[@id='genericLogin-button']")
	WebElement signInBtnElem;

	public LoginPO(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) {
		emailInputElem.clear();
		emailInputElem.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordInputElem.clear();
		passwordInputElem.sendKeys(password);
	}

	public MyAccountPO login() {
		signInBtnElem.click();
		return new MyAccountPO(driver);
	}

}
