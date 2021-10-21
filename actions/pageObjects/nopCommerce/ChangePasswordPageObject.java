package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputOldPasswordTextBox(String oldPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputNewPasswordTextBox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.SAVE_CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.SAVE_CHANGE_PASSWORD_BUTTON);
	}

	public HomePageObject clickToLogoutButton() {
		sleepInSecond(10);
		scrollToElement(driver, ChangePasswordPageUI.LOGOUT_BUTTON);
		waitForElementClickable(driver, ChangePasswordPageUI.LOGOUT_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}


}
