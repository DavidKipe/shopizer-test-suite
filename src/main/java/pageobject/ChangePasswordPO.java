package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='currentPassword']")
	WebElement currentPasswordInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='password']")
	WebElement newPasswordInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='checkPassword']")
	WebElement repeatPasswordInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='submitChangePassword']")
	WebElement changePasswordBtnElem;

	public ChangePasswordPO(WebDriver driver) {
		super(driver);
	}

	public void setCurrentPassword(String password) {
		currentPasswordInputElem.clear();
		currentPasswordInputElem.sendKeys(password);
	}

	public void setNewPassword(String newPassword) {
		newPasswordInputElem.clear();
		newPasswordInputElem.sendKeys(newPassword);
	}

	public void setRepeatPassword(String newPassword) {
		repeatPasswordInputElem.clear();
		repeatPasswordInputElem.sendKeys(newPassword);
	}

	public void clickOnChangePassword() {
		changePasswordBtnElem.click();
	}

}
