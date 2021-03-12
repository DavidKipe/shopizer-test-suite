package pageobject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterNavigationPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//a[text()='Register']")
	WebElement registerLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//a[text()='Sign in']")
	WebElement signInLinkElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[contains(@class,'footer-area')]//span[text()='Handbags']")
	WebElement handbagsLinkElem;

	public FooterNavigationPO(WebDriver driver) {
		super(driver);
	}

	public RegistrationPO goToRegister() {
		WebDriverWait wait = new WebDriverWait(driver,5); // for the initial page loading
		wait.until(ExpectedConditions.visibilityOf(registerLinkElem));
		try {
			registerLinkElem.click();
		} catch(StaleElementReferenceException e) {
			registerLinkElem.click();
		}
		return new RegistrationPO(driver);
	}

	public LoginPO goToSignIn() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(signInLinkElem));
		try {
			signInLinkElem.click();
		} catch(StaleElementReferenceException e) {
			signInLinkElem.click();
		}
		return new LoginPO(driver);
	}

	public StoreItemsPO goToHandbags() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(handbagsLinkElem));
		try {
			handbagsLinkElem.click();
		} catch(StaleElementReferenceException e) {
			handbagsLinkElem.click();
		}
		return new StoreItemsPO(driver);
	}

}
