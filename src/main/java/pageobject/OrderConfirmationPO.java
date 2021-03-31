package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderConfirmationPO extends FooterNavigationPO {

	@FindBy(how = How.XPATH, xpath = "//div[@id='main-content']/h1[1]")
	WebElement confirmationTitleElem;

	@FindBy(how = How.XPATH, xpath = "//body/div[@id='main-content']/div[1]/div[1]/p[2]")
	WebElement orderIdMessageElem;


	public OrderConfirmationPO(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationTitle() {
		return confirmationTitleElem.getText();
	}

	public String getOrderIdMessage() {
		return orderIdMessageElem.getText();
	}

}
