package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterNavigationPO extends ShopizerPO {

	@FindBy(how = How.XPATH, xpath = "//body/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/a[1]")
	WebElement registerLinkElem;

	public FooterNavigationPO(WebDriver driver) {
		super(driver);
	}

//	void scrollToBottom() {
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	}

	public void goHome() {

	}

	public RegistrationPO goToRegister() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(registerLinkElem));
		registerLinkElem.click();
		return new RegistrationPO(driver);
	}

	public void goToSignIn() {

	}

}
