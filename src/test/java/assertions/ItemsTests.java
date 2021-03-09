package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobject.FooterNavigationPO;
import pageobject.StoreItemsPO;

public class ItemsTests {

	FooterNavigationPO footerNavPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		footerNavPO = new FooterNavigationPO(driver);
	}

	@Test
	public void testDisplayItems() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		Assertions.assertEquals(6, storeItemsPO.getItemNamesList().size());
	}

	@Test
	public void testDisplayDetailsOfAnItem() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String itemName = "Vintage courier bag";

		storeItemsPO.clickOnItemWithName(itemName);
	}

	@Test
	public void testFilterItemsByCollection() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String collectionName = "Vintage";

		storeItemsPO.filterItemsByCollection(collectionName);
	}
}
