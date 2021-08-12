package recheck.implicit;

import de.retest.recheck.RecheckOptions;
import de.retest.web.selenium.RecheckDriver;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobject.*;

import static data.InputData.ITEM_NAMES;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class D_ShoppingCartTests {

	HomePO homePO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("loading-overlay.filter")
				.addIgnore("flaky-covered-elements.filter")
				.addIgnore("shopping-cart.filter")
				.build();
		RecheckDriver recheckDriver = new RecheckDriver((RemoteWebDriver) driver, recheckOptions);

		homePO = new HomePO(recheckDriver);
		headerPO = new HeaderPO(recheckDriver);
	}

	@Test
	@Order(1)
	public void testAddOneItemToCart() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		headerPO.goToCheckout();
	}

	@Test
	@Order(2)
	public void testAddTwoDifferentItemsToCart() {
		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = homePO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		headerPO.goToCheckout();
	}

	@Test
	@Order(3)
	public void testIncrementQuantityOfAnItemInTheCart() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.setQuantityForItem(ITEM_NAME_1, 2);

		shoppingCartPO.clickOnRecalculate();
		shoppingCartPO.waitPageToBeReady();

		shoppingCartPO.clickOnRecalculate(); // sometimes this action has no effect on the first attempt, repeating it a second time will ensure that the action is performed
		shoppingCartPO.waitPageToBeReady();

		shoppingCartPO.pageRefresh();
	}

	@Test
	@Order(4)
	public void testRemoveAnItemFromTheCart() {
		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = homePO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.removeItem("Vintage exotik carry bag");
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
