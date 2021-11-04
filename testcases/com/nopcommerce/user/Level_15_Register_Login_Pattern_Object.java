package com.nopcommerce.user;

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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = RandomEmail();
		password = "123123";
	}

	@Test
	public void TC_01_Register_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		homePage.openHeaderPageByName(driver,"Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 02: Click to Gender Radio Button ");
		registerPage.clickToGenderRadioButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 03: Input to 'First Name' textbox:" + "Abner" );
		registerPage.inputTextBoxByID(driver,"Abner","FirstName");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 04: Input to 'Last Name' textbox:" + "Siba" );
		registerPage.inputTextBoxByID(driver,"Siba","LastName");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 05: Input to 'Email textbox':" + email );
		registerPage.inputTextBoxByID(driver,email,"Email");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 06: Input to 'Password' textbox:" + password );
		registerPage.inputTextBoxByID(driver,password,"Password");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 07: Input to 'Confirm Password' textbox:" + password );
		registerPage.inputTextBoxByID(driver,password,"ConfirmPassword");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 08: Click on Register button");
		registerPage.clickOnButtonByName(driver,"Register");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 09: Verify register successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 10: Click on 'Logout' button");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Login_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 01: Click on 'Login' Link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 02: Input to 'Email' textbox:" + email );
		loginPage.inputTextBoxByID(driver,email,"Email");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 03: Input to 'Password' textbox:" + password );
		loginPage.inputTextBoxByID(driver,password,"Password");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 04: Click on 'Login' button");
		homePage = loginPage.clickToLoginButton();
 
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 09: verify login successfully");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;

}
