package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import FactoryEnvironment.BrowserStackFactory;
import FactoryEnvironment.Environment;
import FactoryEnvironment.GridFactory;
import FactoryEnvironment.LocalFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import utilities.DataUtil;

import utilities.DataUtil;

public class BaseTest {
    private WebDriver driver;
    public static String correctEmail;

    private DataUtil fakerData;

    protected final Log log;

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getDriverBrowsers(String envName, String serverName, String browserName, String ipAddress, String portNumber,String osName, String osVersion) {
        switch (envName) {
            case "local":
                driver = new LocalFactory(browserName).createDriver();
                break;
            case "grid":
                driver = new GridFactory(browserName,ipAddress,portNumber).createDriver();
                break;
            case "browserstack":
                driver = new BrowserStackFactory(browserName,osName,osVersion).createDriver();
                break;
            default:
                driver = new LocalFactory(browserName).createDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getEnvironmentValue(serverName));
        return driver;
    }

    protected String getEnvironmentValue(String serverName) {
        String envUrl = null;
        Environment environment = Environment.valueOf(serverName.toUpperCase());
        if (environment == Environment.DEV) {
            envUrl = "https://demo.nopcommerce.com/";
        } else if (environment == Environment.TESTING) {
            envUrl = "https://demo.nopcommerce.com/";
        } else if (environment == Environment.STAGING) {
            envUrl = "https://demo.nopcommerce.com/";
        } else if (environment == Environment.PRODUCTION) {
            envUrl = "https://demo.nopcommerce.com/";
        }
        return envUrl;
    }

    public WebDriver getWebDriver() {
        return this.driver;
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

    public void setCorrectEmail() {
        this.correctEmail = new DataUtil().getEmailAddress();
    }

    public String getCorrectEmail() {
        return this.correctEmail;
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


    protected void closeBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + osName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sleepInSecond(long timeoutInSecond) {
        try {
            Thread.sleep(timeoutInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
