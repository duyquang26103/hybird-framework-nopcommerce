package FactoryEnvironment;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalFactory {
    private WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver createDriver() {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        if (browser == Browser.CHROME) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser == Browser.EDGE_CHROMIUM) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("plesae input correct browser name");
        }

        return driver;
    }
}
