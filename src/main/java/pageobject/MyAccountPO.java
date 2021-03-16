package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	WebElement billingShippingInfoBtnElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	WebElement changePasswordBtnElem;

	public MyAccountPO(WebDriver driver) {
		super(driver);
	}

	public ChangePasswordPO goToChangePassword() {
		wait.until(ExpectedConditions.visibilityOf(changePasswordBtnElem));

		changePasswordBtnElem.click();
		return new ChangePasswordPO(driver);
	}

	public BillingAndShippingAddressesInfoPO goToBillingShippingInfo() {
		wait.until(ExpectedConditions.visibilityOf(billingShippingInfoBtnElem));

		billingShippingInfoBtnElem.click();
		return new BillingAndShippingAddressesInfoPO(driver);
	}

}
