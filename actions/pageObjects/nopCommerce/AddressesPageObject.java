package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AddressesPageUI;

public class AddressesPageObject extends BasePage {
	private WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void clickToAddNewAddressButton() {
		waitForElementClickable(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void inputFirstNameAddressTextBox(String firstName) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.FIRST_NAME_AD_TEXTBOX, firstName);

	}

	public void inputLastNameAddressTextBox(String lastName) {
		waitForElementVisible(driver, AddressesPageUI.LAST_NAME_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.LAST_NAME_AD_TEXTBOX, lastName);

	}

	public void inputEmailAddressTextBox(String emailAddress) {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.EMAIL_AD_TEXTBOX, emailAddress);
	}

	public void inputCompanyAddressTextBox(String companyName) {
		waitForElementVisible(driver, AddressesPageUI.COMPANY_NAME_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.COMPANY_NAME_AD_TEXTBOX, companyName);
	}

	public void selectStateProvinceAddressDropdown(String StateProvince) {
		waitForAllsElementVisible(driver, AddressesPageUI.STATE_PROVINCE_AD_SELECT);
		selectItemInDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_AD_SELECT, StateProvince);
	}

	public void inputCityAddressTextBox(String cityName) {
		waitForElementVisible(driver, AddressesPageUI.CITY_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.CITY_AD_TEXTBOX, cityName);
	}

	public void inputAddress1TextBox(String address1) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS_1_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ADDRESS_1_AD_TEXTBOX, address1);

	}

	public void selectCountryAddressDropdown(String countryName) {
		waitForAllsElementVisible(driver, AddressesPageUI.COUNTRY_AD_SELECT);
		selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_AD_SELECT, countryName);

	}

	public void inputAddress2TextBox(String address2) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS_2_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ADDRESS_2_AD_TEXTBOX, address2);
	}

	public void inputPhoneNumberAddressTextBox(String phoneNumber) {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.PHONE_NUMBER_AD_TEXTBOX, phoneNumber);
	}

	public void inputZipCodeAddressTextBox(String zipNumber) {
		waitForElementVisible(driver, AddressesPageUI.ZIP_CODE_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.ZIP_CODE_AD_TEXTBOX, zipNumber);
	}

	public void inputFaxNumberAddressTextBox(String faxNumber) {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_AD_TEXTBOX);
		sendKeyToElement(driver, AddressesPageUI.FAX_NUMBER_AD_TEXTBOX, faxNumber);

	}

	public void clickToSaveAddressButton() {
		waitForElementVisible(driver, AddressesPageUI.SAVE_AD_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_AD_BUTTON);

	}

	public String getNameAddress() {
		waitForElementVisible(driver, AddressesPageUI.NAME_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.NAME_INFO_ADRESS);
	}

	public String getEmailddress() {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.EMAIL_INFO_ADRESS);
	}

	public String getPhoneAddress() {
		waitForElementVisible(driver, AddressesPageUI.PHONE_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.PHONE_INFO_ADRESS);
	}

	public String getFaxNumberAddress() {
		waitForElementVisible(driver, AddressesPageUI.FAX_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.FAX_INFO_ADRESS);
	}

	public String getAddress1InfoAddress() {
		waitForElementVisible(driver, AddressesPageUI.ADRESS1_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.ADRESS1_INFO_ADRESS);
	}

	public String getAddress2InfoAddress() {
		waitForElementVisible(driver, AddressesPageUI.ADRESS2_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.ADRESS2_INFO_ADRESS);
	}

	public String getCityAndZipCodeAddress() {
		waitForElementVisible(driver, AddressesPageUI.CITY_ZIP_CODE_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.CITY_ZIP_CODE_INFO_ADRESS);
	}

	public String getCountryAddress() {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_INFO_ADRESS);
		return getElementText(driver, AddressesPageUI.COUNTRY_INFO_ADRESS);
	}
	public ChangePasswordPageObject clickToChangePasswordLink() {
		waitForElementClickable(driver, AddressesPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AddressesPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}


}
