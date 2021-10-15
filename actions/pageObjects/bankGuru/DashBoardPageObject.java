package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.bankGuru.DashBoardPageUI;


public class DashBoardPageObject extends BasePage {
	WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardDisplay() {
		waitForElementVisible(driver, DashBoardPageUI.MY_DASHBOARD_BANNER);
		return isControlDisplayed(driver,  DashBoardPageUI.MY_DASHBOARD_BANNER);
	}

}
