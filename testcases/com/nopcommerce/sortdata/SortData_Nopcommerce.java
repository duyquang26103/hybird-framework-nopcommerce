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
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		homePage.moveToComputerLink();
		
		computersPage = homePage.clickToNoteBookLink();
		
		computersPage.selectSortBySelectBox("Name: A to Z");
		
		verifyTrue(computersPage.isDataSortByAToZDisplayed());
		
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Sort_Name_Z_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Sort_Name_Z_A");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectSortBySelectBox("Name: Z to A");
		Assert.assertTrue(computersPage.isDataSortByZToADisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High(Method method) {	
		ExtentTestManager.startTest(method.getName(), "TC_03_Sort_Price_Low_To_High");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectSortBySelectBox("Price: Low to High");
		verifyTrue(computersPage.isDataSortByLowToHighDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Sort_Price_High_To_Low");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectSortBySelectBox("Price: High to Low");
		verifyTrue(computersPage.isDataSortByHighToLowDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Display_3_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectDisplaySelectBox("3");
		verifyTrue(computersPage.isNextPaginationDisplayed());
		verifyTrue(computersPage.isDisplay3ProductisDisplayed());
		computersPage.clickToPage2Pagination();
		verifyTrue(computersPage.isPreviousPaginationDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Advanced_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectDisplaySelectBox("6");
		verifyTrue(computersPage.isDisplay6ProductisDisplayed());
		Assert.assertTrue(computersPage.isPaginationFieldUnDisplayed());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_07_Advanced_Incorrect_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Add_To_Wishlist _01 - Step 01: Click to Random product ");
		computersPage.selectDisplaySelectBox("9");
		verifyTrue(computersPage.isDisplay9ProductisDisplayed());
		verifyTrue(computersPage.isPaginationFieldUnDisplayed());
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	ComputersPageObject computersPage;
	
}
