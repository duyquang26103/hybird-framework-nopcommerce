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
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = new HomePageObject(driver);

		email = "automation1@gmail.com";
		password = "123123";
	}

	@Test
	public void TC_01_Register_To_System() {

		homePage.clickToRegisterPage();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToGenderRadioButton();

		registerPage.inputFirstNameTextBox("Abner");

		registerPage.inputLastNameTextBox("Siba");

		registerPage.inputEmailTextBox(email);

		registerPage.inputPasswordTextBox(password);

		registerPage.inputConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogOutButton();

		homePage = new HomePageObject(driver);

	}

	@Test
	public void TC_02_Login_To_System() {
		homePage.clickToLoginPage();

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailTextBox(email);

		loginPage.inputPasswordTextBox(password);

		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

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
