package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EditAddressPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='firstName']")
	WebElement firstNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='lastName']")
	WebElement lastNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='address']")
	WebElement streetAddressInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='city']")
	WebElement cityInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='customer_country']")
	WebElement countryInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='hidden_zones']")
	WebElement stateProvInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='billingPostalCode']")
	WebElement postalCodeInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='phone']")
	WebElement phoneNumberInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='submitAddress']")
	WebElement changeAddressBtnElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement billingShippingInfoBtnElem;

	public EditAddressPO(WebDriver driver) {
		super(driver);
	}

	public void setStreetAddress(String streetAddress) {
		streetAddressInputElem.clear();
		streetAddressInputElem.sendKeys(streetAddress);
	}

	public void clickOnChangeAddress() {
		changeAddressBtnElem.click();
	}

	public BillingAndShippingAddressesInfoPO goToBillingShippingInfo() {
		wait.until(ExpectedConditions.visibilityOf(billingShippingInfoBtnElem));

		billingShippingInfoBtnElem.click();
		return new BillingAndShippingAddressesInfoPO(driver);
	}

	public String getFirstName() {
		return firstNameInputElem.getAttribute("value");
	}

	public String getLastName() {
		return lastNameInputElem.getAttribute("value");
	}

	public String getAddress() {
		return streetAddressInputElem.getAttribute("value");
	}

	public String getCity() {
		return cityInputElem.getAttribute("value");
	}

	public String getCountry() {
		Select countrySelect = new Select(countryInputElem);
		return countrySelect.getFirstSelectedOption().getText();
	}

	public String getStateProv() {
		return stateProvInputElem.getAttribute("value");
	}

	public String getPostalCode() {
		return postalCodeInputElem.getAttribute("value");
	}

	public String getPhoneNumber() {
		return phoneNumberInputElem.getAttribute("value");
	}

}
