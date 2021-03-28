package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HeaderPO;
import pageobject.HomePO;
import pageobject.LoginPO;

import static data.ExpectedData.LOGIN_ERR_FAILED;
import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

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
	public void testLoginWithIncorrectEmail() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(INCORRECT_EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		Assertions.assertEquals(LOGIN_ERR_FAILED, loginPO.getLoginError());
	}

	@Test
	@Order(2)
	public void testLoginWithIncorrectPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(INCORRECT_PASSWORD);
		loginPO.login();

		Assertions.assertEquals(LOGIN_ERR_FAILED, loginPO.getLoginError());
	}

	@Test
	@Order(3)
	public void testLoginWithEmptyEmail() {
		LoginPO loginPO = homePO.goToSignIn();

		//loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		Assertions.assertEquals(LOGIN_ERR_FAILED, loginPO.getLoginError());
	}

	@Test
	@Order(4)
	public void testLoginWithEmptyPassword() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		//loginPO.setPassword(PASSWORD);
		loginPO.login();

		Assertions.assertEquals(LOGIN_ERR_FAILED, loginPO.getLoginError());
	}

	@Test
	@Order(5)
	public void testLoginWithValidData() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.dismissCookieMessageIfPresent();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();

		Assertions.assertEquals(FIRST_NAME, headerPO.getWelcomeName());
	}

	// @AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
