package pageObjects.nopCommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.ComputersPageUI;

import pageUIs.nopCommerce.HomePageUI;


public class ComputersPageObject extends BasePage {
	private WebDriver driver;

	public ComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortBySelectBox(String sortByName) {
		waitForAllsElementVisible(driver, ComputersPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, ComputersPageUI.SORT_BY_DROPDOWN, sortByName);
	}

	public Boolean isDataSortByAToZDisplayed() {
		sleepInSecond(2);
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME);

		List<WebElement> AllProductName = getWebElements(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME);
		List<String> productsNameText = new ArrayList<String>();

		for (WebElement textItem : AllProductName) {
			productsNameText.add(textItem.getText());
		}
		List<String> productsNameTextcloned = new ArrayList<String>(productsNameText);
		Collections.sort(productsNameTextcloned);
		return productsNameText.equals(productsNameTextcloned);
	}

	public Boolean isDataSortByZToADisplayed() {
		sleepInSecond(2);
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME);

		List<WebElement> AllProductName = getWebElements(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME);
		List<String> productsNameText = new ArrayList<String>();

		for (WebElement textItem : AllProductName) {
			productsNameText.add(textItem.getText());
		}

		List<String> productsNameTextcloned = new ArrayList<String>(productsNameText);
		Collections.sort(productsNameTextcloned);
		Collections.reverse(productsNameTextcloned);

		return productsNameText.equals(productsNameTextcloned);
	}

	public boolean isDataSortByLowToHighDisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_PRICE);
		return checkElementSortLowToHigh(driver, ComputersPageUI.PRODUCTS_SORT_BY_PRICE);

	}

	public boolean isDataSortByHighToLowDisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_PRICE);
		return checkElementSortHighToLow(driver, ComputersPageUI.PRODUCTS_SORT_BY_PRICE);
	}

	public void selectDisplaySelectBox(String displayNumber) {
		waitForAllsElementVisible(driver, ComputersPageUI.DISPLAY_DROPDOWN);
		scrollToElement(driver, ComputersPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, ComputersPageUI.DISPLAY_DROPDOWN, displayNumber);

	}

	public boolean isDisplay3ProductisDisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		return checkThreeProductDisplayed(driver, ComputersPageUI.PRODUCT_DISPLAYED);
	}

	public boolean isNextPaginationDisplayed() {
		waitForElementVisible(driver, ComputersPageUI.NEXT_PAGINATION);
		return isControlDisplayed(driver, ComputersPageUI.NEXT_PAGINATION);
	}

	public void clickToPage2Pagination() {
		sleepInSecond(5);
		waitForElementClickable(driver, ComputersPageUI.PAGE_TWO_PAGINATION);
		scrollToElement(driver, ComputersPageUI.PAGE_TWO_PAGINATION);
		clickToElement(driver, ComputersPageUI.PAGE_TWO_PAGINATION);

	}

	public boolean isPreviousPaginationDisplayed() {
		waitForElementVisible(driver, ComputersPageUI.PREVIOUS_PAGINATION);
		return isControlDisplayed(driver, ComputersPageUI.PREVIOUS_PAGINATION);
	}

	public boolean isDisplay6ProductisDisplayed() {
		waitForElementVisible(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		scrollToElement(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		return checkSixProductDisplayed(driver, ComputersPageUI.PRODUCT_DISPLAYED);
	}

	public boolean isPaginationFieldUnDisplayed() {
		sleepInSecond(2);
		return isControlUnDisplayed(driver, ComputersPageUI.PAGINATION_FIELD);
	}

	public boolean isDisplay9ProductisDisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		scrollToElement(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		return checkNineProductDisplayed(driver, ComputersPageUI.PRODUCT_DISPLAYED);
	}


	public void clickToProductByIndex(String string) {
		// TODO Auto-generated method stub
		

	public ProductPageObject clickToProductByIndex(String productIndex) {
		scrollToElement(driver, ComputersPageUI.PRODUCT_NAME_BY_INDEX, productIndex);
		waitForElementClickable(driver, ComputersPageUI.PRODUCT_NAME_BY_INDEX, productIndex);
		clickToElement(driver, ComputersPageUI.PRODUCT_NAME_BY_INDEX, productIndex);
		return PageGeneratorManager.getProductPage(driver);

	}

	
	
}
