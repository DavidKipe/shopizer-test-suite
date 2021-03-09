package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class StoreItemsPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div/div[2]/a[1]/h3[1]")
	List<WebElement> itemNamesElemList;

	protected final String itemLinkSelectorByName = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div/div[2]/a[1]/h3[text()='%s']";
	protected final String collectionLinkSelector = "//body/div[@id='mainContent']/div[2]/div[1]/div[1]/div[2]/ul[2]/li/a[contains(text(),'%s')]";

	public StoreItemsPO(WebDriver driver) {
		super(driver);
	}

	public List<String> getItemNamesList() {
		return itemNamesElemList.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public StoreItemDetailPO clickOnItemWithName(String name) {
		WebElement itemLinkElem = driver.findElement(By.xpath(String.format(itemLinkSelectorByName, name)));
		itemLinkElem.click();
		return new StoreItemDetailPO(driver);
	}

	public void filterItemsByCollection(String collectionName) {
		WebElement collectionLinkElem = driver.findElement(By.xpath(String.format(collectionLinkSelector, collectionName)));
		collectionLinkElem.click();
	}

}
