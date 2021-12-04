package com.nopcommerce.login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import reportConfig.ExtentTestManager;

public class Login_Nopcommerce extends BaseTest {
	WebDriver driver;
	String randomEmail, wrongEmail, wrongPassword, correctPassword, correctEmail;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		correctEmail = getCorrectEmail();
		randomEmail = "dark" + RandomInt() + "@gmail.com";
		correctPassword = "123123";
		
		wrongEmail = "ahsgjhf@#!";
		wrongPassword = "111111";
	}

	@Test
	public void TC_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Empty_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login 01_Empty_Data - Step 01: Click to Login link ");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Login 01_Empty_Data - Step 02: Click to Login button ");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 01_Empty_Data - Step 03: Verify warning message is Displayed: 'Please enter your email'");
		Assert.assertEquals(loginPage.getEmtyEmailMessageDisplayed(), "Please enter your email");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Invalid_Email");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 02_Invalid_Email - Step 01: Input to Email textbox: " + wrongEmail);
		loginPage.inputEmailTextBox(wrongEmail);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 02_Invalid_Email - Step 02: Input to Password textbox: " + correctPassword);
		loginPage.inputPasswordTextBox(correctPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Login 02_Invalid_Email - Step 03: Click to Login link ");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 02_Invalid_Email - Step 04: Verify warning message is Displayed: 'Wrong email'");
		Assert.assertEquals(loginPage.getEmtyEmailMessageDisplayed(), "Wrong email");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Email_No_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Email_No_Exist");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 03_Email_No_Exist - Step 01: Input to Email textbox: " + randomEmail);
		loginPage.inputEmailTextBox(randomEmail);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 03_Email_No_Exist - Step 02: Input to Password textbox: " + correctPassword);
		loginPage.inputPasswordTextBox(correctPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Login 03_Email_No_Exist - Step 03: Click to Login link ");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 03_Email_No_Exist - Step 04: Verify warning message is Displayed: 'Login was unsuccessful. Please correct the errors and try again.\nNo customer account found'");
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Empty_Password_And_Correct_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Empty_Password_And_Correct_Email");
		ExtentTestManager.getTest().log(LogStatus.INFO,	"Login 04_Empty_Password_And_Correct_Email - Step 01: Input to Email textbox: " + randomEmail);
		loginPage.inputEmailTextBox(randomEmail);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 04_Empty_Password_And_Correct_Email - Step 02: Input to Password textbox:' '");
		loginPage.inputPasswordTextBox("");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 04_Empty_Password_And_Correct_Email - Step 03: Click to Login link ");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 04_Empty_Password_And_Correct_Email - Step 04: Verify warning message is Displayed: 'Login was unsuccessful. Please correct the errors and try again.\nNo customer account found'");
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Wrong_Password_And_Correct_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Wrong_Password_And_Correct_Email");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 05_Wrong_Password_And_Correct_Email - Step 01: Input to Email textbox: "+correctEmail);
		loginPage.inputEmailTextBox(correctEmail);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 05_Wrong_Password_And_Correct_Email - Step 02: Input to Password textbox: "+wrongPassword);
		loginPage.inputPasswordTextBox(wrongPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 05_Wrong_Password_And_Correct_Email - Step 03: Click to Login link ");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 05_Wrong_Password_And_Correct_Email - Step 04: Verify warning message is Displayed: 'Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect'");
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Valid_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Valid_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 06_Valid_Data - Step 01: Input to Email textbox: "+correctEmail);
		loginPage.inputEmailTextBox(correctEmail);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 06_Valid_Data - Step 02: Input to Password textbox: "+correctPassword);
		loginPage.inputPasswordTextBox(correctPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 06_Valid_Data - Step 03: Click to Login link ");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Login 06_Valid_Data - Step 03: Verify slide bar is Displayed ");
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;

}
