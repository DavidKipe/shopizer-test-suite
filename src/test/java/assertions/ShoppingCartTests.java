package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;

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
	public void testAddOneItemToCart() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String itemName = "Vintage courier bag";

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
		storeItemDetailPO.clickAddToCart();
		headerPO.goToCheckout();
	}

	@Test
	public void testAddTwoDifferentItemsToCart() {
		StoreItemsPO storeItemsPO;

		String[] itemNames = {"Vintage courier bag", "Vintage exotik carry bag"};

		for (String itemName : itemNames) {
			storeItemsPO = footerNavPO.goToHandbags();
			StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
			storeItemDetailPO.clickAddToCart();
		}

		headerPO.goToCheckout();
	}

	@Test
	public void testIncrementQuantityOfAnItemInTheCart() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		String itemName = "Vintage courier bag";

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(itemName);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.setQuantityForItem(itemName, 2);
		shoppingCartPO.clickOnRecalculate();
	}

	@Test
	public void testRemoveAnItemFromTheCart() {
		StoreItemsPO storeItemsPO;

		String[] itemNames = {"Vintage courier bag", "Vintage exotik carry bag"};

		for (String itemName : itemNames) {
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
