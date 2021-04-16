package recheck.explicit;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;

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
	}

	@Test
	@Order(1)
	public void testLoginWithIncorrectEmail() {
		re.startTest("testLoginWithIncorrectEmail");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(INCORRECT_EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		loginPO.waitForLoadingOverlay();
	}

	@Test
	@Order(2)
	public void testLoginWithIncorrectPassword() {
		re.startTest("testLoginWithIncorrectPassword");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(INCORRECT_PASSWORD);
		loginPO.login();

		loginPO.waitForLoadingOverlay();
	}

	@Test
	@Order(3)
	public void testLoginWithEmptyEmail() {
		re.startTest("testLoginWithEmptyEmail");

		LoginPO loginPO = homePO.goToSignIn();

		//loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(4)
	public void testLoginWithEmptyPassword() {
		re.startTest("testLoginWithEmptyPassword");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		//loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(5)
	public void testLoginWithValidData() {
		re.startTest("testLoginWithValidData");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.dismissCookieMessageIfPresent();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@AfterEach
	void afterEach() {
		re.check(driver, "check");
		re.capTest();
		homePO.quitDriver();
		re.cap();
	}

}
