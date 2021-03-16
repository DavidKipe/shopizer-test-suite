package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingAndShippingAddressesInfoPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[1]/div[1]/span[1]/p[1]/a[1]")
	WebElement editBillingAddressLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[1]/div[2]/span[1]/p[1]/a[1]")
	WebElement editShippingAddressLinkElem;

	public BillingAndShippingAddressesInfoPO(WebDriver driver) {
		super(driver);
	}

	public EditAddressPO goToEditBillingAddress() {
		editBillingAddressLinkElem.click();
		return new EditAddressPO(driver);
	}

	public EditAddressPO goToEditShippingAddress() {
		editShippingAddressLinkElem.click();
		return new EditAddressPO(driver);
	}


}
