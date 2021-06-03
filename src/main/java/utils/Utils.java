package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class Utils {

	public static <R> R staleRefRetry(Supplier<R> supplier) {
		try {
			return supplier.get();
		} catch (StaleElementReferenceException ignore) {
			return supplier.get();
		}
	}

	public static void staleRefRetry(Runnable runnable) {
		try {
			runnable.run();
		} catch (StaleElementReferenceException ignore) {
			runnable.run();
		}
	}

	public static String getElemText(WebElement webElement) {
		return staleRefRetry(webElement::getText);
	}

	public static String getElemValue(WebElement webElement) {
		return staleRefRetry(() -> webElement.getAttribute("value"));
	}

}
