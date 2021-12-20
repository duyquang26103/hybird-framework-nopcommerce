package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Login_Data;
import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_14_Login_Log_Share_State extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl, Method method) {
		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = RandomEmail();
		password = "123123";

		loginPage = homePage.clickToLoginPage();

		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);
		
		homePage = PageGeneratorManager.getHomePage(driver);
//		verifyFalse(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void TC_01_ABC(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_ABC");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_ACB(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_ACB");
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
