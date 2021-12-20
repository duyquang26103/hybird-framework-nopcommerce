package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAddYourReviewButton() {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputReviewTitleTextBox(String reviewTitle) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
		
	}

	public void inputReviewTextTextArea(String reviewText) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA);
		sendKeyToElement(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
		
	}

	public void clickToRatingRadioButton() {
		waitForElementClickable(driver, ProductPageUI.RATING_RADIO_BUTTON);
		clickToElement(driver, ProductPageUI.RATING_RADIO_BUTTON);
		
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, ProductPageUI.SUBMIT_BUTTON);
		clickToElement(driver, ProductPageUI.SUBMIT_BUTTON);
		
	}

	public void selectProcessorDropdownByName(String processorName) {
		waitForElementVisible(driver, ProductPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, ProductPageUI.PROCESSOR_DROPDOWN, processorName);
	}

	public void selectRAMDropdown(String ramName) {
		waitForElementClickable(driver, ProductPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdownByText(driver, ProductPageUI.RAM_DROPDOWN, ramName);
	}

	public void selectHDDButton() {
		waitForElementClickable(driver, ProductPageUI.HDD_RADIO);
		clickToElement(driver, ProductPageUI.HDD_RADIO);
	}
	public void selectHDD400Button() {
		waitForElementClickable(driver, ProductPageUI.HDD_RADIO_02);
		clickToElement(driver, ProductPageUI.HDD_RADIO_02);
	}

	public boolean isAddWishlistSuccessMessageDisplayed() {
		waitForAllsElementVisible(driver,ProductPageUI.ADD_WISHLIST_MESSAGE);
		return isControlDisplayed(driver, ProductPageUI.ADD_WISHLIST_MESSAGE);
	}

	public String getNameProductText() {
		waitForElementVisible(driver,ProductPageUI.NAME_OF_PRODUCT);
		return getElementText(driver,ProductPageUI.NAME_OF_PRODUCT);
	}

	public String getPriceProductText() {
		scrollToElement(driver, ProductPageUI.PRICE_OF_PRODUCT);
		if(driver.toString().contains("chrome")){
			sleepInSecond(1);
			System.out.println(driver);
		}
		waitForElementVisible(driver,ProductPageUI.PRICE_OF_PRODUCT);
		return getElementText(driver,ProductPageUI.PRICE_OF_PRODUCT);
	}

	public boolean isAddCompareListSuccessMessageDisplayed() {
		waitForElementVisible(driver,ProductPageUI.ADD_COMPARE_MESSAGE);
		return isControlDisplayed(driver, ProductPageUI.ADD_COMPARE_MESSAGE);
	}

	public void clickOnCloseSuccessMessage() {
		waitForElementClickable(driver, ProductPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, ProductPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public boolean isProductNameIsDisplayed() {
		waitForElementVisible(driver,ProductPageUI.NAME_OF_PRODUCT);
		return isControlDisplayed(driver,ProductPageUI.NAME_OF_PRODUCT);
	}


    public String getProcessorNameDropdown() {
		waitForElementVisible(driver,ProductPageUI.PROCESSOR_DROPDOWN);
		return getSelectItemDefaultDropdown(driver,ProductPageUI.PROCESSOR_DROPDOWN);
    }

	public String getRamNameDropDown() {
		waitForElementVisible(driver,ProductPageUI.RAM_DROPDOWN);
		return getSelectItemDefaultDropdown(driver,ProductPageUI.RAM_DROPDOWN);
	}

	public String getTextHdd400NameRadio() {
		waitForElementVisible(driver,ProductPageUI.HDD_TEXT_02);
		return getElementText(driver,ProductPageUI.HDD_TEXT_02);
	}
	public String getTextHdd320NameRadio() {
		waitForElementVisible(driver,ProductPageUI.HDD_TEXT_01);
		return getElementText(driver,ProductPageUI.HDD_TEXT_01);
	}

	public void selectOSVPRadio() {
		waitForElementClickable(driver,ProductPageUI.OS_RADIO_02);
		clickToElement(driver,ProductPageUI.OS_RADIO_02);
	}
	public void selectOSVHRadio() {
		waitForElementClickable(driver,ProductPageUI.OS_RADIO_01);
		clickToElement(driver,ProductPageUI.OS_RADIO_01);
	}

	public String getTextOsVPNameRadio() {
		waitForElementVisible(driver,ProductPageUI.OS_TEXT_02);
		return getElementText(driver,ProductPageUI.OS_TEXT_02);
	}
	public String getTextOsVHNameRadio() {
		waitForElementVisible(driver,ProductPageUI.OS_TEXT_01);
		return getElementText(driver,ProductPageUI.OS_TEXT_01);
	}

	public String getTextSoftwareMOCheckbox() {
		waitForElementVisible(driver,ProductPageUI.SOFTWARE_MO_TEXT);
		return getElementText(driver,ProductPageUI.SOFTWARE_MO_TEXT);
	}

	public void clickOnSoftWareARCheckbox() {
		if(driver.toString().contains("chrome")){
			sleepInSecond(1);
		}
		waitForElementClickable(driver,ProductPageUI.SOFTWARE_AR_CHECKBOX);
		clickToElement(driver,ProductPageUI.SOFTWARE_AR_CHECKBOX);
	}

	public String getTextSoftwareARCheckbox() {
		waitForElementVisible(driver,ProductPageUI.SOFTWARE_AR_TEXT);
		return getElementText(driver,ProductPageUI.SOFTWARE_AR_TEXT);
	}

	public void clickOnSoftWareTCCheckbox() {
		if(driver.toString().contains("chrome")){
			sleepInSecond(1);
		}
		waitForElementClickable(driver,ProductPageUI.SOFTWARE_TC_CHECKBOX);
		clickToElement(driver,ProductPageUI.SOFTWARE_TC_CHECKBOX);
	}

	public String getTextSoftwareTCCheckbox() {
		waitForElementVisible(driver,ProductPageUI.SOFTWARE_TC_TEXT);
		return getElementText(driver,ProductPageUI.SOFTWARE_TC_TEXT);
	}

	public boolean isAddToCartSuccessMessageDisplayed() {
		waitForAllsElementVisible(driver,ProductPageUI.ADD_SHOPPING_CART_MESSAGE);
		return isControlDisplayed(driver, ProductPageUI.ADD_SHOPPING_CART_MESSAGE);
	}

	public String getProductQtyText() {
		waitForElementVisible(driver,ProductPageUI.PRODUCT_QTY_IN_SHOPPING_CART);
		return getElementText(driver,ProductPageUI.PRODUCT_QTY_IN_SHOPPING_CART);
	}

	public String getTextDetailInMyCartByName() {
		waitForAllsElementVisible(driver,ProductPageUI.DETAIL_IN_SHOPPING_CART);
		return getElementText(driver,ProductPageUI.DETAIL_IN_SHOPPING_CART);
	}

	public String getSubTotalPriceText() {
		waitForAllsElementVisible(driver,ProductPageUI.TOTAL_IN_SHOPPING_CART);
		return getElementText(driver,ProductPageUI.TOTAL_IN_SHOPPING_CART);
	}

	public void inputToQtyProductText(String productQty) {
		waitForAllsElementVisible(driver,ProductPageUI.PRODUCT_QTY_TEXTBOX);
		sendKeyToElement(driver,ProductPageUI.PRODUCT_QTY_TEXTBOX,productQty);
	}
}
