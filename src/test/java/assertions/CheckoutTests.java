package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
	@Order(1)
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
	@Order(2)
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
		checkoutPO.setStorePickUp();
	}

	@Test
	@Order(3)
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
	@Order(4)
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
	@Order(5)
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
	@Order(6)
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
	@Order(7)
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
	@Order(8)
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
	@Order(9)
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
	@Order(10)
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
	@Order(11)
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
	@Order(12)
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
	@Order(13)
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
	@Order(14)
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
	@Order(15)
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
	@Order(16)
	public void testCheckoutOrderLoggedIn() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		// raises StaleElementReferenceException if not calling PageFactory.initElements, we're using an element after its refresh (successfully login makes a page refresh)
		StoreItemsPO storeItemsPO = footerNavPO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.clickProceedToCheckout();
	}

	@Test
	@Order(17)
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
