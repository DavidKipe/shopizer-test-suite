package recheck.implicit;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.ChangePasswordPO;
import pageobject.EditAddressPO;
import pageobject.HomePO;
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountManagementTests {

	private WebDriver driver;

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testLogout() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login().clickLogout();
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
	}

	@Test
	@Order(5)
	public void testCorrectnessBillingAddresses() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login().goToBillingShippingInfo().goToEditBillingAddress();
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
		editAddressPO.goToBillingShippingInfo().goToEditBillingAddress();
	}

	@Test
	@Order(7)
	public void testEditShippingAddress() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditShippingAddress();

		editAddressPO.setStreetAddress(NEW_SHIPPING_ADDRESS);
		editAddressPO.clickOnChangeAddress();
		editAddressPO.goToBillingShippingInfo().goToEditShippingAddress();
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
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}