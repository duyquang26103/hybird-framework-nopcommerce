package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;

public class Login_Nopcommerce extends BaseTest {
	WebDriver driver;
	String random_Email, correct_Password, correct_Email,email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = new HomePageObject(driver);

		correct_Email = "automation1@gmail.vn";
		random_Email = "dark" + RandomInt() + "@gmail.com";
		correct_Password = "123123";
		email = "automation1@gmail.com";
	}

	@Test
	public void TC_01_Empty_Data() {
		homePage.clickToLoginButton();
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmtyEmailMessageDisplayed(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		loginPage.inputEmailTextBox("ahsgjhf@#!");
		loginPage.inputPasswordTextBox(correct_Password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmtyEmailMessageDisplayed(), "Wrong email");
	}

	@Test
	public void TC_03_Email_No_Exist() {
		loginPage.inputEmailTextBox(random_Email);
		loginPage.inputPasswordTextBox(correct_Password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Empty_Password_And_Correct_Email() {
		loginPage.inputEmailTextBox(random_Email);
		loginPage.inputPasswordTextBox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_05_Wrong_Password_And_Correct_Email() {
		loginPage.inputEmailTextBox(email);
		loginPage.inputPasswordTextBox("111111");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getNoExistEmailMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Valid_Data() {
		loginPage.inputEmailTextBox(email);
		loginPage.inputPasswordTextBox(correct_Password);
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

}
