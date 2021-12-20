package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password = "123123";
	}

	@Test
	public void TC_01_Register_To_System() {

		registerPage = homePage.clickToRegisterPage();

		registerPage.clickToGenderRadioButton();

		registerPage.inputFirstNameTextBox("Abner");

		registerPage.inputLastNameTextBox("Siba");

		registerPage.inputEmailTextBox(email);

		registerPage.inputPasswordTextBox(password);

		registerPage.inputConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		homePage = registerPage.clickToLogOutButton();

	

	}

	@Test
	public void TC_02_Login_To_System() {
		loginPage = homePage.clickToLoginPage();

		loginPage.inputEmailTextBox(email);

		loginPage.inputPasswordTextBox(password);

		homePage = loginPage.clickToLoginButton();

		

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
