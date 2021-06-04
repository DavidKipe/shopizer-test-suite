package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopizerPO extends PageObject {

	WebDriverWait wait;

	@FindBy(how = How.XPATH, xpath = "//body/div[@class='loadingoverlay']")
	WebElement loadingOverlayElem;

	public ShopizerPO(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 5);
	}

	public void dismissCookieMessageIfPresent() {
		try {
			WebElement closeCookieMsgBtnElem = driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']"));
			closeCookieMsgBtnElem.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[@aria-label='cookieconsent']")));
		} catch (NoSuchElementException ignored) {
		}
	}

	public void waitForLoadingOverlay() {
		try {
			for (int i = 0; i < 100; i++) {
				try {
					if (!loadingOverlayElem.isDisplayed())
						return;
				} catch (StaleElementReferenceException ignored) {
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		} catch (NoSuchElementException ignored) {
		}
	}

	public void waitPageToBeReady() {
		wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

}
