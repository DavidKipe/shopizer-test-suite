package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.FooterNavigationPO;
import pageobject.StoreItemsPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemsTests {

	FooterNavigationPO footerNavPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		footerNavPO = new FooterNavigationPO(driver);
	}

	@Test
	@Order(1)
	public void testDisplayItems() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		Assertions.assertEquals(6, storeItemsPO.getItemNamesList().size());
	}

	@Test
	@Order(2)
	public void testDisplayDetailsOfAnItem() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String itemName = "Vintage courier bag";

		storeItemsPO.clickOnItemWithName(itemName);
	}

	@Test
	@Order(3)
	public void testFilterItemsByCollection() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String collectionName = "Vintage";

		storeItemsPO.filterItemsByCollection(collectionName);
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
