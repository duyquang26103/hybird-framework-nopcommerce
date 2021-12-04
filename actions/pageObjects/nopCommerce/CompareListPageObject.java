package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CompareListPageUI;

public class CompareListPageObject extends BasePage{
	private WebDriver driver;
	
	public CompareListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getNameOfProduct(String className, String productIndex) {
		int productIndexInt = Integer.parseInt(productIndex) + 1;
		waitForElementVisible(driver, CompareListPageUI.NAME_OF_PRODUCT,className, String.valueOf(productIndexInt));
		return getElementText(driver, CompareListPageUI.NAME_OF_PRODUCT,className, String.valueOf(productIndexInt));
	}
	
	public String getPriceOfProduct(String className, String productIndex) {
		int productIndexInt = Integer.parseInt(productIndex) + 1;
		waitForElementVisible(driver, CompareListPageUI.PRICE_OF_PRODUCT,className, String.valueOf(productIndexInt));
		return getElementText(driver, CompareListPageUI.PRICE_OF_PRODUCT,className, String.valueOf(productIndexInt));
	}

	public void clickOnClearListLink() {
		waitForElementClickable(driver, CompareListPageUI.CLEAR_LIST_LINK);
		clickToElement(driver, CompareListPageUI.CLEAR_LIST_LINK);
	}

	public Object getEmptyComparelistMessage() {
		waitForAllsElementVisible(driver, CompareListPageUI.EMPTY_MESSAGE);
		return getElementText(driver, CompareListPageUI.EMPTY_MESSAGE);
	}
	
}
