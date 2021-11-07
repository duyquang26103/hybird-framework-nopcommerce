package com.nopcommerce.myaccount;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Login_Data;
import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.nopCommerce.AddressesPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.MyProductReviewPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.ProductPageObject;
import reportConfig.ExtentTestManager;

public class MyAccount_Nopcommerce extends BaseTest {
	WebDriver driver;
	String password_01, password_02, email, emailUpdated;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		emailUpdated ="automationfc.vn123@gmail.com";
		password_01 = "123123";
		password_02 = "123456";
		

		loginPage = homePage.clickToLoginButton();

		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
//		verifyFalse(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void TC_01_Custom_Info(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 01: Click to 'My Account' Link ");
		myAccountPage = homePage.clickToMyAccountButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 02: Click to 'Gender' radio is Female");
		myAccountPage.clickToFemaleRadio();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 03: Update 'First name' textbox: "+ "Automation");
		myAccountPage.updateFirstNameTextBox("Automation");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 04: Update 'Last name' textbox "+ "FC");
		myAccountPage.updateLastNameTextBox("FC");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 05: Select 'Day' dropdown "+ "1");
		myAccountPage.selectDayDropDown("1");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 06: Select 'Month' dropdown "+ "January");
		myAccountPage.selectMonthDropDown("January");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 07: Select 'Year' dropdown "+ "1999");
		myAccountPage.selectYearDropDown("1999");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 08: Update 'Email' textbox " + "automationfc.vn123@gmail.com");
		myAccountPage.updateEmailTextBox("automationfc.vn123@gmail.com");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 09: Update 'Company' textbox " +"Automation FC");
		myAccountPage.updateCompanyTextBox("Automation FC");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 10: Click to 'Save' button ");
		myAccountPage.clickToSaveButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 11: Verify First Name equals: "+  "Automation");
		verifyEquals(myAccountPage.getFirstNameTextbox("Value"), "Automation");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 12: Verify First Name equals: "+  "FC");
		verifyEquals(myAccountPage.getLastNameTextbox("Value"), "FC");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 13: Verify Day dropdown size equals: "+  "32");
		verifyEquals(myAccountPage.getSizeDayDropDown(), 32);

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 14: Verify Month dropdown size equals: "+  "13");
		verifyEquals(myAccountPage.getSizeMonthDropDown(), 13);

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 15: Verify Year dropdown size equals: "+  "112");
		verifyEquals(myAccountPage.getSizeYearDropDown(), 112);

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 16: Verify Email equals: "+  "automationfc.vn123@gmail.com");
		verifyEquals(myAccountPage.getEmailTextbox("Value"), "automationfc.vn123@gmail.com");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 11: Verify Company Name equals: "+  "Automation FC");
		verifyEquals(myAccountPage.getCompanyTextbox("Value"), "Automation FC");

		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Address");
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 01: Click to 'Addresses' Link");
		addressesPage = myAccountPage.clickToAddressesButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 02: Click to 'Add New Address' button");
		addressesPage.clickToAddNewAddressButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 03: Update 'First name' textbox: " +"Automation");
		addressesPage.inputFirstNameAddressTextBox("Automation");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 04: Update 'Last name' textbox: " +"FC");
		addressesPage.inputLastNameAddressTextBox("FC");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 05: Update 'Email' textbox: " + "automationfc.vn@gmail.com");
		addressesPage.inputEmailAddressTextBox("automationfc.vn@gmail.com");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 06: Update 'Company' textbox: " + "Automation FC");
		addressesPage.inputCompanyAddressTextBox("Automation FC");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 07: Update 'Country' textbox: " +"82");
		addressesPage.selectCountryAddressDropdown("82");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 08: Update 'State Province' textbox: " +"0");
		addressesPage.selectStateProvinceAddressDropdown("0");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 09: Input 'City' textbox: " +"Da Nang");
		addressesPage.inputCityAddressTextBox("Da Nang");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 10: Input 'Address 1' textbox: " +"123/04 Le Lai");
		addressesPage.inputAddress1TextBox("123/04 Le Lai");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 11: Input 'Address 2' textbox: " + "234/05 Hai Phong");
		addressesPage.inputAddress2TextBox("234/05 Hai Phong");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 12: Input 'Zip Code' textbox: " + "550000");
		addressesPage.inputZipCodeAddressTextBox("550000");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 13: Input 'Phone Number' textbox: " + "0123456789");
		addressesPage.inputPhoneNumberAddressTextBox("0123456789");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 14: Input 'Fax Number' textbox: " + "0915432343");
		addressesPage.inputFaxNumberAddressTextBox("0915432343");

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 15: Click to 'Save address' button");
		addressesPage.clickToSaveAddressButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 16: Verify 'Address' equal: " + "Automation FC");
		verifyEquals(addressesPage.getNameAddress(), "Automation FC");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 17: Verify 'Email' equal: " + "Email: automationfc.vn@gmail.com");
		verifyEquals(addressesPage.getEmailddress(), "Email: automationfc.vn@gmail.com");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 18: Verify 'Phone' equal: " + "Phone number: 0123456789");
		verifyEquals(addressesPage.getPhoneAddress(), "Phone number: 0123456789");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 19: Verify 'Fax Number' equal: " + "Fax number: 0915432343");
		verifyEquals(addressesPage.getFaxNumberAddress(), "Fax number: 0915432343");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 20: Verify 'Address 1' equal: " + "123/04 Le Lai");
		verifyEquals(addressesPage.getAddress1InfoAddress(), "123/04 Le Lai");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 21: Verify 'Address 2' equal: " + "234/05 Hai Phong");
		verifyEquals(addressesPage.getAddress2InfoAddress(), "234/05 Hai Phong");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 22: Verify 'City and Zip Code' equal: " + "Da Nang, 550000");
		verifyEquals(addressesPage.getCityAndZipCodeAddress(), "Da Nang, 550000");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_02_Address - Step 23: Verify 'Country' equal: " + "Viet Nam");
		verifyEquals(addressesPage.getCountryAddress(), "Viet Nam");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Change_Password");
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 01: Click to 'My Account' Link ");
		changePasswordPage = addressesPage.clickToChangePasswordLink();

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 02: Click to 'My Account' Link ");
		changePasswordPage.inputOldPasswordTextBox(password_01);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 03: Click to 'My Account' Link ");
		changePasswordPage.inputNewPasswordTextBox(password_02);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 04: Click to 'My Account' Link ");
		changePasswordPage.inputConfirmPasswordTextBox(password_02);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 05: Click to 'My Account' Link ");
		changePasswordPage.clickToChangePasswordButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 06: Click to 'My Account' Link ");
		changePasswordPage.clickToCloseChangePasswordSuccessMessage();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 07: Click to 'My Account' Link ");
		homePage = changePasswordPage.clickToLogoutButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 08: Click to 'My Account' Link ");
		loginPage = homePage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 09: Click to 'My Account' Link ");
		loginPage.loginToSystem(emailUpdated, password_01);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 10: Verify 'message wrog password' equal: " + "The credentials provided are incorrect");
		verifyEquals(loginPage.getWrongPasswordMessage(), "The credentials provided are incorrect");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account TC_03_Change_Password - Step 11: Login to the system with email:" + emailUpdated + "& password" + password_02);
		homePage = loginPage.loginToSystem(emailUpdated, password_02);
		
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Preview_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
		ExtentTestManager.getTest().log(LogStatus.INFO, "My Account 01_Custom_Info - Step 01: Click to 'My Account' Link ");
		productPage = homePage.clickToFirstProduct();
		
		productPage.clickToAddYourReviewButton();
		
		productPage.inputReviewTitleTextBox("Good Build PC");
		
		productPage.inputReviewTextTextArea("This is the best choice for future");
		
		productPage.clickToRatingRadioButton();
		
		productPage.clickToSubmitReviewButton();

		productPage.openFooterPageByName(driver, "My account");
		
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

		myProductReviewPage = myAccountPage.clickToMyProductReviewsLink();
		
		verifyTrue(myProductReviewPage.isProductISReviewedDisplayed());
		ExtentTestManager.endTest();

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
