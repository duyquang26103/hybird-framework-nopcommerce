package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public String getEmptyEmailMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	}

	public String getEmptyPasswordMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);

	}

	public String getInvalidEmailMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);

	}

	public String getIncorrectEmailPasswordMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);

	}

	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADRESS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADRESS_TEXTBOX, email);

	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

}
