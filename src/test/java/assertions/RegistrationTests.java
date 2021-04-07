package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HeaderPO;
import pageobject.HomePO;
import pageobject.RegistrationPO;

import static data.ExpectedData.*;
import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

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

		Assertions.assertEquals(REGISTRATION_UNABLE_TO_COMPLETE, registrationPO.getCustomerErrors());
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

		Assertions.assertEquals(REGISTRATION_UNABLE_TO_COMPLETE, registrationPO.getCustomerErrors());
	}

	@Test
	@Order(4)
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

		Assertions.assertEquals(REGISTRATION_UNABLE_TO_COMPLETE, registrationPO.getCustomerErrors());
	}

	@Test
	@Order(5)
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

		Assertions.assertEquals(REGISTRATION_UNABLE_TO_COMPLETE, registrationPO.getCustomerErrors());
	}

	@Test
	@Order(6)
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

		Assertions.assertEquals(REGISTRATION_UNABLE_TO_COMPLETE, registrationPO.getCustomerErrors());
	}

	@Test
	@Order(7)
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

		Assertions.assertEquals(REGISTRATION_BOTH_PASSWORD_MUST_MATCH, registrationPO.getCustomerErrors());
	}

	@Test
	@Order(8)
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

		Assertions.assertEquals(FIRST_NAME, headerPO.getWelcomeName());
	}

	@Test
	@Order(9)
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

		Assertions.assertEquals(REGISTRATION_USER_NAME_ALREADY_EXISTS, registrationPO.getCustomerErrors());
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
