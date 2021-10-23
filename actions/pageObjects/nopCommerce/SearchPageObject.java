package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		scrollToElement(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public void inputSearchKeyword(String searchKey) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKey);

	}

	public boolean isEmptyDataMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.EMPTY_DATA_MESSAGE);
		return isControlDisplayed(driver, SearchPageUI.EMPTY_DATA_MESSAGE);
	}

	public boolean isNoDataMatchMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.NO_EXIST_DATA_MESSAGE);
		scrollToElement(driver, SearchPageUI.NO_EXIST_DATA_MESSAGE);
		return isControlDisplayed(driver, SearchPageUI.NO_EXIST_DATA_MESSAGE);
	}

	public boolean isRelativelyDataMatchDisplayed() {
		waitForElementVisible(driver, SearchPageUI.RELATIVELY_DATA);
		return isControlDisplayed(driver, SearchPageUI.RELATIVELY_DATA);
	}

	public boolean isAbsolutelyDataMatchDisplayed() {
		waitForElementVisible(driver, SearchPageUI.ABSOLUTELY_DATA);
		return isControlDisplayed(driver, SearchPageUI.ABSOLUTELY_DATA);
	}

	public void clickToAdvancedSearchCheckBox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_CHECKBOX);
		clickToElement(driver, SearchPageUI.ADVANCED_CHECKBOX);
	}

	public void selectCategoryDropdown(String categoryName) {
		waitForAllsElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, SearchPageUI.CATEGORY_DROPDOWN, categoryName);
		
	}

	public void unCheckToAutomaticallySearchCheckBox() {
		waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		clickToElementByJS(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	public void checkToAutomaticallySearchCheckBox() {
		waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);

	}

	public boolean isAvancedSearchDataMatchDisplayed() {
		waitForElementVisible(driver, SearchPageUI.ADVANCED_SEARCH_MATCH_DATA);
		scrollToElement(driver, SearchPageUI.ADVANCED_SEARCH_MATCH_DATA);
		return isControlDisplayed(driver, SearchPageUI.ADVANCED_SEARCH_MATCH_DATA);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);
	}

	public void selectManufacturerDropdown(String manufacturerName) {
		waitForAllsElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
		
	}

}
