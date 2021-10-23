package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.MyAccountUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFemaleRadio() {
		waitForElementClickable(driver, MyAccountUI.FEMALE_RADIO);
		clickToElement(driver, MyAccountUI.FEMALE_RADIO);

	}

	public void updateFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXBOX);
		sendKeyToElement(driver, MyAccountUI.FIRST_NAME_TEXBOX, firstName);
	}

	public void updateLastNameTextBox(String lastName) {
		waitForElementVisible(driver, MyAccountUI.lAST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountUI.lAST_NAME_TEXTBOX, lastName);
	}

	public void selectDayDropDown(String day) {
		waitForAllsElementVisible(driver, MyAccountUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, MyAccountUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForAllsElementVisible(driver, MyAccountUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, MyAccountUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForAllsElementVisible(driver, MyAccountUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, MyAccountUI.YEAR_DROPDOWN, year);
	}

	public void updateEmailTextBox(String emailName) {
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountUI.EMAIL_TEXTBOX, emailName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_BUTTON);
	}

	public void updateCompanyTextBox(String companyName) {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, MyAccountUI.COMPANY_TEXTBOX, companyName);
	}

	public AddressesPageObject clickToAddressesButton() {
		waitForElementClickable(driver, MyAccountUI.ADDRESSES_BUTTON);
		clickToElement(driver, MyAccountUI.ADDRESSES_BUTTON);
		return PageGeneratorManager.getAddessesPage(driver);
	}

	

	public String getFirstNameTextbox(String attributeValue) {
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXBOX);
		return getAttributeValue(driver, MyAccountUI.FIRST_NAME_TEXBOX, attributeValue);
	}

	public String getLastNameTextbox(String attributeValue) {
		waitForElementVisible(driver, MyAccountUI.lAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.lAST_NAME_TEXTBOX, attributeValue);
	}

	public int getSizeDayDropDown() {
		waitForAllsElementVisible(driver, MyAccountUI.SIZE_DAY_DROPDOWN);
		return getElementSize(driver, MyAccountUI.SIZE_DAY_DROPDOWN);
	}

	public int getSizeMonthDropDown() {
		waitForAllsElementVisible(driver, MyAccountUI.SIZE_MONTH_DROPDOWN);
		return getElementSize(driver, MyAccountUI.SIZE_MONTH_DROPDOWN);
	}

	public int getSizeYearDropDown() {
		waitForAllsElementVisible(driver, MyAccountUI.SIZE_YEAR_DROPDOWN);
		return getElementSize(driver, MyAccountUI.SIZE_YEAR_DROPDOWN);
	}

	public String getEmailTextbox(String attributeValue) {
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.EMAIL_TEXTBOX, attributeValue);
	}

	public String getCompanyTextbox(String attributeValue) {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.COMPANY_TEXTBOX, attributeValue);
	}

	public MyProductReviewPageObject clickToMyProductReviewsLink() {
		waitForElementClickable(driver, MyAccountUI.MY_PRODUCT_REVIEWS);
		clickToElement(driver, MyAccountUI.MY_PRODUCT_REVIEWS);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}




}
