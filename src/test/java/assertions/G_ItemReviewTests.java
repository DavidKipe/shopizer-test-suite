package assertions;

import data.InputData;
import driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePO;
import pageobject.LoginPO;
import pageobject.RateItemPO;
import pageobject.StoreItemsPO;

import static data.ExpectedData.*;
import static data.InputData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class G_ItemReviewTests {

	HomePO homePO;

	@BeforeEach
	public void beforeEach() {
		WebDriver driver = DriverManager.getNewDriverInstance(DriverManager.Browser.CHROME);
		driver.get("http://localhost:8080");
		homePO = new HomePO(driver);
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

		Assertions.assertEquals(ITEM_REVIEW_MSG_OPINION_REQUIRED, rateItemPO.getReviewError());
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

		Assertions.assertEquals(ITEM_REVIEW_MSG_RATING_REQUIRED, rateItemPO.getReviewError());
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

		Assertions.assertEquals(ITEM_REVIEW_MSG_SUCCESSFULLY_CREATED, rateItemPO.getStoreSuccessMessage());
		Assertions.assertEquals(REVIEW_OPINION, rateItemPO.getJustInsertedReviewOpinion());
	}

	@AfterEach
	void afterEach() {
		homePO.quitDriver();
	}

}
