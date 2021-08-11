package recheck.implicit;

import de.retest.recheck.RecheckOptions;
import de.retest.recheck.junit.jupiter.RecheckExtension;
import de.retest.web.selenium.RecheckDriver;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobject.HomePO;
import pageobject.StoreItemsPO;

import static data.ExpectedData.ITEMS_COLLECTION_NAME_1;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(RecheckExtension.class)
public class C_ItemsTests {

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("loading-overlay.filter")
				.addIgnore("items-sorting.filter")
				.build();
		RecheckDriver recheckDriver = new RecheckDriver((RemoteWebDriver) driver, recheckOptions);

		homePO = new HomePO(recheckDriver);
	}

	@Test
	@Order(1)
	public void testDisplayItems() {
		homePO.goToHandbags();

		//homePO.waitForLoadingOverlay();
		homePO.waitPageToBeReady();

		homePO.voidClickOnBody();
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

		storeItemsPO.voidClickOnBody();
	}

	@Test
	@Order(4)
	public void testSortItemsByName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByName();

		storeItemsPO.waitForSortTransitions();

		storeItemsPO.voidClickOnBody();
	}

	@Test
	@Order(5)
	public void testSortItemsByPrice() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		storeItemsPO.sortByPrice();

		storeItemsPO.waitForSortTransitions();

		storeItemsPO.voidClickOnBody();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
