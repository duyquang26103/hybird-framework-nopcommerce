package pageObjects.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
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
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME_A_FRIST);
		return isControlDisplayed(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME_A_FRIST);
	}

	public Boolean isDataSortByZToADisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME_Z_FRIST);
		return isControlDisplayed(driver, ComputersPageUI.PRODUCTS_SORT_BY_NAME_Z_FRIST);
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
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		scrollToElement(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		return checkSixProductDisplayed(driver, ComputersPageUI.PRODUCT_DISPLAYED);
	}

	public boolean isPaginationFieldDisplayed() {
		waitForElementInvisible(driver, ComputersPageUI.PAGINATION_FIELD);
		return isControlDisplayed(driver, ComputersPageUI.PAGINATION_FIELD);
	}

	public boolean isDisplay9ProductisDisplayed() {
		waitForAllsElementVisible(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		scrollToElement(driver, ComputersPageUI.PRODUCT_DISPLAYED);
		return checkNineProductDisplayed(driver, ComputersPageUI.PRODUCT_DISPLAYED);
	}

	
	
}
