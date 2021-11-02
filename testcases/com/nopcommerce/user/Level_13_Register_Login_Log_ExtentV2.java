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

public class Level_13_Register_Login_Log_ExtentV2 extends BaseTest {
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
		registerPage = homePage.clickToRegisterPage();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 02: Click to Gender Radio Button ");
		registerPage.clickToGenderRadioButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 03: Input to 'First Name' textbox:" + "Abner" );
		registerPage.inputFirstNameTextBox("Abner");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 04: Input to 'Last Name' textbox:" + "Siba" );
		registerPage.inputLastNameTextBox("Siba");

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 05: Input to 'Email textbox':" + email );
		registerPage.inputEmailTextBox(email);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 06: Input to 'Password' textbox:" + password );
		registerPage.inputPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 07: Input to 'Confirm Password' textbox:" + password );
		registerPage.inputConfirmPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 08: Click on Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 09: Verify register successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 10: Click on 'Logout' button");
		homePage = registerPage.clickToLogOutButton();
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Login_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 01: Click on 'Login' Link");
		loginPage = homePage.clickToLoginButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 02: Input to 'Email' textbox:" + email );
		loginPage.inputEmailTextBox(email);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 03: Input to 'Password' textbox:" + password );
		loginPage.inputPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 04: Click on 'Login' button");
		homePage = loginPage.clickToLoginButton();
 
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 02_Login - Step 09: verify login successfully");
		verifyFalse(homePage.isHomePageSliderDisplayed());
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
