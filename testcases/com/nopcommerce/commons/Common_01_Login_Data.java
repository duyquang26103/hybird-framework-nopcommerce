package com.nopcommerce.commons;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Common_01_Login_Data extends BaseTest {
	WebDriver driver;
	String email, password;
	public static Set<Cookie> loginPageCookie;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'"); 
		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		email = RandomEmail();
		password = "123123";
		
		log.info("Common 01 - Step 01: Click to 'Register' Link ");
		registerPage = homePage.clickToRegisterPage();
		
		log.info("Common 01 - Step 02: Click to Gender Radio Button ");
		registerPage.clickToGenderRadioButton();

		log.info("Common 01 - Step 03: Input to 'First Name' textbox:" + "Abner" );
		registerPage.inputFirstNameTextBox("Abner");

		log.info("Common 01 - Step 04: Input to 'Last Name' textbox:" + "Siba" );
		registerPage.inputLastNameTextBox("Siba");

		log.info("Common 01 - Step 05: Input to 'Email textbox':" + email );
		registerPage.inputEmailTextBox(email);

		log.info("Common 01 - Step 06: Input to 'Password' textbox:" + password );
		registerPage.inputPasswordTextBox(password);

		log.info("Common 01 - Step 07: Input to 'Confirm Password' textbox:" + password );
		registerPage.inputConfirmPasswordTextBox(password);

		log.info("Common 01 - Step 08: Click on Register button");
		registerPage.clickToRegisterButton();

		log.info("Common 01 - Step 09: Verify register successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("Common 01 - Step 10: Click on 'Logout' button");
		homePage = registerPage.clickToLogOutButton();
		
		log.info("Common 01 - Step 11: Click on 'Login' Link");
		loginPage = homePage.clickToLoginButton();

		log.info("Common 01 - Step 12: Input to 'Email' textbox:" + email );
		loginPage.inputEmailTextBox(email);

		log.info("Common 01 - Step 03: Input to 'Password' textbox:" + password );
		loginPage.inputPasswordTextBox(password);

		log.info("Common 01 - Step 04: Click on 'Login' button");
		homePage = loginPage.clickToLoginButton();
 
		log.info("Common 01 - Step 09: verify login successfully");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common 01 - Step 16: verify login successfully");
		loginPageCookie = homePage.getAllCookie(driver);
		
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
		
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;

}
