package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.StoreItemDetailPO;
import pageobject.StoreItemsPO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static data.ExpectedData.*;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C_ItemsTests {

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testDisplayItems() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.waitForItemsToBeClickable();

		Assertions.assertEquals(6, storeItemsPO.getItemNamesList().size());
	}

	@Test
	@Order(2)
	public void testDisplayDetailsOfAnItem() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);

		Assertions.assertEquals(ITEM_NAME_1, storeItemDetailPO.getItemTitleName());
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE_STR, storeItemDetailPO.getItemPrice());
	}

	@Test
	@Order(3)
	public void testFilterItemsByCollection() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.filterItemsByCollection(ITEMS_COLLECTION_NAME_1);
		storeItemsPO.waitForItemsToBeClickable();
		storeItemsPO.waitForSortTransitions();

		List<String> itemNamesList = storeItemsPO.getItemNamesList();
		Collections.sort(itemNamesList);

		Assertions.assertEquals(ITEMS_COLLECTION_NAME_1_DISPLAYED_NAMES.length, itemNamesList.size());
		Assertions.assertEquals(Arrays.asList(ITEMS_COLLECTION_NAME_1_DISPLAYED_NAMES), itemNamesList);
	}

	@Test
	@Order(4)
	public void testSortItemsByName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByName();
		storeItemsPO.waitForSortTransitions();

		List<String> itemNamesList = storeItemsPO.getItemNamesList();

		boolean sorted = true;
		String previous = ""; // empty string: guaranteed to be less than or equal to any other
		for (final String current : itemNamesList) {
			if (current.compareTo(previous) < 0) {
				sorted = false;
				break;
			}
			previous = current;
		}

		Assertions.assertTrue(sorted);
	}

	@Test
	@Order(5)
	public void testSortItemsByPrice() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByPrice();
		storeItemsPO.waitForSortTransitions();

		List<Double> itemPricesList = storeItemsPO.getItemPricesList();

		boolean sorted = true;
		double previous = 0.0;
		for (final double current : itemPricesList) {
			if (current < previous) {
				sorted = false;
				break;
			}
			previous = current;
		}

		Assertions.assertTrue(sorted);
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
