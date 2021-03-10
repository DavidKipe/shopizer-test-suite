package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.*;

public class CheckoutTests {

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
	public void testCheckoutOrderWithoutAccount() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderStorePickUp() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		checkoutPO.setStorePickup();
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddress() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderWithEmptyFirstName() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		//checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyLastName() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		//checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyAddress() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		//checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyCity() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		//checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyPostalCode() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		//checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyEmail() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		//checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderWithEmptyPhoneNumber() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		//checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddressWithEmptyFirstName() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		//checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddressWithEmptyLastName() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		//checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddressWithEmptyAddress() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		//checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddressWithEmptyCity() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		//checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderDifferentShippingAddressWithEmptyPostalCode() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.clickOnCheckShipToADifferentAddress();

		checkoutPO.setShippingFirstName(SHIPPING_FIRST_NAME);
		checkoutPO.setShippingLastName(SHIPPING_LAST_NAME);
		checkoutPO.setShippingAddress(SHIPPING_ADDRESS);
		checkoutPO.setShippingCity(SHIPPING_CITY);
		checkoutPO.setShippingCountry(SHIPPING_COUNTRY);
		checkoutPO.setShippingStateProvince(SHIPPING_STATE_PROVINCE);
		//checkoutPO.setShippingPostalCode(SHIPPING_POSTAL_CODE);
	}

	@Test
	public void testCheckoutOrderLoggedIn() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.clickProceedToCheckout();
	}

	@Test
	public void testCheckoutOrderCreatingAccountEmptyPassword() {
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvince(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		checkoutPO.clickOnCreateAnAccount();
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
