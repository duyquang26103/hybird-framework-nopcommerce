package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;
import pageUIs.nopCommerce.ShoppingCartPageUI;
import pageUIs.nopCommerce.WishlistPageUI;

public class ShoppingCartPageObject extends BasePage {
	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void clickOnRemoveButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON);
	}

	public boolean isShoppingCartEmpty() {
		waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
		return isControlDisplayed(driver,ShoppingCartPageUI.NO_DATA_MESSAGE);
	}
	public boolean isShoppingCartHeaderEmpty() {
		waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE_IN_CART_HEADER);
		return isControlDisplayed(driver,ShoppingCartPageUI.NO_DATA_MESSAGE_IN_CART_HEADER);
	}

	public ProductPageObject clickOnEditButton() {
		waitForElementClickable(driver,ShoppingCartPageUI.EDIT_BUTTON);
		clickToElement(driver,ShoppingCartPageUI.EDIT_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

	public void inputFirstProductQtyShoppingCart(String qtyValue) {
		waitForElementVisible(driver, ShoppingCartPageUI.FIRST_QTY_TEXTBOX);
		sendKeyToElement(driver,ShoppingCartPageUI.FIRST_QTY_TEXTBOX,qtyValue );
	}

	public String getTotalPriceOfFirstProduct() {
		waitForElementVisible(driver,ShoppingCartPageUI.FIRST_TOTAL_PRICE_TEXTBOX);
		return getElementText(driver,ShoppingCartPageUI.FIRST_TOTAL_PRICE_TEXTBOX);
	}

	public void clickOnAgreeCheckBox() {
		waitForElementClickable(driver, ShoppingCartPageUI.AGREE_CHECKBOX);
		clickToElement(driver, ShoppingCartPageUI.AGREE_CHECKBOX);

	}
}
