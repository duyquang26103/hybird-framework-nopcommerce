package com.nopcommerce.sortdata;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.ComputersPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

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
	public void TC_01_Sort_Name_A_Z() {
		homePage.moveToComputerLink();
		computersPage = homePage.clickToNoteBookLink();
		computersPage.selectSortBySelectBox("Name: A to Z");
		Assert.assertTrue(computersPage.isDataSortByAToZDisplayed());
		
	}

	@Test
	public void TC_02_Sort_Name_Z_A() {
		computersPage.selectSortBySelectBox("Name: Z to A");
		Assert.assertTrue(computersPage.isDataSortByZToADisplayed());
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High() {	
		computersPage.selectSortBySelectBox("Price: Low to High");
		Assert.assertTrue(computersPage.isDataSortByLowToHighDisplayed());
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low() {
		computersPage.selectSortBySelectBox("Price: High to Low");
		Assert.assertTrue(computersPage.isDataSortByHighToLowDisplayed());
	}

	@Test
	public void TC_05_Display_3_Product() {
		computersPage.selectDisplaySelectBox("3");
		Assert.assertTrue(computersPage.isNextPaginationDisplayed());
		Assert.assertTrue(computersPage.isDisplay3ProductisDisplayed());
		computersPage.clickToPage2Pagination();
		Assert.assertTrue(computersPage.isPreviousPaginationDisplayed());
	}

	@Test
	public void TC_06_Advanced_Sub_Categories() {
		computersPage.selectDisplaySelectBox("6");
		Assert.assertTrue(computersPage.isDisplay6ProductisDisplayed());
		Assert.assertFalse(computersPage.isPaginationFieldDisplayed());
	}

	@Test
	public void TC_07_Advanced_Incorrect_Manufacturer() {
		computersPage.selectDisplaySelectBox("9");
		Assert.assertTrue(computersPage.isDisplay9ProductisDisplayed());
		Assert.assertFalse(computersPage.isPaginationFieldDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	ComputersPageObject computersPage;
	
}
