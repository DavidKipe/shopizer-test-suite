package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.ExpectedData.*;
import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubmitOrderTests {

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
	public void testSubmitOrder() {
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
		OrderConfirmationPO orderConfirmationPO = checkoutPO.clickSubmitOrder();

		Assertions.assertEquals(ORDER_CONFIRMATION_TITLE_OK, orderConfirmationPO.getConfirmationTitle());
		Assertions.assertTrue(orderConfirmationPO.getOrderIdMessage().matches(ORDER_CONFIRMATION_MSG_ID_REGEX));
	}

	@Test
	@Order(2)
	public void testSubmitOrderWithInvalidEmail() {
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
		checkoutPO.setBillingEmail(EMAIL); // this is the registration email, it is already used
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		checkoutPO.clickSubmitOrder();

		Assertions.assertEquals(CHECKOUT_ERROR_GENERIC, checkoutPO.getCheckoutError());
	}

	@Test
	@Order(3)
	public void testSubmitOrderLoggedIn() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		StoreItemsPO storeItemsPO = homePO.goToHandbags();

		StoreItemDetailPO storeItemDetailPO = storeItemsPO.clickOnItemWithName(ITEM_NAME_1);
		storeItemDetailPO.clickAddToCart();
		ShoppingCartPO shoppingCartPO = headerPO.goToCheckout();
		CheckoutPO checkoutPO = shoppingCartPO.clickProceedToCheckout();

		checkoutPO.setBillingAddress(BILLING_ADDRESS);
		checkoutPO.setBillingCity(BILLING_CITY);
		checkoutPO.setBillingPostalCode(BILLING_POSTAL_CODE);
		checkoutPO.setBillingPhoneNumber(BILLING_PHONE_NUMBER);
		OrderConfirmationPO orderConfirmationPO = checkoutPO.clickSubmitOrder();

		Assertions.assertEquals(ORDER_CONFIRMATION_TITLE_OK, orderConfirmationPO.getConfirmationTitle());
		Assertions.assertTrue(orderConfirmationPO.getOrderIdMessage().matches(ORDER_CONFIRMATION_MSG_ID_REGEX));
	}

	// @AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
