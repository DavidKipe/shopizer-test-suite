package assertions;

import data.InputData;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.ITEM_NAMES;
import static data.InputData.ITEM_NAME_1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingCartTests {

	FooterNavigationPO footerNavPO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		footerNavPO = new FooterNavigationPO(driver);
		headerPO = new HeaderPO(driver);
	}

	@Test
	@Order(1)
	public void testAddOneItemToCart() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		headerPO.goToCheckout();
	}

	@Test
	@Order(2)
	public void testAddTwoDifferentItemsToCart() {
		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = footerNavPO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		headerPO.goToCheckout();
	}

	@Test
	@Order(3)
	public void testIncrementQuantityOfAnItemInTheCart() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.setQuantityForItem(ITEM_NAME_1, 2);
		shoppingCartPO.clickOnRecalculate();
	}

	@Test
	@Order(4)
	public void testRemoveAnItemFromTheCart() {
		StoreItemsPO storeItemsPO;

		for (String itemName : ITEM_NAMES) {
			storeItemsPO = footerNavPO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.removeItem("Vintage exotik carry bag");
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
