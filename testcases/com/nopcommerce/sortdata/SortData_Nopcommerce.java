package com.nopcommerce.sortdata;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.nopCommerce.ComputersPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import reportConfig.ExtentTestManager;

public class SortData_Nopcommerce extends BaseTest {
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
	public void TC_01_Sort_Name_A_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Sort_Name_A_Z");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 01_Sort_Name_A_Z - Step 01: Move to Coputer Menu");
		homePage.moveToComputerLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 01_Sort_Name_A_Z - Step 02: Click to NoteBooks subMenu ");
		computersPage = homePage.clickToNoteBookLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 01_Sort_Name_A_Z - Step 03: Select 'Sort By' dropdown is: 'Name: A to Z'");
		computersPage.selectSortBySelectBox("Name: A to Z");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 01_Sort_Name_A_Z - Step 04: Verify Data is sorted by name A to Z ");
		verifyTrue(computersPage.isDataSortByAToZDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Sort_Name_Z_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Sort_Name_Z_A");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 02_Sort_Name_Z_A - Step 01: Select 'Sort By' dropdown is: 'Name: Z to A'");
		computersPage.selectSortBySelectBox("Name: Z to A");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 02_Sort_Name_Z_A - Step 02: Verify Data is sorted by name Z to A ");
		Assert.assertTrue(computersPage.isDataSortByZToADisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High(Method method) {	
		ExtentTestManager.startTest(method.getName(), "TC_03_Sort_Price_Low_To_High");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 03_Sort_Price_Low_To_High - Step 01: Select 'Sort By' dropdown is: 'Price: Low to High'");
		computersPage.selectSortBySelectBox("Price: Low to High");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 03_Sort_Price_Low_To_High - Step 02: Verify Data is sorted by Price Low to High ");
		verifyTrue(computersPage.isDataSortByLowToHighDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Sort_Price_High_To_Low");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 04_Sort_Price_High_To_Low - Step 01: Select 'Sort By' dropdown is: 'Price: Low to High'");
		computersPage.selectSortBySelectBox("Price: High to Low");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 04_Sort_Price_High_To_Low - Step 02: Verify Data is sorted by Price Low to High ");
		verifyTrue(computersPage.isDataSortByHighToLowDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Display_3_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Display_3_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 05_Display_3_Product - Step 01: Select 'Display' dropdown is: '3'");
		computersPage.selectDisplaySelectBox("3");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 05_Display_3_Product - Step 02: Verify The next pagination is Displayed");
		verifyTrue(computersPage.isNextPaginationDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 05_Display_3_Product - Step 03: Verify 3 product or less than are Displayed");
		verifyTrue(computersPage.isDisplay3ProductisDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 05_Display_3_Product - Step 04: Click on page 2 of the pagination");
		computersPage.clickToPage2Pagination();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 05_Display_3_Product - Step 05: Verify The previous pagination is Displayed");
		verifyTrue(computersPage.isPreviousPaginationDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Page_Display_6_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Page_Display_6_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 06_Page_Display_6_Product - Step 01: Select 'Display' dropdown is: '6'");
		computersPage.selectDisplaySelectBox("6");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 06_Page_Display_6_Product - Step 02: Verify 6 product or less than are Displayed");
		verifyTrue(computersPage.isDisplay6ProductisDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data 06_Page_Display_6_Product - Step 03: Verify The pagination is not Displayed");
		Assert.assertTrue(computersPage.isPaginationFieldUnDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_07_Page_Display_9_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_07_Page_Display_9_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data Page_Display_9_Product - Step 01: Select 'Display' dropdown is: '9'");
		computersPage.selectDisplaySelectBox("9");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data Page_Display_9_Product - Step 02: Verify 9 product or less than are Displayed");
		verifyTrue(computersPage.isDisplay9ProductisDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Sort_Data Page_Display_9_Product - Step 03: Verify The pagination is not Displayed");
		verifyTrue(computersPage.isPaginationFieldUnDisplayed());
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	ComputersPageObject computersPage;
	
}
