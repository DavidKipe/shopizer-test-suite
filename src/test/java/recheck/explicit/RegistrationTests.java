package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.RegistrationPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

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
	public void testRegisterMemberWithEmptyFirstName() {
		re.startTest("testRegisterMemberWithEmptyFirstName");

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
		re.startTest("testRegisterMemberWithEmptyLastName");

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
		re.startTest("testRegisterMemberWithEmptyEmail");

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
		re.startTest("testRegisterMemberWithEmptyPassword");

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
		re.startTest("testRegisterMemberWithEmptyRepeatPassword");

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
		re.startTest("testRegisterWithPasswordMismatch");

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
		re.startTest("testRegisterMemberWithValidData");

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
		re.startTest("testRegisterDuplicateMember");

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
		re.check(driver, "check");
		re.capTest();
		homePO.quitDriver();
		re.cap();
	}

}
