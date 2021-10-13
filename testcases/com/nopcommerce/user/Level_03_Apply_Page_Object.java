package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Apply_Page_Object {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email, password;
	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 email = "dark" + RandomInt() + "@gmail.com";
		 password = "123123";
	}

	@Test
	public void TC_01_Register_To_System() {
		
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
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
		homePage.clickToLoginButton();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputEmailTextBox(email);
		
		loginPage.inputPasswordTextBox(password);
		
		loginPage.clickToLogInButton();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int RandomInt() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
