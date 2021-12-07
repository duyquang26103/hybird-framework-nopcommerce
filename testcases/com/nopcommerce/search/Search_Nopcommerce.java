package com.nopcommerce.search;

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
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;
import reportConfig.ExtentTestManager;

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
		
		loginPage = homePage.clickToLoginPage();
		
		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToImgNopcommerce();
		verifyFalse(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void TC_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Empty_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 01_Empty_Data - Step 01: Open 'Search' link at footer");
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 01_Empty_Data - Step 02: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 01_Empty_Data - Step 03: Verify Empty message is Displayed");
		Assert.assertTrue(searchPage.isEmptyDataMessageDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Data_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Data_Not_Exist");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 02_Data_Not_Exist - Step 01: Input to 'Search' Textboxt: 'Macbook Pro 2015'");
		searchPage.inputSearchKeyword("Macbook Pro 2015");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 02_Data_Not_Exist - Step 02: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 02_Data_Not_Exist - Step 03: Verify No Data Match message is Displayed");
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Relatively_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Relatively_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 03_Relatively_Data - Step 01: Input to 'Search' Textboxt: 'Lenovo'");
		searchPage.inputSearchKeyword("Lenovo");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 03_Relatively_Data - Step 02: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 03_Relatively_Data - Step 03: Verify Relatively Data Match message is Displayed");
		Assert.assertTrue(searchPage.isRelativelyDataMatchDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Absolutely_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Absolutely_Data");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 04_Absolutely_Data - Step 01: Input to 'Search' Textboxt: 'Thinkpad X1 Carbon'");
		searchPage.inputSearchKeyword("Thinkpad X1 Carbon");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 04_Absolutely_Data - Step 02: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 04_Absolutely_Data - Step 03: Verify Absolutely Data Match message is Displayed");
		Assert.assertTrue(searchPage.isAbsolutelyDataMatchDisplayed());
	}

	@Test
	public void TC_05_Advanced_Parent_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Advanced_Parent_Categories");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 05_Advanced_Parent_Categories - Step 01: Input to 'Search' Textboxt: 'Thinkpad X1 Carbon'");
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 05_Advanced_Parent_Categories - Step 02: Click to 'Advanced Search' Checkbox ");
		searchPage.clickToAdvancedSearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 05_Advanced_Parent_Categories - Step 03: Select categories dropdown is: 'Computers'");
		searchPage.selectCategoryDropdown("Computers");
		// searchPage.unCheckToAutomaticallySearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 05_Advanced_Parent_Categories - Step 04: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 05_Advanced_Parent_Categories - Step 05: Verify No Data Match message is Displayed");
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Advanced_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Advanced_Sub_Categories");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 01: Open 'Search' link at footer");
		searchPage.openFooterPageByName(driver, "Search");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 01: Input to 'Search' Textboxt: 'Apple MacBook Pro'");
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 02: Click to 'Advanced Search' Checkbox ");
		searchPage.clickToAdvancedSearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 03: Select categories dropdown is: 'Computers'");
		searchPage.selectCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 04: Click to 'Automatically Search' Checkbox ");
		searchPage.checkToAutomaticallySearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 05: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 06_Advanced_Sub_Categories - Step 06: Verify Avanced Search Data Match message is Displayed");
		Assert.assertTrue(searchPage.isAvancedSearchDataMatchDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_07_Advanced_Incorrect_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_07_Advanced_Incorrect_Manufacturer");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 01:Open 'Search' link at footer");
		searchPage.openFooterPageByName(driver, "Search");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 02: Input to 'Search' Textboxt: 'Apple MacBook Pro'");
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 03: Click to 'Advanced Search' Checkbox ");
		searchPage.clickToAdvancedSearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 04: Select categories dropdown is: 'Computers'");
		searchPage.selectCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 05: Click to 'Automatically Search' Checkbox ");
		searchPage.unCheckToAutomaticallySearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 06: Select Manufacturer dropdown is: 'HP'");
		searchPage.selectManufacturerDropdown("HP");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 07: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 07_Advanced_Incorrect_Manufacturer - Step 08: Verify No Data Match message is Displayed");
		Assert.assertTrue(searchPage.isNoDataMatchMessageDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_08_Advanced_Correct_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_08_Advanced_Correct_Manufacturer");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 01:Open 'Search' link at footer");
		searchPage.openFooterPageByName(driver, "Search");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 02: Input to 'Search' Textboxt: 'Apple MacBook Pro'");
		searchPage.inputSearchKeyword("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 03: Click to 'Advanced Search' Checkbox ");
		searchPage.clickToAdvancedSearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 04: Select categories dropdown is: 'Computers'");
		searchPage.selectCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 05: Click to 'Automatically Search' Checkbox ");
		searchPage.checkToAutomaticallySearchCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 06: Select Manufacturer dropdown is: 'Apple'");
		searchPage.selectManufacturerDropdown("Apple");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 07: Click to 'Search' button ");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Search 08_Advanced_Correct_Manufacturer - Step 08: Verify Avanced Search Data Match message is Displayed");
		Assert.assertTrue(searchPage.isAvancedSearchDataMatchDisplayed());
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
}
