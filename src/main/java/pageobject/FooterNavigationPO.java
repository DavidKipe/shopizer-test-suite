package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class FooterNavigationPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//a[text()='Register']")
	WebElement registerLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//a[text()='Sign in']")
	WebElement signInLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//span[text()='Handbags']")
	WebElement handbagsLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	WebElement logoutLinkElem;

	public FooterNavigationPO(WebDriver driver) {
		super(driver);
	}

	public RegistrationPO goToRegister() {
		clickOn(registerLinkElem);
		return new RegistrationPO(driver);
	}

	public LoginPO goToSignIn() {
		clickOn(signInLinkElem);
		return new LoginPO(driver);
	}

	public StoreItemsPO goToHandbags() {
		clickOn(handbagsLinkElem);
		return new StoreItemsPO(driver);
	}

	public HomePO clickLogout() {
		clickOn(logoutLinkElem);
		return new HomePO(driver);
	}

	void clickOn(WebElement linkElem) {
		wait.until(ExpectedConditions.visibilityOf(linkElem));
		Utils.staleRefRetry(linkElem::click);
	}

}
