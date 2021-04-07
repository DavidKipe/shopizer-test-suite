package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static data.ExpectedData.*;
import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountManagementTests {

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
	public void testLogout() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login().clickLogout();

		Assertions.assertEquals(HEADER_MY_ACCOUNT_MESSAGE_NO_LOGIN, headerPO.getMyAccountMessage());
	}

	@Test
	@Order(2)
	public void testChangePasswordWithIncorrectPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(INCORRECT_PASSWORD);
		changePasswordPO.setNewPassword(NEW_PASSWORD);
		changePasswordPO.setRepeatPassword(NEW_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		Assertions.assertEquals(CHANGE_PASSWORD_MSG_INVALID_PASSWORD, changePasswordPO.getPasswordError());
	}

	@Test
	@Order(3)
	public void testChangePasswordWithPasswordMismatch() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(PASSWORD);
		changePasswordPO.setNewPassword(NEW_PASSWORD);
		changePasswordPO.setRepeatPassword(NEW_INCORRECT_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		Assertions.assertEquals(CHANGE_PASSWORD_MSG_MISMATCH, changePasswordPO.getFormError());
		Assertions.assertFalse(changePasswordPO.isChangePasswordButtonEnabled());
	}

	@Test
	@Order(4)
	public void testChangePasswordWithShortPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(PASSWORD);
		changePasswordPO.setNewPassword(SHORT_PASSWORD);
		changePasswordPO.setRepeatPassword(SHORT_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		Assertions.assertEquals(CHANGE_PASSWORD_MSG_SHORT_PASSWORD, changePasswordPO.getFormError());
		Assertions.assertFalse(changePasswordPO.isChangePasswordButtonEnabled());
	}

	@Test
	@Order(5)
	public void testCorrectnessBillingAddresses() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditBillingAddress();

		Assertions.assertEquals(FIRST_NAME, editAddressPO.getFirstName());
		Assertions.assertEquals(LAST_NAME, editAddressPO.getLastName());
		Assertions.assertEquals(BILLING_ADDRESS, editAddressPO.getAddress());
		Assertions.assertEquals(BILLING_CITY, editAddressPO.getCity());
		Assertions.assertEquals(COUNTRY, editAddressPO.getCountry());
		Assertions.assertEquals(STATE_PROVINCE, editAddressPO.getStateProv());
		Assertions.assertEquals(BILLING_POSTAL_CODE, editAddressPO.getPostalCode());
		Assertions.assertEquals(BILLING_PHONE_NUMBER, editAddressPO.getPhoneNumber());
	}

	@Test
	@Order(6)
	public void testEditBillingAddress() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditBillingAddress();

		editAddressPO.setStreetAddress(NEW_BILLING_ADDRESS);
		editAddressPO.clickOnChangeAddress();
		editAddressPO = editAddressPO.goToBillingShippingInfo().goToEditBillingAddress();

		Assertions.assertEquals(NEW_BILLING_ADDRESS, editAddressPO.getAddress());	}

	@Test
	@Order(7)
	public void testEditShippingAddress() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditShippingAddress();

		editAddressPO.setStreetAddress(NEW_SHIPPING_ADDRESS);
		editAddressPO.clickOnChangeAddress();
		editAddressPO = editAddressPO.goToBillingShippingInfo().goToEditShippingAddress();

		Assertions.assertEquals(NEW_SHIPPING_ADDRESS, editAddressPO.getAddress());
	}

	@Test
	@Order(8)
	public void testChangePassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(PASSWORD);
		changePasswordPO.setNewPassword(NEW_PASSWORD);
		changePasswordPO.setRepeatPassword(NEW_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		loginPO = changePasswordPO.clickLogout().goToSignIn();
		loginPO.setEmail(EMAIL);
		loginPO.setPassword(NEW_PASSWORD);
		loginPO.login();

		Assertions.assertEquals(FIRST_NAME, headerPO.getWelcomeName());
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
