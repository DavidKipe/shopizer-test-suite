package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

	@FindBy(how = How.XPATH, xpath = "//input[@id='cbox']")
	WebElement createAnAccountCheckInputElem;


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

	public void setStorePickup() {
		By byXpathStorePickup = By.xpath("//input[@id='storePickUp_QC']");
		try {
			WebElement storePickupRadioInputElem = driver.findElement(byXpathStorePickup);
			storePickupRadioInputElem.click();
		} catch (StaleElementReferenceException e) {
			PageFactory.initElements(driver, this);
			WebElement storePickupRadioInputElem = driver.findElement(byXpathStorePickup);
			storePickupRadioInputElem.click();

		}
	}

	public void clickOnCheckShipToADifferentAddress() {
		shipToADifferentAddressCheckInputElem.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='deliveryPostalCode']")));
	}

	public void clickOnCreateAnAccount() {
		createAnAccountCheckInputElem.click();
	}

	public void setShippingFirstName(String firstName) {
		WebElement shippingFirstNameInputElem = driver.findElement(By.xpath("//body/div[5]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));
		shippingFirstNameInputElem.clear();
		shippingFirstNameInputElem.sendKeys(firstName);
	}

	public void setShippingLastName(String lastName) {
		WebElement shippingLastNameInputElem = driver.findElement(By.xpath("//body/div[5]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/input[1]"));
		shippingLastNameInputElem.clear();
		shippingLastNameInputElem.sendKeys(lastName);
	}

	public void setShippingAddress(String address) {
		WebElement shippingAddressInputElem = driver.findElement(By.xpath("//input[@id='customer.delivery.address']"));
		shippingAddressInputElem.clear();
		shippingAddressInputElem.sendKeys(address);
	}

	public void setShippingCity(String city) {
		WebElement shippingCityInputElem = driver.findElement(By.xpath("//input[@id='customer.delivery.city']"));
		shippingCityInputElem.clear();
		shippingCityInputElem.sendKeys(city);
	}

	public void setShippingCountry(String country) {
		WebElement shippingCountryInputElem = driver.findElement(By.xpath("//select[@id='customer.delivery.country']"));
		Select countrySelect = new Select(shippingCountryInputElem);
		countrySelect.selectByVisibleText(country);
	}

	public void setShippingStateProvince(String stateProvince) {
		WebElement shippingStateProvinceInputElem = driver.findElement(By.xpath("//select[@id='deliveryStateList']"));
		Select stateProvinceSelect = new Select(shippingStateProvinceInputElem);
		stateProvinceSelect.selectByVisibleText(stateProvince);
	}

	public void setShippingPostalCode(String postalCode) {
		WebElement shippingPostalCodeInputElem = driver.findElement(By.xpath("//input[@id='deliveryPostalCode']"));
		shippingPostalCodeInputElem.clear();
		shippingPostalCodeInputElem.sendKeys(postalCode);
	}

}
