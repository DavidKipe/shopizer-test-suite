package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.FooterNavigationPO;
import pageobject.RegistrationPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

	static final String FIRST_NAME = "Mario";
	static final String LAST_NAME = "Rossi";
	static final String COUNTRY = "India";
	static final String STATE_PROVINCE = "aaa";

	FooterNavigationPO footerNavPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		footerNavPO = new FooterNavigationPO(driver);
	}

	@Test
	@Order(1)
	public void testRegisterMemberWithEmptyFirstName() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

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
		RegistrationPO registrationPO = footerNavPO.goToRegister();

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
	public void testRegisterMemberWithEmptyStateProvince() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		//registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(4)
	public void testRegisterMemberWithEmptyEmail() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

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
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		//registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(6)
	public void testRegisterMemberWithEmptyRepeatPassword() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		//registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	@Test
	@Order(7)
	public void testRegisterWithPasswordMismatch() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

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
		RegistrationPO registrationPO = footerNavPO.goToRegister();

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
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(FIRST_NAME);
		registrationPO.setLastName(LAST_NAME);
		registrationPO.setCountry(COUNTRY);
		registrationPO.setStateProvince(STATE_PROVINCE);
		registrationPO.setEmail(EMAIL);
		registrationPO.setPassword(PASSWORD);
		registrationPO.setRepeatPassword(PASSWORD);
		registrationPO.createAccount();
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
