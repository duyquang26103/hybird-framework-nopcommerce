package FactoryEnvironment;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver() {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        DesiredCapabilities capability = null;

        if (browser == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);

            FirefoxOptions options = new FirefoxOptions();
            options.merge(capability);
        } else if (browser == Browser.CHROME) {
            WebDriverManager.chromedriver().setup();
            capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WINDOWS);

            ChromeOptions options = new ChromeOptions();
            options.merge(capability);
        } else if (browser == Browser.EDGE_CHROMIUM) {
            WebDriverManager.edgedriver().setup();
            capability = DesiredCapabilities.edge();
            capability.setBrowserName("edge");
            capability.setPlatform(Platform.WINDOWS);

            EdgeOptions options = new EdgeOptions();
            options.merge(capability);
        } else if (browser == Browser.SAFARI) {
            return new SafariDriver();
        } else if (browser == Browser.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver();
        } else if (browser == Browser.H_FIREFOX) {
            WebDriverManager.chromedriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("htpp://%s:%s/ws/hub", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
