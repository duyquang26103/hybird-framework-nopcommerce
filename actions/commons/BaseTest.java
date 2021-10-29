package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	String emailLogin;
	private final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, EDGE;
	}

	public WebDriver getDriverBrowsers(String browserName) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + getFlash("browserDrivers") + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE) {
			System.setProperty("webdriver.edge.driver", projectPath + getFlash("browserDrivers") + "msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + getFlash("browserDrivers") + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("plesae input correct browser name");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public WebDriver getDriverBrowsers(String browserName, String appURL) {

		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + getFlash("browserDrivers") + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE) {
			System.setProperty("webdriver.edge.driver", projectPath + getFlash("browserDrivers") + "msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + getFlash("browserDrivers") + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("plesae input correct browser name");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().window().maximize();
		return driver;

	}

	private String getFlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;

	}
	
	public int RandomInt() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	public String RandomEmail() {
		Random random = new Random();
		return "darken" + random.nextInt(9999) + "@gmail.com";
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
	
	

}
