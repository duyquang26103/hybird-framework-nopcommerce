package com.bankguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.bankGuru.DashBoardPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;

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
	public void TC_01_EmptyData() {
		driver.get("http://live.demoguru99.com/index.php/");
		homePage = new HomePageObject(driver);

		homePage.clickToAccountButton();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);

		loginPage.inputEmailTextbox("qwrqwr");
		loginPage.inputPasswordTextBox(password);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getInvalidEmailMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.inputEmailTextbox(email);
		loginPage.inputPasswordTextBox("1414");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void TC_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);

		loginPage.inputEmailTextbox(email);
		loginPage.inputPasswordTextBox(password);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.inputEmailTextbox("dam@gmail.com");
		loginPage.inputPasswordTextBox("3wer124");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getIncorrectEmailPasswordMessage(), "Invalid login or password.");

	}

	@Test
	public void TC_06_Valid_Email_Password() {
		loginPage.refreshCurrentPage(driver);

		loginPage.inputEmailTextbox("dam@gmail.com");
		loginPage.inputPasswordTextBox("123456");

		loginPage.clickToLoginButton();
		
		Assert.assertTrue(dashboardPage.isDashBoardDisplay());


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
	DashBoardPageObject dashboardPage;

}
