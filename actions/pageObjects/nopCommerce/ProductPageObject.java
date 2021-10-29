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



	
}
