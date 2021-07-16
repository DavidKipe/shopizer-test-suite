package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import java.util.Arrays;
import java.util.HashSet;

import static data.ExpectedData.*;
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
		homePO = new HomePO(driver);
		headerPO = new HeaderPO(driver);
	}

	@Test
	@Order(1)
	public void testAddOneItemToCart() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();

		shoppingCartPO.waitPageToBeReady();

		Assertions.assertEquals(ITEM_NAME_1, shoppingCartPO.getItemNamesList().get(0));
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE_STR, shoppingCartPO.getItemPricesStringList().get(0));
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE, shoppingCartPO.getTotalPrice());
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

		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();

		shoppingCartPO.waitPageToBeReady();

		HashSet<String> itemNamesSet = new HashSet<>(shoppingCartPO.getItemNamesList());
		for (String itemName : ITEM_NAMES)
			if (!itemNamesSet.contains(itemName))
				Assertions.fail("Items '" + itemName + "' is not listed in the Shopping Cart");

		Assertions.assertEquals(Arrays.stream(ITEMS_PRICES).reduce(0.0, Double::sum), shoppingCartPO.getTotalPrice());
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
		shoppingCartPO.waitPageToBeReady();

		Assertions.assertEquals(ITEM_NAME_1, shoppingCartPO.getItemNamesList().get(0));
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE * 2, shoppingCartPO.getItemTotalPartialPricesList().get(0));
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE * 2, shoppingCartPO.getTotalPrice());
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

		shoppingCartPO.waitPageToBeReady();

		Assertions.assertEquals(ITEM_NAME_1, shoppingCartPO.getItemNamesList().get(0));
		Assertions.assertEquals(1, shoppingCartPO.getItemNamesList().size());
		Assertions.assertEquals(ITEMS_ITEM_1_PRICE, shoppingCartPO.getTotalPrice());
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
