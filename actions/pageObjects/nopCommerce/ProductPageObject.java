package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAddYourReviewButton() {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputReviewTitleTextBox(String reviewTitle) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
		
	}

	public void inputReviewTextTextArea(String reviewText) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA);
		sendKeyToElement(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
		
	}

	public void clickToRatingRadioButton() {
		waitForElementClickable(driver, ProductPageUI.RATING_RADIO_BUTTON);
		clickToElement(driver, ProductPageUI.RATING_RADIO_BUTTON);
		
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, ProductPageUI.SUBMIT_BUTTON);
		clickToElement(driver, ProductPageUI.SUBMIT_BUTTON);
		
	}

	public void selectRAMDropdown(String ramName) {
		waitForElementClickable(driver, ProductPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, ProductPageUI.RAM_DROPDOWN, ramName);
	}

	public void selectHDDButton() {
		waitForElementClickable(driver, ProductPageUI.HDD_RADIO);
		clickToElement(driver, ProductPageUI.HDD_RADIO);
	}

	public boolean isAddWishlistSuccessMessageDisplayed() {
		waitForAllsElementVisible(driver,ProductPageUI.ADD_WISHLIST_MESSAGE);
		return isControlDisplayed(driver, ProductPageUI.ADD_WISHLIST_MESSAGE);
	}

	public String getNameProductText() {
		waitForElementVisible(driver,ProductPageUI.NAME_OF_PRODUCT);
		return getElementText(driver,ProductPageUI.NAME_OF_PRODUCT);
	}

	public String getPriceProductText() {
		scrollToElement(driver, ProductPageUI.PRICE_OF_PRODUCT);
		waitForElementVisible(driver,ProductPageUI.PRICE_OF_PRODUCT);
		return getElementText(driver,ProductPageUI.PRICE_OF_PRODUCT);
	}

	public boolean isAddCompareListSuccessMessageDisplayed() {
		waitForElementVisible(driver,ProductPageUI.ADD_COMPARE_MESSAGE);
		return isControlDisplayed(driver, ProductPageUI.ADD_COMPARE_MESSAGE);
	}

	public void clickOnCloseSuccessMessage() {
		waitForElementClickable(driver, ProductPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, ProductPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public boolean isProductNameisDisplayed() {
		waitForElementVisible(driver,ProductPageUI.NAME_OF_PRODUCT);
		return isControlDisplayed(driver,ProductPageUI.NAME_OF_PRODUCT);
	}



	
}
