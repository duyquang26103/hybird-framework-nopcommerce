package com.nopcommerce.wishlist;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
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
	String password, email, nameOfPDFirst, nameOfPDSecond, priceOfPDFrist, priceOfPDSecond;
	String nameOfPDFirstCP, nameOfPDSecondCP, priceOfPDFristCP, priceOfPDSecondCP;
	HomePageObject homePage;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	ComputersPageObject computersPage;
	CompareListPageObject compareListPage;
	RecentlyReviewPageObject recentlyReviewPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password = "123123";
		loginPage = homePage.clickToLoginLink();

		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToImgNopcommerce();
		verifyFalse(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void TC_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Add_To_Wishlist");
		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_To_Wishlist _01 - Step 01: Click to Random product ");
		productPage = homePage.clickToFirstProduct();

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_To_Wishlist _01 - Step 02: Select Ram Dropdown ");
		productPage.selectRAMDropdown("2 GB");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_To_Wishlist _01 - Step 03: Click to 'HDD 320GB' Radio button ");
		productPage.selectHDDButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_To_Wishlist _01 - Step 04: Click to 'Add to Wishlist' button ");
		productPage.clickOnButtonByName(driver, "Add to wishlist");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_To_Wishlist _01 - Step 05: Verify Wishlist is added success Message is displayed");
		verifyTrue(productPage.isAddWishlistSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_To_Wishlist _01 - Step 06: Click to 'Wishlist' Link at footer");
		productPage.openFooterPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_To_Wishlist _01 - Step 07: Verify Product is added is displayed ");
		verifyTrue(wishlistPage.isPrductAddSuccessDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_To_Wishlist _01 - Step 08: Click to 'URL' sharing Link ");
		wishlistPage.clickToURLSharing();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_To_Wishlist _01 - Step 09: Verify Name of list product is displayed ");
		verifyEquals(wishlistPage.getProductNameInUrl(), "Wishlist of" + " Abner Siba");

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_To_Wishlist _01 - Step 10: Back to previous page ");
		wishlistPage.backToPage(driver);
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Add_Product_To_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Add_Product_To_Cart");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Cart _02 - Step 01: Click to 'Add to Cart' Check Box ");
		wishlistPage.clickToAddToCartCheckBox();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Cart _02 - Step 02: Click to 'Add to Cart' Butt ");
		wishlistPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Add_Product_To_Cart _02 - Step 03: Verify Wishlist is empty ");
		verifyEquals(wishlistPage.getWishlistEmpty(), "(0)");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Cart _02 - Step 04:  Verify Shopping Cart have one qty ");
		verifyEquals(wishlistPage.getShoppingCartisAdded(), "(1)");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Delete_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Delete_Wishlist");
		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 01: Click to 'Nopcommerce' image");
		wishlistPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 02: Click to Random product");
		productPage = homePage.clickToFirstProduct();

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 03: Select Ram Dropdown ");
		productPage.selectRAMDropdown("2 GB");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Delete_Wishlist _03 - Step 04: Click to 'HDD 320GB' Radio button ");
		productPage.selectHDDButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Delete_Wishlist _03 - Step 05: Click to 'Add to Wishlist' button  ");
		productPage.clickOnButtonByName(driver, "Add to wishlist");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Delete_Wishlist _03 - Step 06: Verify Wishlist is added success Message is displayed");
		verifyTrue(productPage.isAddWishlistSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 07: Click to 'Wishlist' Link");
		productPage.openFooterPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 08: Click to 'Remove' button ");
		wishlistPage.clickOnRemoveButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,	"Delete_Wishlist _03 - Step 09: Verify Wishlist is empty");
		verifyEquals(wishlistPage.getEmptyWishlistMessage(), "The wishlist is empty!");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Add_Product_To_Compare(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Add_Product_To_Compare");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 01: Click to 'Nopcommerce' image");
		wishlistPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 02: Click to Random product");
		productPage = homePage.clickToFirstProduct();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 03: Get the name of first product: " + productPage.getNameProductText());
		nameOfPDFirst = productPage.getNameProductText();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 04: Get the price of first product: " + productPage.getPriceProductText());
		priceOfPDFrist = productPage.getPriceProductText();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 05: Select Ram Dropdown");
		productPage.selectRAMDropdown("2 GB");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 06: Click to 'HDD 320GB' Radio button ");
		productPage.selectHDDButton();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 07: Click to 'Add to compare list' button");
		productPage.clickOnButtonByName(driver, "Add to compare list");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 08: Verify compare is added success Message is displayed");
		verifyTrue(productPage.isAddCompareListSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 09: Verify compare is added success Message is displayed");
		productPage.clickOnCloseSuccessMessage();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 10: Click to 'Nopcommerce' image");
		productPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 11: Click to Second product");
		productPage = homePage.clickToSecondProduct();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 12: Get the name of Second product: " + productPage.getNameProductText());
		nameOfPDSecond = productPage.getNameProductText();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 13: Get the price of Second product: " + productPage.getPriceProductText());
		priceOfPDSecond = productPage.getPriceProductText();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 14: Click to 'Add to compare list' button ");
		productPage.clickOnButtonByName(driver, "Add to compare list");

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 15: Verify compare is added success Message is displayed");
		verifyTrue(productPage.isAddCompareListSuccessMessageDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 16: Open 'Compare products list' link at footer");
		productPage.openFooterPageByName(driver, "Compare products list");
		compareListPage = PageGeneratorManager.getComPareListPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 17: Verify name of first product is displayed");
		nameOfPDFirstCP = compareListPage.getNameOfProduct("product-name","2");
		verifyEquals(nameOfPDFirstCP, nameOfPDFirst);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 18: Verify name of sencond product is displayed");
		nameOfPDSecondCP = compareListPage.getNameOfProduct("product-name","1");
		verifyEquals(nameOfPDSecondCP, nameOfPDSecond);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 19: Verify price of first product is displayed");
		priceOfPDFristCP = compareListPage.getPriceOfProduct("product-price","2");
		verifyEquals(priceOfPDFristCP, priceOfPDFrist);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 20: Verify name of first product is displayed");
		priceOfPDSecondCP = compareListPage.getPriceOfProduct("product-price","1");
		verifyEquals(priceOfPDSecondCP, priceOfPDSecond);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 21: Click to 'Clear List' Link ");
		compareListPage.clickOnClearListLink();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Add_Product_To_Compare_04 - Step 22: Verify text 'You have no items to compare' is display");
		verifyEquals(compareListPage.getEmptyComparelistMessage(), "You have no items to compare.");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Recenly_Review_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Recenly_Review_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 01: Click to 'NopCommerce' image ");
		compareListPage.clickToImgNopcommerce(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 02: Hover to 'Computer' Menu");
		homePage.moveToComputerLink();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 3: Click to 'Note Book' submenu ");
		computersPage = homePage.clickToNoteBookLink();

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 4: Click to name of first product");
		productPage = computersPage.clickToProductByIndex("1");
		verifyTrue(productPage.isProductNameisDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 5:Back to previous page");
		productPage.backToPage(driver);
		computersPage = PageGeneratorManager.getComputerPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 6: Click to name of second product");
		productPage = computersPage.clickToProductByIndex("2");
		verifyTrue(productPage.isProductNameisDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 7: Back to previous page ");
		productPage.backToPage(driver);
		computersPage = PageGeneratorManager.getComputerPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 8:Click to name of thrid product");
		productPage = computersPage.clickToProductByIndex("3");
		verifyTrue(productPage.isProductNameisDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 9: Back to previous page");
		productPage.backToPage(driver);
		computersPage = PageGeneratorManager.getComputerPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 10:Click to name of fourth product");
		productPage = computersPage.clickToProductByIndex("4");
		verifyTrue(productPage.isProductNameisDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 11: Back to previous page");
		productPage.backToPage(driver);
		computersPage = PageGeneratorManager.getComputerPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 12:Click to name of fifth product");
		productPage = computersPage.clickToProductByIndex("5");
		verifyTrue(productPage.isProductNameisDisplayed());

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 14: Open 'Recently viewed products' link at footer");
		productPage.openFooterPageByName(driver, "Recently viewed products");
		recentlyReviewPage = PageGeneratorManager.recentlyReviewPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO,"Recenly_Review_Product_05 - Step 15: Verify page only display three product");
		verifyEquals(recentlyReviewPage.getNumberofProductRecentlyViewed(), 3);
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
