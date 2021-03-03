package assertions;

import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.FooterNavigationPO;
import pageobject.LoginPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

	FooterNavigationPO footerNavPO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		footerNavPO = new FooterNavigationPO(driver);
	}

	@Test
	@Order(1)
	public void testLoginWithIncorrectEmail() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(INCORRECT_EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(2)
	public void testLoginWithIncorrectPassword() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(INCORRECT_PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(3)
	public void testLoginWithEmptyEmail() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		//loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(4)
	public void testLoginWithEmptyPassword() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(EMAIL);
		//loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	@Test
	@Order(5)
	public void testLoginWithValidData() {
		LoginPO loginPO = footerNavPO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		loginPO.login();
	}

	// @AfterEach
	void afterEach() {
		footerNavPO.quitDriver();
	}

}
