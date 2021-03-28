package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='firstName']")
	WebElement firstNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='lastName']")
	WebElement lastNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='registration_country']")
	WebElement countryInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='hidden_zones']")
	WebElement stateProvInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='emailAddress']")
	WebElement emailInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='password']")
	WebElement passwordInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='passwordAgain']")
	WebElement repeatPasswordInputElem;

	@FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Create an account')]")
	WebElement createAccountBtnElem;

	@FindBy(how = How.XPATH, xpath = "//div[@id='customer.errors']")
	WebElement customerErrorsDivElem;

	public RegistrationPO(WebDriver driver) {
		super(driver);
	}

	public void setFirstName(String firstName) {
		firstNameInputElem.clear();
		firstNameInputElem.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		lastNameInputElem.clear();
		lastNameInputElem.sendKeys(lastName);
	}

	public void setCountry(String country) {
		Select countrySelect = new Select(countryInputElem);
		countrySelect.selectByVisibleText(country);
	}

	public void setStateProvince(String stateProvince) {
		stateProvInputElem.clear();
		stateProvInputElem.sendKeys(stateProvince);
	}

	public void setEmail(String email) {
		emailInputElem.clear();
		emailInputElem.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordInputElem.clear();
		passwordInputElem.sendKeys(password);
	}

	public void setRepeatPassword(String password) {
		repeatPasswordInputElem.clear();
		repeatPasswordInputElem.sendKeys(password);
	}

	public MyAccountPO createAccount() {
		createAccountBtnElem.click();
		return new MyAccountPO(driver);
	}

	public String getCustomerErrors() {
		return customerErrorsDivElem.getText();
	}

}
