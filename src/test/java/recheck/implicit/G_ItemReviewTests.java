package recheck.implicit;

import data.InputData;
import de.retest.recheck.RecheckOptions;
import de.retest.web.selenium.RecheckDriver;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobject.HomePO;
import pageobject.LoginPO;
import pageobject.RateItemPO;
import pageobject.StoreItemsPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class G_ItemReviewTests {

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("loading-overlay.filter")
				.addIgnore("review-item.filter")
				.build();
		RecheckDriver recheckDriver = new RecheckDriver((RemoteWebDriver) driver, recheckOptions);

		homePO = new HomePO(recheckDriver);
	}

	@Test
	@Order(1)
	public void testReviewAnItemWithEmptyOpinion() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setStars(REVIEW_RATING_STARS);
		rateItemPO.clickOnSubmit();
	}

	@Test
	@Order(2)
	public void testReviewAnItemWithEmptyRating() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setOpinion(REVIEW_OPINION);
		rateItemPO.clickOnSubmit();
	}

	@Test
	@Order(3)
	public void testReviewAnItem() {
		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setOpinion(REVIEW_OPINION);
		rateItemPO.setStars(REVIEW_RATING_STARS);
		rateItemPO.clickOnSubmit();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
