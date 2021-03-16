package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopizerPO extends PageObject {

	WebDriverWait wait;

	public ShopizerPO(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,5);
	}

	public void dismissCookieMessageIfPresent() {
		try {
			WebElement closeCookieMsgBtnElem = driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']"));
			closeCookieMsgBtnElem.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[@aria-label='cookieconsent']")));
		} catch (NoSuchElementException ignored) {
		}
	}

}
