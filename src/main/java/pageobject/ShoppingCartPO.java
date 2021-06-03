package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;


public class ShoppingCartPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Recalculate')]")
	WebElement recalculateBtnElem;

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtnElem;

	protected final String itemRowSelectorByName = "//tbody/tr/td[1]/div[1]/div[2]/span/strong[text()='%s']/ancestor::tr/";
	protected final String itemQuantityInputPart = "td[2]/input";
	protected final String removeItemPart = "td[5]//a";

	@FindBy(how = How.XPATH, xpath = "//tbody/tr/td[1]/div[1]/div[2]/span[1]/strong[1]")
	List<WebElement> itemNamesElemList;

	@FindBy(how = How.XPATH, xpath = "//body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[3]/strong[1]")
	List<WebElement> itemPricesElemList;

	@FindBy(how = How.XPATH, xpath = "//body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[4]/strong[1]")
	List<WebElement> itemTotalPartialPricesElemList;

	@FindBy(how = How.XPATH, xpath = "//tbody/tr[2]/td[1]/span[1]")
	WebElement totalPriceSpanElem;

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

	public List<String> getItemNamesList() {
		return Utils.staleRefRetry(() -> itemNamesElemList.stream().map(WebElement::getText).collect(Collectors.toList()));
	}

	public List<String> getItemPricesStringList() {
		return Utils.staleRefRetry(() -> itemPricesElemList.stream().map(WebElement::getText).collect(Collectors.toList()));
	}

	public List<Double> getItemPricesList() {
		return Utils.staleRefRetry(() -> itemPricesElemList.stream().map(itemPriceElem -> Double.parseDouble(itemPriceElem.getText().substring(1))).collect(Collectors.toList()));
	}

	public List<String> getItemTotalPartialPricesStringList() {
		return Utils.staleRefRetry(() ->itemTotalPartialPricesElemList.stream().map(WebElement::getText).collect(Collectors.toList()));
	}

	public List<Double> getItemTotalPartialPricesList() {
		return Utils.staleRefRetry(() -> itemTotalPartialPricesElemList.stream().map(itemPriceElem -> Double.parseDouble(itemPriceElem.getText().substring(1))).collect(Collectors.toList()));
	}

	public double getTotalPrice() {
		return Utils.staleRefRetry(() -> Double.parseDouble(totalPriceSpanElem.getText().substring(1)));
	}

}
