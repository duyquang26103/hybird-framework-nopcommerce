package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.CheckOutPageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class CheckOutPageObject extends BasePage {
	private WebDriver driver;

	public CheckOutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPaymentStatus() {
		waitForElementVisible(driver, CheckOutPageUI.PAYMENT_STATUS_TEXT);
		return getElementText(driver,CheckOutPageUI.PAYMENT_STATUS_TEXT);
	}
}
