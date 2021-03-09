package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[3]/a[1]")
	WebElement shoppingCartDropdownElem;

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[3]/ul[1]/span[1]/li[2]/div[1]/a[2]")
	WebElement checkoutBtnElem;

	public HeaderPO(WebDriver driver) {
		super(driver);
	}

	public ShoppingCartPO goToCheckout() {
		dismissCookieMessageIfPresent();
		shoppingCartDropdownElem.click();
		checkoutBtnElem.click();

		return new ShoppingCartPO(driver);
	}

}
