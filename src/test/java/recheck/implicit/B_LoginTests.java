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
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(RecheckExtension.class)
public class B_LoginTests {

	HomePO homePO;
	RecheckDriver recheckDriver;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("loading-overlay.filter")
				.build();
		recheckDriver = new RecheckDriver((RemoteWebDriver) driver, recheckOptions);

		homePO = new HomePO(recheckDriver);
	}

	@Test
	@Order(1)
	public void testLoginWithIncorrectEmail() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(INCORRECT_EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		//loginPO.waitForLoadingOverlay();  // WARN: recheck implicit throws exception with this custom waiting, we can not use it
		loginPO.waitPageToBeReady();
	}

	@Test
	@Order(2)
	public void testLoginWithIncorrectPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(INCORRECT_PASSWORD);
		loginPO.login();

		//loginPO.waitForLoadingOverlay();
		loginPO.waitPageToBeReady();

		loginPO.voidClickOnBody();
	}

	@Test
	@Order(3)
	public void testLoginWithEmptyEmail() {
		LoginPO loginPO = homePO.goToSignIn();

		//loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(4)
	public void testLoginWithEmptyPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		//loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(5)
	public void testLoginWithValidData() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.dismissCookieMessageIfPresent();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		loginPO.waitPageToBeReady();
		//loginPO.waitForLoadingOverlay();

		loginPO.pageRefresh();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
