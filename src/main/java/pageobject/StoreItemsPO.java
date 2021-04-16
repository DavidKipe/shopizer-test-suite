package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class StoreItemsPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div/div[2]/a[1]/h3[1]")
	List<WebElement> itemNamesElemList;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div/div[2]/h4[1]/span[1]")
	List<WebElement> itemPricesElemList;

	@FindBy(how = How.XPATH, xpath = "//select[@id='filter']")
	WebElement sortBySelectElem;

	protected final String itemLinkSelectorByName = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div/div[2]/a[1]/h3[text()='%s']";
	protected final String collectionLinkSelector = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[2]/ul[2]/li/a[contains(text(),'%s')]";

	public StoreItemsPO(WebDriver driver) {
		super(driver);
	}

	public List<String> getItemNamesList() {
		return itemNamesElemList.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<Double> getItemPricesList() {
		return itemPricesElemList.stream().map(itemPriceElem -> Double.parseDouble(itemPriceElem.getText().substring(1))).collect(Collectors.toList());
	}

	public StoreItemDetailPO clickOnItemWithName(String name) {
		By itemLinkSelectorByNameXpath = By.xpath(String.format(itemLinkSelectorByName, name));
		wait.until(ExpectedConditions.elementToBeClickable(itemLinkSelectorByNameXpath));
		WebElement itemLinkElem = driver.findElement(itemLinkSelectorByNameXpath);
		itemLinkElem.click();
		return new StoreItemDetailPO(driver);
	}

	public void filterItemsByCollection(String collectionName) {
		WebElement collectionLinkElem = driver.findElement(By.xpath(String.format(collectionLinkSelector, collectionName)));
		collectionLinkElem.click();
	}

	public void sortByName() {
		Select countrySelect = new Select(sortBySelectElem);
		countrySelect.selectByVisibleText("Name");
	}

	public void sortByPrice() {
		Select countrySelect = new Select(sortBySelectElem);
		countrySelect.selectByVisibleText("Price");
	}

	public void waitForItemsToBeClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")));
	}

	public void waitForSortTransitions() {
		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]")),"style", "")); // new wait method
	}

}
