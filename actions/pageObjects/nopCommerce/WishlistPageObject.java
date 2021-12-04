package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;
import pageUIs.nopCommerce.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	private WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPrductAddSuccessDisplayed() {
		waitForElementVisible(driver, WishlistPageUI.NAME_PRODUCT_DISPLAYED);
		return isControlDisplayed(driver, WishlistPageUI.NAME_PRODUCT_DISPLAYED);
	}

	public void clickToURLSharing() {
		waitForElementClickable(driver, WishlistPageUI.SHARING_URL_LINK);
		clickToElement(driver, WishlistPageUI.SHARING_URL_LINK);
	}

	public String getProductNameInUrl() {
		waitForAllsElementVisible(driver, WishlistPageUI.WISHLIST_OF_USER_TEXT);
		return getElementText(driver, WishlistPageUI.WISHLIST_OF_USER_TEXT);
	}

	public void clickToAddToCartCheckBox() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}

	public String getWishlistEmpty() {
		waitForAllsElementVisible(driver, WishlistPageUI.QTY_OF_WISHLIST);
		return getElementText(driver, WishlistPageUI.QTY_OF_WISHLIST);
	}

	public String getShoppingCartisAdded() {
		waitForAllsElementVisible(driver, WishlistPageUI.QTY_OF_SHOPPING_CART);
		return getElementText(driver, WishlistPageUI.QTY_OF_SHOPPING_CART);
	}

	public void clickOnRemoveButton() {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_BUTTON);
		clickToElement(driver, WishlistPageUI.REMOVE_BUTTON);
		
	}

	public String getEmptyWishlistMessage() {
		waitForAllsElementVisible(driver, WishlistPageUI.EMPTY_WISHLIST_LABEL);
		return getElementText(driver, WishlistPageUI.EMPTY_WISHLIST_LABEL);
	}
}
