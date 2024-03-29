package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class E_CheckoutTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("checkout.filter")
				.build();
		re = new RecheckImpl(recheckOptions);


		homePO = new HomePO(driver);
		headerPO = new HeaderPO(driver);
	}

	@Test
	@Order(1)
	public void testCheckoutOrderWithoutAccount() {
		re.startTest("testCheckoutOrderWithoutAccount");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(2)
	public void testCheckoutOrderStorePickUp() {
		re.startTest("testCheckoutOrderStorePickUp");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(3)
	public void testCheckoutOrderDifferentShippingAddress() {
		re.startTest("testCheckoutOrderDifferentShippingAddress");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(4)
	public void testCheckoutOrderWithEmptyFirstName() {
		re.startTest("testCheckoutOrderWithEmptyFirstName");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(5)
	public void testCheckoutOrderWithEmptyLastName() {
		re.startTest("testCheckoutOrderWithEmptyLastName");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(6)
	public void testCheckoutOrderWithEmptyAddress() {
		re.startTest("testCheckoutOrderWithEmptyAddress");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(7)
	public void testCheckoutOrderWithEmptyCity() {
		re.startTest("testCheckoutOrderWithEmptyCity");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(8)
	public void testCheckoutOrderWithEmptyPostalCode() {
		re.startTest("testCheckoutOrderWithEmptyPostalCode");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(9)
	public void testCheckoutOrderWithEmptyEmail() {
		re.startTest("testCheckoutOrderWithEmptyEmail");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(10)
	public void testCheckoutOrderWithEmptyPhoneNumber() {
		re.startTest("testCheckoutOrderWithEmptyPhoneNumber");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(11)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyFirstName() {
		re.startTest("testCheckoutOrderDifferentShippingAddressWithEmptyFirstName");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(12)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyLastName() {
		re.startTest("testCheckoutOrderDifferentShippingAddressWithEmptyLastName");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(13)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyAddress() {
		re.startTest("testCheckoutOrderDifferentShippingAddressWithEmptyAddress");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(14)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyCity() {
		re.startTest("testCheckoutOrderDifferentShippingAddressWithEmptyCity");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(15)
	public void testCheckoutOrderDifferentShippingAddressWithEmptyPostalCode() {
		re.startTest("testCheckoutOrderDifferentShippingAddressWithEmptyPostalCode");

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

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(16)
	public void testCheckoutOrderLoggedIn() {
		re.startTest("testCheckoutOrderLoggedIn");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		shoppingCartPO.clickProceedToCheckout();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(17)
	public void testCheckoutOrderCreatingAccountEmptyPassword() {
		re.startTest("testCheckoutOrderCreatingAccountEmptyPassword");

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

		re.check(driver, "check");
		re.capTest();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
		re.cap();
	}

}
