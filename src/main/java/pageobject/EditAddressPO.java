package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditAddressPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//input[@id='address']")
	WebElement streetAddressInputElem;

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

}
