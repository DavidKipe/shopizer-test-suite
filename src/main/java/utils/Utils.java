package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class Utils {

	public static <R> R staleRefRetry(Supplier<R> supplier) {
		return staleRefRetry(supplier, 10, 20);
	}

	public static void staleRefRetry(Runnable runnable) {
		staleRefRetry(runnable, 10, 20);
	}

	public static void staleRefRetry(Runnable runnable, int numberOfAttempts, int millisecondWait) {
		StaleElementReferenceException staleElementRefExc = new StaleElementReferenceException("null");

		int i;
		for (i = 0; i < numberOfAttempts; ++i) {
			try {
				runnable.run();
				break;
			} catch (StaleElementReferenceException e) {
				staleElementRefExc = e;
			}

			try {
				Thread.sleep(millisecondWait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (numberOfAttempts == i)
			throw staleElementRefExc;
	}

	public static <R> R staleRefRetry(Supplier<R> supplier, int numberOfAttempts, int millisecondWait) {
		StaleElementReferenceException staleElementRefExc = new StaleElementReferenceException("null");

		int i;
		for (i = 0; i < numberOfAttempts; ++i) {
			try {
				return supplier.get();
			} catch (StaleElementReferenceException e) {
				staleElementRefExc = e;
			}

			try {
				Thread.sleep(millisecondWait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		throw staleElementRefExc;
	}

	public static String getElemText(WebElement webElement) {
		return staleRefRetry(webElement::getText);
	}

	public static String getElemValue(WebElement webElement) {
		return staleRefRetry(() -> webElement.getAttribute("value"));
	}

}
