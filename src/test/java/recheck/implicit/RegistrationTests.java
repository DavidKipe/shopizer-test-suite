package recheck.implicit;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.RegistrationPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

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
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
