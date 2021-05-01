package recheck.implicit;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.StoreItemsPO;

import static data.ExpectedData.ITEMS_COLLECTION_NAME_1;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemsTests {

	private WebDriver driver;

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testDisplayItems() {
		homePO.goToHandbags();

		homePO.waitForLoadingOverlay();
	}

	@Test
	@Order(2)
	public void testDisplayDetailsOfAnItem() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
	}

	@Test
	@Order(3)
	public void testFilterItemsByCollection() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.filterItemsByCollection(ITEMS_COLLECTION_NAME_1);

		storeItemsPO.waitForItemsToBeClickable();
		storeItemsPO.waitForSortTransitions();
	}

	@Test
	@Order(4)
	public void testSortItemsByName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByName();

		storeItemsPO.waitForSortTransitions();
	}

	@Test
	@Order(5)
	public void testSortItemsByPrice() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByPrice();

		storeItemsPO.waitForSortTransitions();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
