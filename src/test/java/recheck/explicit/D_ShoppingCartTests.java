package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.ITEM_NAMES;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class D_ShoppingCartTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("shopping-cart.filter")
				.build();

		re = new RecheckImpl(recheckOptions);

		homePO = new HomePO(driver);
		headerPO = new HeaderPO(driver);
	}

	@Test
	@Order(1)
	public void testAddOneItemToCart() {
		re.startTest("testAddOneItemToCart");

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		headerPO.goToCheckout();

		headerPO.waitPageToBeReady();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(2)
	public void testAddTwoDifferentItemsToCart() {
		re.startTest("testAddTwoDifferentItemsToCart");

		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = homePO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		headerPO.goToCheckout();

		headerPO.waitPageToBeReady();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(3)
	public void testIncrementQuantityOfAnItemInTheCart() {
		re.startTest("testIncrementQuantityOfAnItemInTheCart");

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
		shoppingCartPO.waitPageToBeReady();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(4)
	public void testRemoveAnItemFromTheCart() {
		re.startTest("testRemoveAnItemFromTheCart");

		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = homePO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.removeItem("Vintage exotik carry bag");

		headerPO.waitPageToBeReady();

		re.check(driver, "check");
		re.capTest();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
		re.cap();
	}

}
