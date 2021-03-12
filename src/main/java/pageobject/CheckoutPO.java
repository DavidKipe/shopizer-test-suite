package pageobject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.firstName']")
	WebElement billingFirstNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.lastName']")
	WebElement billingLastNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.billing.address']")
	WebElement billingAddressInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.billing.city']")
	WebElement billingCityInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='customer.billing.country']")
	WebElement billingCountryInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='billingStateList']")
	WebElement billingStateProvinceInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='billingPostalCode']")
	WebElement billingPostalCodeInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.emailAddress']")
	WebElement billingEmailInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.billing.phone']")
	WebElement billingPhoneNumberInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='shipToDeliveryAddress']")
	WebElement shipToADifferentAddressCheckInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@name='customer.delivery.firstName']")
	WebElement shippingFirstNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@name='customer.delivery.lastName']")
	WebElement shippingLastNameInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.delivery.address']")
	WebElement shippingAddressInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customer.delivery.city']")
	WebElement shippingCityInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='customer.delivery.country']")
	WebElement shippingCountryInputElem;

	@FindBy(how = How.XPATH, xpath = "//select[@id='deliveryStateList']")
	WebElement shippingStateProvinceInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='deliveryPostalCode']")
	WebElement shippingPostalCodeInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='cbox']")
	WebElement createAnAccountCheckInputElem;

	@FindBy(how = How.XPATH, xpath = "//input[@id='storePickUp_QC']")
	WebElement storePickUpRadioInputElem;


	public CheckoutPO(WebDriver driver) {
		super(driver);
	}

	public void setBillingFirstName(String firstName) {
		billingFirstNameInputElem.clear();
		billingFirstNameInputElem.sendKeys(firstName);
	}

	public void setBillingLastName(String lastName) {
		billingLastNameInputElem.clear();
		billingLastNameInputElem.sendKeys(lastName);
	}

	public void setBillingAddress(String address) {
		billingAddressInputElem.clear();
		billingAddressInputElem.sendKeys(address);
	}

	public void setBillingCity(String city) {
		billingCityInputElem.clear();
		billingCityInputElem.sendKeys(city);
	}

	public void setBillingCountry(String country) {
		Select countrySelect = new Select(billingCountryInputElem);
		countrySelect.selectByVisibleText(country);
	}

	public void setBillingStateProvince(String stateProvince) {
		Select stateProvinceSelect = new Select(billingStateProvinceInputElem);
		stateProvinceSelect.selectByVisibleText(stateProvince);
	}

	public void setBillingPostalCode(String postalCode) {
		billingPostalCodeInputElem.clear();
		billingPostalCodeInputElem.sendKeys(postalCode);
	}

	public void setBillingEmail(String email) {
		billingEmailInputElem.clear();
		billingEmailInputElem.sendKeys(email);
	}

	public void setBillingPhoneNumber(String phoneNumber) {
		billingPhoneNumberInputElem.clear();
		billingPhoneNumberInputElem.sendKeys(phoneNumber);
	}

	public void setStorePickUp() {
		// Since the store pick up radio button appears after giving value to postal code input
		// StaleElementReference exception is thrown if not properly waiting for the element
		// Selenium waits do not seem wotk correctly here, so I forced waiting with Thread.sleep
		// and retried every tot milliseconds
		int maxAttempts = 100;
		int millisecondsWait = 20;
		StaleElementReferenceException staleElementRefExc = new StaleElementReferenceException("null");
		int i;
		for (i = 0; i < maxAttempts; i++)
			try {
				storePickUpRadioInputElem.click();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale exception!!! " + i);
				staleElementRefExc = e;
				try {
					Thread.sleep(millisecondsWait);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}
		if (i == maxAttempts)
			throw staleElementRefExc;
	}

	public void clickOnCheckShipToADifferentAddress() {
		shipToADifferentAddressCheckInputElem.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(shippingPostalCodeInputElem)); // wait for the new form to appear
	}

	public void clickOnCreateAnAccount() {
		createAnAccountCheckInputElem.click();
	}

	public void setShippingFirstName(String firstName) {
		shippingFirstNameInputElem.clear();
		shippingFirstNameInputElem.sendKeys(firstName);
	}

	public void setShippingLastName(String lastName) {
		shippingLastNameInputElem.clear();
		shippingLastNameInputElem.sendKeys(lastName);
	}

	public void setShippingAddress(String address) {
		shippingAddressInputElem.clear();
		shippingAddressInputElem.sendKeys(address);
	}

	public void setShippingCity(String city) {
		shippingCityInputElem.clear();
		shippingCityInputElem.sendKeys(city);
	}

	public void setShippingCountry(String country) {
		Select countrySelect = new Select(shippingCountryInputElem);
		countrySelect.selectByVisibleText(country);
	}

	public void setShippingStateProvince(String stateProvince) {
		Select stateProvinceSelect = new Select(shippingStateProvinceInputElem);
		stateProvinceSelect.selectByVisibleText(stateProvince);
	}

	public void setShippingPostalCode(String postalCode) {
		shippingPostalCodeInputElem.clear();
		shippingPostalCodeInputElem.sendKeys(postalCode);
	}

}