package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StoreItemDetailPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Add to cart')]")
	WebElement addToCartBtnElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='shop']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement writeReviewBtnElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='shop']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/h1[1]")
	WebElement itemTitleNameH1Elem;

	@FindBy(how = How.XPATH, xpath = "//span[@id='productPrice']/span[1]")
	WebElement itemPriceSpanElem;

	public StoreItemDetailPO(WebDriver driver) {
		super(driver);
	}

	public void clickAddToCart() {
		addToCartBtnElem.click();
	}

	public RateItemPO clickOnWriteReview() {
		writeReviewBtnElem.click();
		return new RateItemPO(driver);
	}

	public String getItemTitleName() {
		return itemTitleNameH1Elem.getText();
	}

	public String getItemPrice() {
		return itemPriceSpanElem.getText();
	}

}
