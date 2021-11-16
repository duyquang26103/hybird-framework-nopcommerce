package com.nopcommerce.wishlist;

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
import pageObjects.nopCommerce.CompareListPageObject;
import pageObjects.nopCommerce.ComputersPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.ProductPageObject;
import pageObjects.nopCommerce.RecentlyReviewPageObject;
import pageObjects.nopCommerce.WishlistPageObject;
import reportConfig.ExtentTestManager;

public class Wishlist_Nopcommerce extends BaseTest {
	WebDriver driver;
	String password, email , nameOfPDFirst, nameOfPDSecond, priceOfPDFrist, priceOfPDSecond;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password = "123123";
		loginPage = homePage.clickToLoginButton();

		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToImgNopcommerce();
		verifyFalse(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void TC_01_Add_To_Wishlist(Method method) {
 		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage = homePage.clickToFirstProduct();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectRAMDropdown("2 GB");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectHDDButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.clickOnButtonByName(driver, "Add to wishlist");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(productPage.isAddWishlistSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.openFooterPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(wishlistPage.isPrductAddSuccessDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickToURLSharing();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(wishlistPage.getProductNameInUrl(), "Wishlist of" + "Abner Siba");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.backToPage(driver);
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Add_Product_To_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickToAddToCartCheckBox();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickToAddToCartButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(wishlistPage.getWishlistEmpty(), "(0)");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(wishlistPage.getShoppingCartisAdded(), "(1)");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Delete_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage = homePage.clickToFirstProduct();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectRAMDropdown("2 GB");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectHDDButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.clickOnButtonByName(driver, "Add to wishlist");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(productPage.isAddWishlistSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.openFooterPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickOnRemoveButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(wishlistPage.getEmptyWishlistMessage(), "The wishlist is empty!");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		wishlistPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage = homePage.clickToFirstProduct();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		nameOfPDFirst = productPage.getNameProductText();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		priceOfPDFrist = productPage.getPriceProductText();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectRAMDropdown("2 GB");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.selectHDDButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.clickToAddComparelistButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(productPage.isAddCompareListSuccessMessageDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage = homePage.clickToSecondProduct();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		nameOfPDSecond = productPage.getNameProductText();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		priceOfPDSecond = productPage.getPriceProductText();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.clickToAddComparelistButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(productPage.isAddCompareListSuccessMessageDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		productPage.openFooterPageByName(driver, "Compare products list");
		compareListPage = PageGeneratorManager.getComPareListPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(compareListPage.getNameOfPDFirst(),nameOfPDFirst);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(compareListPage.getNameOfPDSecond(),nameOfPDSecond);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(compareListPage.getPriceOfPDSecond(),priceOfPDFrist);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertTrue(compareListPage.getNameOfPDSecond(),priceOfPDSecond);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		compareListPage.clickOnClearListLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(wishlistPage.getEmptyComparelistMessage(), "You have no items to compare.");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Display_3_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		compareListPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		homePage.moveToComputerLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage = homePage.clickToNoteBookLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.clickToProductByIndex("1");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.backToPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.clickToProductByIndex("2");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.backToPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.clickToProductByIndex("3");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.backToPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.clickToProductByIndex("4");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.backToPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.clickToProductByIndex("5");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.backToPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		computersPage.openFooterPageByName(driver, "Recently viewed products");
		recentlyReviewPage =  PageGeneratorManager.recentlyReviewPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User 01_Register - Step 01: Click to 'Register' Link ");
		Assert.assertEquals(recentlyReviewPage.getNumberofProductRecentlyViewed(), "3");
		ExtentTestManager.endTest();
	}


	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	ComputersPageObject computersPage;
	CompareListPageObject compareListPage;
	RecentlyReviewPageObject recentlyReviewPage;
}
