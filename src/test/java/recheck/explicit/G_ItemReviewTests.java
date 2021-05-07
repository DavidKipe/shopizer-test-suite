package recheck.explicit;

import data.InputData;
import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.LoginPO;
import pageobject.RateItemPO;
import pageobject.StoreItemsPO;

import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class G_ItemReviewTests {

	private WebDriver driver;
	private Recheck re;

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");

		RecheckOptions recheckOptions = RecheckOptions.builder()
				.addIgnore("review-item.filter")
				.build();
		re = new RecheckImpl(recheckOptions);

		homePO = new HomePO(driver);
	}

	@Test
	@Order(1)
	public void testReviewAnItemWithEmptyOpinion() {
		re.startTest("testReviewAnItemWithEmptyOpinion");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setStars(REVIEW_RATING_STARS);
		rateItemPO.clickOnSubmit();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(2)
	public void testReviewAnItemWithEmptyRating() {
		re.startTest("testReviewAnItemWithEmptyRating");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setOpinion(REVIEW_OPINION);
		rateItemPO.clickOnSubmit();

		re.check(driver, "check");
		re.capTest();
	}

	@Test
	@Order(3)
	public void testReviewAnItem() {
		re.startTest("testReviewAnItem");

		LoginPO loginPO = homePO.goToSignIn();

		loginPO.setEmail(EMAIL);
		loginPO.setPassword(PASSWORD);
		StoreItemsPO storeItemsPO = loginPO.login().goToHandbags();

		RateItemPO rateItemPO = storeItemsPO.clickOnItemWithName(InputData.ITEM_NAME_1).clickOnWriteReview();
		rateItemPO.setOpinion(REVIEW_OPINION);
		rateItemPO.setStars(REVIEW_RATING_STARS);
		rateItemPO.clickOnSubmit();

		re.check(driver, "check");
		re.capTest();
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
		re.cap();
	}

}
