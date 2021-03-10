package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Recalculate')]")
	WebElement recalculateBtnElem;

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtnElem;

	protected final String itemRowSelectorByName = "//tbody/tr/td[1]/div[1]/div[2]/span/strong[text()='%s']/ancestor::tr/";
	protected final String itemQuantityInputPart = "td[2]/input";
	protected final String removeItemPart = "td[5]//a";

	public ShoppingCartPO(WebDriver driver) {
		super(driver);
	}

	public void setQuantityForItem(String itemName, int quantity) {
		WebElement quantityInputElem = driver.findElement(By.xpath(String.format(itemRowSelectorByName, itemName) + itemQuantityInputPart));
		quantityInputElem.clear();
		quantityInputElem.sendKeys(Integer.toString(quantity));
	}

	public void removeItem(String itemName) {
		WebElement removeBtnElem = driver.findElement(By.xpath(String.format(itemRowSelectorByName, itemName) + removeItemPart));
		removeBtnElem.click();
	}

	public void clickOnRecalculate() {
		recalculateBtnElem.click();
	}

	public CheckoutPO clickProceedToCheckout() {
		proceedToCheckoutBtnElem.click();
		return new CheckoutPO(driver);
	}

}
