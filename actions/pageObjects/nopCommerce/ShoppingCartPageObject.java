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

	
}
