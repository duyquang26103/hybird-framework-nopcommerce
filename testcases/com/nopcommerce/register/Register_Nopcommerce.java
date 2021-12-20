package com.nopcommerce.register;

import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Register_Nopcommerce extends BaseTest {
	WebDriver driver;
	String wrongEmail, firstName, lastName,password,email, undersixcharPassword,wrongPassword;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		setCorrectEmail();
		wrongEmail = "####";
		firstName = "Abner";
		lastName = "Sib";
		password = "123123";
		email = getCorrectEmail();
		undersixcharPassword = "123";
		wrongPassword = "123456";
		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		

		loginPage = homePage.clickToLoginPage();

	}

	@Test
	public void TC_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Empty_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 01_Empty_Data - Step 01: Click to 'Register' Link ");
		homePage.openHeaderPageByName(driver,"Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 01_Empty_Data - Step 02: Click to 'Register' Button ");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 01_Empty_Data - Step 01: Verify All error message is displayed");
		verifyEquals(registerPage.getErrorMessageTextByID( "FirstName-error"),"First name is required.");
		verifyEquals(registerPage.getErrorMessageTextByID( "LastName-error"),"Last name is required.");
		verifyEquals(registerPage.getErrorMessageTextByID( "Email-error"),"Email is required.");
		verifyEquals(registerPage.getErrorMessageTextByID( "Password-error"),"Password is required.");
		verifyEquals(registerPage.getErrorMessageTextByID( "ConfirmPassword-error"),"Password is required.");

		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Wrong_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Wrong_Email");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 02_Wrong_Email - Step 01: Input to Email text box is: "+wrongEmail);
		registerPage.inputEmailTextBox(wrongEmail);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 02_Wrong_Email - Step 02: Click to 'Register' Button ");
		registerPage.clickToRegisterButton();

		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Valid_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Valid_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 01: Click to Gender Radio Button ");
		registerPage.clickToGenderRadioButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 02: Input to 'First Name' textbox:" + "Abner" );
		registerPage.inputFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 03: Input to 'Last Name' textbox:" + "Siba" );
		registerPage.inputLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 04: Input to 'Email textbox':" + email );
		registerPage.inputEmailTextBox(email);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 05: Input to 'Password' textbox:" + password );
		registerPage.inputPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 06: Input to 'Confirm Password' textbox:" + password );
		registerPage.inputConfirmPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 07: Click on Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Register 03_Valid_Data - Step 08: Verify register successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Register 03_Valid_Data - Step 09: Click on 'Logout' button");
		homePage = registerPage.clickToLogOutButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 03_Valid_Data - Step 10: Click to 'Register' Link ");
		homePage.openHeaderPageByName(driver,"Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Exist_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Exist_Email");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 01: Click to Gender Radio Button ");
		registerPage.clickToGenderRadioButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 02: Input to 'First Name' textbox:" + "Abner" );
		registerPage.inputFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 03: Input to 'Last Name' textbox:" + "Siba" );
		registerPage.inputLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 04: Input to 'Email textbox':" + email );
		registerPage.inputEmailTextBox(email);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 05: Input to 'Password' textbox:" + password );
		registerPage.inputPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 06: Input to 'Confirm Password' textbox:" + password );
		registerPage.inputConfirmPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 07: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 04_Exist_Email - Step 08: Verify Exist message is displayed");
		verifyEquals(registerPage.getExistMessageText(),"The specified email already exists");
		ExtentTestManager.endTest();

	}
	@Test
	public void TC_05_Password_Less_Than_6_Char(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Password_Less_Than_6_Char");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 05_Password_Less_Than_6_Char - Step 01: Input to 'Password' textbox:" + undersixcharPassword);
		registerPage.inputPasswordTextBox(undersixcharPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 05_Password_Less_Than_6_Char - Step 02: Verify Exist message is displayed");
		verifyTrue(registerPage.isWrongPasswordMessageDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Wrong_Confirm_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Wrong_Confirm_Password");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 06_Wrong_Confirm_Password - Step 01: Input to 'Password' textbox:" + undersixcharPassword);
		registerPage.inputPasswordTextBox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 06_Wrong_Confirm_Password - Step 02: Input to 'Confirm Password' textbox:" + wrongPassword);
		registerPage.inputConfirmPasswordTextBox(wrongPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 06_Wrong_Confirm_Password - Step 03: Click on Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register 06_Wrong_Confirm_Password - Step 04: Verify No match password message is displayed");
		verifyEquals(registerPage.getErrorMessageTextByID( "ConfirmPassword-error"),"The password and confirmation password do not match.");
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
