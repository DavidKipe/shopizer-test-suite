package recheck.implicit;

import de.retest.recheck.RecheckOptions;
import de.retest.recheck.junit.jupiter.RecheckExtension;
import de.retest.web.selenium.RecheckDriver;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobject.HomePO;
import pageobject.RegistrationPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(RecheckExtension.class)
public class A_RegistrationTests {

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("flaky-covered-elements.filter")
				.build();
		RecheckDriver recheckDriver = new RecheckDriver((RemoteWebDriver) driver, recheckOptions);

		homePO = new HomePO(recheckDriver);
	}

	@Test
	@Order(1)
	public void testRegisterMemberWithEmptyFirstName() {
		RegistrationPO registrationPO = homePO.goToRegister();

		//registrationPO.setFirstName(firstName);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(2)
	public void testRegisterMemberWithEmptyLastName() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		//registrationPO.setLastName(lastName);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(3)
	public void testRegisterMemberWithEmptyEmail() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		//registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(4)
	public void testRegisterMemberWithEmptyPassword() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL_2);
		//registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(5)
	public void testRegisterMemberWithEmptyRepeatPassword() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL_3);
		registrationPO.setPassword(PASSWORD);
		//registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(6)
	public void testRegisterWithPasswordMismatch() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(INCORRECT_PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(7)
	public void testRegisterMemberWithValidData() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.dismissCookieMessageIfPresent();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(8)
	public void testRegisterDuplicateMember() {
		RegistrationPO registrationPO = homePO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
