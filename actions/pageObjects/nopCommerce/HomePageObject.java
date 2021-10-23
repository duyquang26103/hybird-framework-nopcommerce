package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isControlDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public MyAccountPageObject clickToMyAccountButton() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_BUTTON);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public ProductPageObject clickToFirstProduct() {
		waitForElementClickable(driver, HomePageUI.FIRST_PRODUCT_LINK);
		clickToElement(driver, HomePageUI.FIRST_PRODUCT_LINK);
		return PageGeneratorManager.getProductPage(driver);
	}

	public void moveToComputerLink() {
		waitForElementVisible(driver, HomePageUI.COMPUTERS_LINK);
		moveToElement(driver, HomePageUI.COMPUTERS_LINK);
		
	}

	public ComputersPageObject clickToNoteBookLink() {
		waitForElementClickable(driver, HomePageUI.NOTEBOOK_LINK);
		clickToElement(driver, HomePageUI.NOTEBOOK_LINK);
		return PageGeneratorManager.getComputerPage(driver);
	}
	
}
