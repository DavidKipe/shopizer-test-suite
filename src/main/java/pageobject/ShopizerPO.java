package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopizerPO extends PageObject {

	public ShopizerPO(WebDriver driver) {
		super(driver);
	}

	public void dismissCookieMessageIfPresent() {
		try {
			WebElement closeCookieMsgBtnElem = driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']"));
			closeCookieMsgBtnElem.click();
		} catch (NoSuchElementException ignored) {
		}
	}

}
