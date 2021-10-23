package com.nopcommerce.search;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;

public class Search_Nopcommerce extends BaseTest {
	WebDriver driver;
	String password_01, password_02, email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password_01 = "123123";
		password_02 = "123456";
	}

	 @Test
	public void TC_01_Empty_Data() {
		loginPage = homePage.clickToLoginButton();
		homePage = loginPage.loginToSystem(email, password_01);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isEmptyDataMessageDisplayed());
		
	}

	@Test
	public void TC_02_Data_Not_Exist() {
		searchPage.inputSearchKeyword("Macbook Pro 2015");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
		
	}

	@Test
	public void TC_03_Relatively_Data() {
		
		searchPage.inputSearchKeyword("Lenovo");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isRelativelyDataMatchDisplayed());
		
	}

	@Test
	public void TC_04_Absolutely_Data() {
		searchPage.inputSearchKeyword("Thinkpad X1 Carbon");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isAbsolutelyDataMatchDisplayed());
	}
	
	@Test
	public void TC_05_Advanced_Parent_Categories() {
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		searchPage.clickToAdvancedSearchCheckBox();
		searchPage.selectCategoryDropdown("Computers");
		//searchPage.unCheckToAutomaticallySearchCheckBox();
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
	}
	
	@Test
	public void TC_06_Advanced_Sub_Categories() {
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		searchPage.clickToAdvancedSearchCheckBox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticallySearchCheckBox();
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isAvancedSearchDataMatchDisplayed());
	}
	
	@Test
	public void TC_07_Advanced_Incorrect_Manufacturer() {
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		searchPage.clickToAdvancedSearchCheckBox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.unCheckToAutomaticallySearchCheckBox();
		searchPage.selectManufacturerDropdown("HP");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
	}
	
	@Test
	public void TC_08_Advanced_Correct_Manufacturer() {
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		searchPage.clickToAdvancedSearchCheckBox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticallySearchCheckBox();
		searchPage.selectManufacturerDropdown("Apple");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isAvancedSearchDataMatchDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
}
