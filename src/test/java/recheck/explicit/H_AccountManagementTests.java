package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.ChangePasswordPO;
import pageobject.EditAddressPO;
import pageobject.HomePO;
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class H_AccountManagementTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder().build();
		re = new RecheckImpl(recheckOptions);

		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testLogout() {
		re.startTest("testLogout");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login().clickLogout();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(2)
	public void testChangePasswordWithIncorrectPassword() {
		re.startTest("testChangePasswordWithIncorrectPassword");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(INCORRECT_PASSWORD);
		changePasswordPO.setNewPassword(NEW_PASSWORD);
		changePasswordPO.setRepeatPassword(NEW_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(3)
	public void testChangePasswordWithPasswordMismatch() {
		re.startTest("testChangePasswordWithPasswordMismatch");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(PASSWORD);
		changePasswordPO.setNewPassword(NEW_PASSWORD);
		changePasswordPO.setRepeatPassword(NEW_INCORRECT_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(4)
	public void testChangePasswordWithShortPassword() {
		re.startTest("testChangePasswordWithShortPassword");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		ChangePasswordPO changePasswordPO = loginPO.login().goToChangePassword();

		changePasswordPO.setCurrentPassword(PASSWORD);
		changePasswordPO.setNewPassword(SHORT_PASSWORD);
		changePasswordPO.setRepeatPassword(SHORT_PASSWORD);
		changePasswordPO.clickOnChangePassword();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(5)
	public void testCorrectnessBillingAddresses() {
		re.startTest("testCorrectnessBillingAddresses");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login().goToBillingShippingInfo().goToEditBillingAddress();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(6)
	public void testEditBillingAddress() {
		re.startTest("testEditBillingAddress");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditBillingAddress();

		editAddressPO.setStreetAddress(NEW_BILLING_ADDRESS);
		editAddressPO.clickOnChangeAddress();
		editAddressPO.goToBillingShippingInfo().goToEditBillingAddress();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(7)
	public void testEditShippingAddress() {
		re.startTest("testEditShippingAddress");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		EditAddressPO editAddressPO = loginPO.login().goToBillingShippingInfo().goToEditShippingAddress();

		editAddressPO.setStreetAddress(NEW_SHIPPING_ADDRESS);
		editAddressPO.clickOnChangeAddress();
		editAddressPO.goToBillingShippingInfo().goToEditShippingAddress();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(8)
	public void testChangePassword() {
		re.startTest("testChangePassword");

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

		loginPO.waitPageToBeReady();
		loginPO.waitForLoadingOverlay();

		re.check(driver, "check");
		re.capTest();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
		re.cap();
	}

}
