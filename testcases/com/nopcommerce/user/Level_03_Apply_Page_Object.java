package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Apply_Page_Object {
	WebDriver driver;
	String email, password;
	String projectPath = System.getProperty("user.dir");
	

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		 email = "dark" + RandomInt() + "@gmail.com";
		 password = "123123";
	}

	@Test
	public void TC_01_Register_To_System() {
		
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		
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
		homePage.clickToLoginLink();
		
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

	public int RandomInt() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
