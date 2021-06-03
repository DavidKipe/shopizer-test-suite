package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Utils.getElemText;

public class HeaderPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[3]/a[1]")
	WebElement shoppingCartDropdownElem;

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[3]/ul[1]/span[1]/li[2]/div[1]/a[2]")
	WebElement checkoutBtnElem;

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[2]/a[1]/span[1]/span[1]")
	WebElement welcomeNameSpanElem;

	@FindBy(how = How.XPATH, xpath = "//body/nav[1]/div[1]/ul[2]/li[2]/a[1]/span[1]")
	WebElement myAccountSpanElem;

	public HeaderPO(WebDriver driver) {
		super(driver);
	}

	public ShoppingCartPO goToCheckout() {
		dismissCookieMessageIfPresent();
		shoppingCartDropdownElem.click();
		checkoutBtnElem.click();

		return new ShoppingCartPO(driver);
	}

	public String getWelcomeName() {
		wait.until(ExpectedConditions.visibilityOf(welcomeNameSpanElem));
		return welcomeNameSpanElem.getText();
	}

	public String getMyAccountMessage() {
		return getElemText(myAccountSpanElem);
	}

}
