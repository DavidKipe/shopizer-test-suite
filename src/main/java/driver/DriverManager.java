package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

	public enum Browser {
		CHROME, FIREFOX
	}

	// parameters //
	public static final int TIMEOUT_SECS = 0;                                   // implicit waiting timeout in seconds for Selenium
	public static final String DRIVER_FOLDER_NAME = "/home/david/.webdriver/";  // local folder of the web drivers
	public static final boolean HEADLESS = true;                                // headless or not


	public static final String CHROME_DRIVER_UNIX = "chromedriver";
	public static final String FIREFOX_DRIVER_UNIX = "geckodriver";

	public static final String CHROME_DRIVER_WIN = "chromedriver.exe";
	public static final String FIREFOX_DRIVER_WIN = "geckodriver.exe";

	static final boolean WINDOWS_OS = System.getProperty("os.name").toLowerCase().contains("windows");

	static void setChromeWebDriver() { // CHROME / CHROMIUM
		if (WINDOWS_OS)
			System.setProperty("webdriver.chrome.driver", DRIVER_FOLDER_NAME + CHROME_DRIVER_WIN);
		else
			System.setProperty("webdriver.chrome.driver", DRIVER_FOLDER_NAME + CHROME_DRIVER_UNIX);
	}

	static void setFirefoxWebDriver() { // FIREFOX
		if (WINDOWS_OS)
			System.setProperty("webdriver.gecko.driver", DRIVER_FOLDER_NAME + FIREFOX_DRIVER_WIN);
		else
			System.setProperty("webdriver.gecko.driver", DRIVER_FOLDER_NAME + FIREFOX_DRIVER_UNIX);
	}

	public static WebDriver getNewDriverInstance(Browser browser) {
		WebDriver driver;

		switch (browser) {
			case CHROME:
				setChromeWebDriver();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.setHeadless(HEADLESS);
				driver = new ChromeDriver(chromeOptions);
				break;
			case FIREFOX:
				setFirefoxWebDriver();
				FirefoxOptions firefoxOpts = new FirefoxOptions();
				firefoxOpts.addArguments("--window-size=1920,1080");
				firefoxOpts.setHeadless(HEADLESS);
				driver = new FirefoxDriver(firefoxOpts);
				break;
			default:
				throw new IllegalArgumentException();
		}

		driver.manage().timeouts().implicitlyWait(TIMEOUT_SECS, TimeUnit.SECONDS);
		return driver;
	}

}
