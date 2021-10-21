package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject loginToSystem(String email, String password) {
		inputEmailTextBox(email);
		inputPasswordTextBox(password);
		clickToLoginButton();
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getEmtyEmailMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getNoExistEmailMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_NO_EXIST_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_NO_EXIST_MESSAGE);
	}

	public String getWrongPasswordMessage() {
		waitForElementVisible(driver, LoginPageUI.WRONG_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.WRONG_PASSWORD_MESSAGE);
	}

}
