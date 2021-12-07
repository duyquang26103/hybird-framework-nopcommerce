package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BasePage {
	private WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductISReviewedDisplayed() {
		waitForElementVisible(driver, MyProductReviewPageUI.PRODUCT_NAME_IS_REVIEWED);
		return isControlDisplayed(driver, MyProductReviewPageUI.PRODUCT_NAME_IS_REVIEWED);
	}
	
}
