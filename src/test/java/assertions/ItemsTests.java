package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.StoreItemsPO;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemsTests {

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

		Assertions.assertEquals(6, storeItemsPO.getItemNamesList().size());
	}

	@Test
	@Order(2)
	public void testDisplayDetailsOfAnItem() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		String itemName = "Vintage courier bag";

		storeItemsPO.clickOnItemWithName(itemName);
	}

	@Test
	@Order(3)
	public void testFilterItemsByCollection() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		String collectionName = "Vintage";

		storeItemsPO.filterItemsByCollection(collectionName);
	}

	@Test
	@Order(4)
	public void testSortItemsByName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByName();
		List<String> itemNamesList = storeItemsPO.getItemNamesList();

		boolean sorted = true;
		String previous = ""; // empty string: guaranteed to be less than or equal to any other
		for (final String current: itemNamesList) {
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
		List<Float> itemPricesList = storeItemsPO.getItemPricesList();

		boolean sorted = true;
		float previous = 0.0F;
		for (final float current: itemPricesList) {
		    if (current < previous) {
			    sorted = false;
			    break;
		    }
		    previous = current;
		}

		Assertions.assertTrue(sorted);
	}

	// @AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
