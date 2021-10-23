package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.AddressesPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.MyProductReviewPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.ProductPageObject;

public class MyAccount_Nopcommerce extends BaseTest {
	WebDriver driver;
	String password_01, password_02, email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password_01 = "123123";
		password_02 = "123456";
	}

	 @Test
	public void TC_01_Custom_Info() {
		loginPage = homePage.clickToLoginButton();
		homePage = loginPage.loginToSystem(email, password_01);

		myAccountPage = homePage.clickToMyAccountButton();
		myAccountPage.clickToFemaleRadio();
		myAccountPage.updateFirstNameTextBox("Automation");
		myAccountPage.updateLastNameTextBox("FC");
		myAccountPage.selectDayDropDown("1");
		myAccountPage.selectMonthDropDown("January");
		myAccountPage.selectYearDropDown("1999");
		myAccountPage.updateEmailTextBox("automationfc.vn123@gmail.com");
		myAccountPage.updateCompanyTextBox("Automation FC");
		myAccountPage.clickToSaveButton();

		Assert.assertEquals(myAccountPage.getFirstNameTextbox("Value"), "Automation");
		Assert.assertEquals(myAccountPage.getLastNameTextbox("Value"), "FC");
		Assert.assertEquals(myAccountPage.getSizeDayDropDown(), 32);
		Assert.assertEquals(myAccountPage.getSizeMonthDropDown(), 13);
		Assert.assertEquals(myAccountPage.getSizeYearDropDown(), 112);
		Assert.assertEquals(myAccountPage.getEmailTextbox("Value"), "automationfc.vn123@gmail.com");
		Assert.assertEquals(myAccountPage.getCompanyTextbox("Value"), "Automation FC");

	}

	@Test
	public void TC_02_Address() {
		addressesPage = myAccountPage.clickToAddressesButton();
		addressesPage.clickToAddNewAddressButton();

		addressesPage.inputFirstNameAddressTextBox("Automation");
		addressesPage.inputLastNameAddressTextBox("FC");
		addressesPage.inputEmailAddressTextBox("automationfc.vn@gmail.com");
		addressesPage.inputCompanyAddressTextBox("Automation FC");
		addressesPage.selectCountryAddressDropdown("82");
		addressesPage.selectStateProvinceAddressDropdown("0");
		addressesPage.inputCityAddressTextBox("Da Nang");
		addressesPage.inputAddress1TextBox("123/04 Le Lai");
		addressesPage.inputAddress2TextBox("234/05 Hai Phong");
		addressesPage.inputZipCodeAddressTextBox("550000");
		addressesPage.inputPhoneNumberAddressTextBox("0123456789");
		addressesPage.inputFaxNumberAddressTextBox("0915432343");

		addressesPage.clickToSaveAddressButton();

		Assert.assertEquals(addressesPage.getNameAddress(), "Automation FC");
		Assert.assertEquals(addressesPage.getEmailddress(), "Email: automationfc.vn@gmail.com");
		Assert.assertEquals(addressesPage.getPhoneAddress(), "Phone number: 0123456789");
		Assert.assertEquals(addressesPage.getFaxNumberAddress(), "Fax number: 0915432343");
		Assert.assertEquals(addressesPage.getAddress1InfoAddress(), "123/04 Le Lai");
		Assert.assertEquals(addressesPage.getAddress2InfoAddress(), "234/05 Hai Phong");
		Assert.assertEquals(addressesPage.getCityAndZipCodeAddress(), "Da Nang, 550000");
		Assert.assertEquals(addressesPage.getCountryAddress(), "Viet Nam");

	}

	@Test
	public void TC_03_Change_Password() {
		changePasswordPage = addressesPage.clickToChangePasswordLink();

		changePasswordPage.inputOldPasswordTextBox(password_01);
		changePasswordPage.inputNewPasswordTextBox(password_02);
		changePasswordPage.inputConfirmPasswordTextBox(password_02);
		changePasswordPage.clickToChangePasswordButton();
		changePasswordPage.clickToChangePasswordSuccessMessage();
		homePage = changePasswordPage.clickToLogoutButton();

		loginPage = homePage.clickToLoginButton();

		loginPage.loginToSystem(email, password_01);
		Assert.assertEquals(loginPage.getWrongPasswordMessage(), "The credentials provided are incorrect");
		homePage = loginPage.loginToSystem(email, password_02);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void TC_04_Preview_Product() {
		productPage = homePage.clickToFirstProduct();
		productPage.clickToAddYourReviewButton();
		productPage.inputReviewTitleTextBox("Good Build PC");
		productPage.inputReviewTextTextArea("This is the best choice for future");
		productPage.clickToRatingRadioButton();
		productPage.clickToSubmitReviewButton();

		productPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

		myProductReviewPage = myAccountPage.clickToMyProductReviewsLink();
		Assert.assertTrue(myProductReviewPage.isProductISReviewedDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	AddressesPageObject addressesPage;
	ChangePasswordPageObject changePasswordPage;
	ProductPageObject productPage;
	MyProductReviewPageObject myProductReviewPage;
}
