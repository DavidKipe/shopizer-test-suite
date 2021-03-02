package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.FooterNavigationPO;
import pageobject.RegistrationPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

	String firstName = "Mario";
	String lastName = "Rossi";
	String country = "India";
	String stateProvince = "aaa";
	String email = "email@email.aa";
	String password = "secretpassword";

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
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(2)
	public void testRegisterMemberWithEmptyLastName() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		//registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(3)
	public void testRegisterMemberWithEmptyStateProvince() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		//registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(4)
	public void testRegisterMemberWithEmptyEmail() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		//registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(5)
	public void testRegisterMemberWithEmptyPassword() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		//registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(6)
	public void testRegisterMemberWithEmptyRepeatPassword() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		//registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(7)
	public void testRegisterWithPasswordMismatch() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword("secretpassworf");
		registrationPO.createAccount();
	}

	@Test
	@Order(8)
	public void testRegisterMemberWithValidData() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	@Test
	@Order(9)
	public void testRegisterDuplicateMember() {
		RegistrationPO registrationPO = footerNavPO.goToRegister();

		registrationPO.setFirstName(firstName);
		registrationPO.setLastName(lastName);
		registrationPO.setCountry(country);
		registrationPO.setStateProvince(stateProvince);
		registrationPO.setEmail(email);
		registrationPO.setPassword(password);
		registrationPO.setRepeatPassword(password);
		registrationPO.createAccount();
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
