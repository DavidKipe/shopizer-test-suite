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

	@FindBy(how = How.XPATH, xpath = "//div[@id='password.errors']")
	WebElement passwordErrorElem;

	@FindBy(how = How.XPATH, xpath = "//div[@id='formError']")
	WebElement formErrorElem;

	@FindBy(how = How.XPATH, xpath = "//div[@id='store.success']")
	WebElement storeSuccessMessageElem;

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

	public boolean isChangePasswordButtonEnabled() {
		return changePasswordBtnElem.isEnabled();
	}

	public String getPasswordError() {
		return passwordErrorElem.getText();
	}

	public String getFormError() {
		return formErrorElem.getText();
	}

	public String getStoreSuccessMessage() {
		return storeSuccessMessageElem.getText();
	}

}
