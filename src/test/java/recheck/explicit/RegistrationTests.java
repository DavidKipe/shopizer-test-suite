package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HeaderPO;
import pageobject.HomePO;
import pageobject.RegistrationPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;
	HeaderPO headerPO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				//.enableReportUpload()
				//.addIgnore("addowner_help_errors.filter.js")
				//.addIgnore("addowner.filter")
				.build();

		re = new RecheckImpl(recheckOptions);

		homePO = new HomePO(driver);
		headerPO = new HeaderPO(driver);
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
		re.check(driver, "check");
		re.capTest();
		homePO.quitDriver();
		re.cap();
	}

}
