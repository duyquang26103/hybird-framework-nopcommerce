package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RecentlyReviewPageUI;

public class RecentlyReviewPageObject extends BasePage{
private WebDriver driver;
	
	public RecentlyReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberofProductRecentlyViewed() {
		waitForAllsElementVisible(driver, RecentlyReviewPageUI.PRODUCT_LIST);
		return getElementSize(driver, RecentlyReviewPageUI.PRODUCT_LIST);
	}
}
