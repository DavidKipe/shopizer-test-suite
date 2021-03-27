package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RateItemPO extends FooterNavigationPO {

	public enum RatingStars {
		HALF, ONE,
		ONE_AND_A_HALF,	TWO,
		TWO_AND_A_HALF, THREE,
		THREE_AND_A_HALF, FOUR,
		FOUR_AND_A_HALF, FIVE
	}

	@FindBy(how = How.XPATH, xpath = "//textarea[@id='description']")
	WebElement opinionInputElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='review']/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement starOneElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='review']/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/img[2]")
	WebElement starTwoElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='review']/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/img[3]")
	WebElement starThreeElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='review']/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/img[4]")
	WebElement starFourElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='review']/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/img[5]")
	WebElement starFiveElem;

	@FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Submit')]")
	WebElement submitBtnElem;

	public RateItemPO(WebDriver driver) {
		super(driver);
	}

	public void setOpinion(String opinion) {
		opinionInputElem.clear();
		opinionInputElem.sendKeys(opinion);
	}

	public void setStars(RatingStars stars) {
		WebElement starElem;
		switch (stars) {
			case HALF:
			case ONE:
				starElem = starOneElem;
				break;
			case ONE_AND_A_HALF:
			case TWO:
				starElem = starTwoElem;
				break;
			case TWO_AND_A_HALF:
			case THREE:
				starElem = starThreeElem;
				break;
			case THREE_AND_A_HALF:
			case FOUR:
				starElem = starFourElem;
				break;
			case FOUR_AND_A_HALF:
			case FIVE:
				starElem = starFiveElem;
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + stars);
		}

		int xOffset = 0;
		switch (stars) {
			case HALF:
			case ONE_AND_A_HALF:
			case TWO_AND_A_HALF:
			case THREE_AND_A_HALF:
			case FOUR_AND_A_HALF:
				xOffset = -5;
				break;
			case ONE:
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
				xOffset = 5;
				break;
		}

		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(starElem).moveByOffset(xOffset, 0).click().build().perform();
	}

	public void clickOnSubmit() {
		submitBtnElem.click();
	}

}
