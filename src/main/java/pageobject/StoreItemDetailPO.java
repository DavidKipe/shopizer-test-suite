package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StoreItemDetailPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Add to cart')]")
	WebElement addToCartBtnElem;

	public StoreItemDetailPO(WebDriver driver) {
		super(driver);
	}

	public void clickAddToCart() {
		addToCartBtnElem.click();
	}

}
