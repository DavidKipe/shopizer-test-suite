package recheck.implicit;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class B_LoginTests {

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
	public void testLoginWithIncorrectEmail() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(INCORRECT_EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		loginPO.waitForLoadingOverlay();
	}

	@Test
	@Order(2)
	public void testLoginWithIncorrectPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(INCORRECT_PASSWORD);
		loginPO.login();

		loginPO.waitForLoadingOverlay();
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
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
