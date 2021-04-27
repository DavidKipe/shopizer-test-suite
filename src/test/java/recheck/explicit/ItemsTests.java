package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
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
	private Recheck re;

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder().build();
		re = new RecheckImpl(recheckOptions);

		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testDisplayItems() {
		re.startTest("testDisplayItems");

		homePO.goToHandbags();

		homePO.waitForLoadingOverlay();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(2)
	public void testDisplayDetailsOfAnItem() {
		re.startTest("testDisplayDetailsOfAnItem");

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.clickOnItemWithName(ITEM_NAME_1);

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(3)
	public void testFilterItemsByCollection() {
		re.startTest("testFilterItemsByCollection");

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.filterItemsByCollection(ITEMS_COLLECTION_NAME_1);

		storeItemsPO.waitForItemsToBeClickable();
		storeItemsPO.waitForSortTransitions();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(4)
	public void testSortItemsByName() {
		re.startTest("testSortItemsByName");

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByName();

		storeItemsPO.waitForSortTransitions();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(5)
	public void testSortItemsByPrice() {
		re.startTest("testSortItemsByPrice");

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByPrice();

		storeItemsPO.waitForSortTransitions();

		re.check(driver, "check");
		re.capTest();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
		re.cap();
	}

}
