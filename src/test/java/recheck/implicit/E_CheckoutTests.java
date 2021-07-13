package recheck.implicit;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class E_CheckoutTests {

	private WebDriver driver;

	HomePO homePO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		homePO = new HomePO(driver);
		headerPO = new HeaderPO(driver);
	}

	@Test
	@Order(1)
	public void testCheckoutOrderWithoutAccount() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(2)
	public void testCheckoutOrderStorePickUp() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		checkoutPO.setStorePickUp();
		checkoutPO.setStorePickUp(); // sometimes this action has no effect on the first attempt, repeating it a second time will ensure that the action is performed

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(3)
	public void testCheckoutOrderDifferentShippingAddress() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(4)
	public void testCheckoutOrderWithEmptyFirstName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		//checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(5)
	public void testCheckoutOrderWithEmptyLastName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		//checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(6)
	public void testCheckoutOrderWithEmptyAddress() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		//checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(7)
	public void testCheckoutOrderWithEmptyCity() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		//checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(8)
	public void testCheckoutOrderWithEmptyPostalCode() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		//checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(9)
	public void testCheckoutOrderWithEmptyEmail() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		//checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(10)
	public void testCheckoutOrderWithEmptyPhoneNumber() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		//checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(11)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyFirstName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(12)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyLastName() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(13)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyAddress() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(14)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyCity() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(15)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyPostalCode() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
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

		checkoutPO.waitForLoadingOverlay();
	}

	@Test
	@Order(16)
	public void testCheckoutOrderLoggedIn() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		// raises StaleElementReferenceException if not managed, we're using an element after its refresh (successfully login makes a page refresh)
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.clickProceedToCheckout();
	}

	@Test
	@Order(17)
	public void testCheckoutOrderCreatingAccountEmptyPassword() {
		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingFirstName(BILLING_FIRST_NAME);
		checkoutPO.setBillingLastName(BILLING_LAST_NAME);
		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingCountry(BILLING_COUNTRY);
		checkoutPO.setBillingStateProvinceSelect(BILLING_STATE_PROVINCE);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingEmail(BILLING_EMAIL);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		checkoutPO.clickOnCreateAnAccount();

		checkoutPO.waitForAccountPasswordInput();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
