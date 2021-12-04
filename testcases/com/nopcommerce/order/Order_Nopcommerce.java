package com.nopcommerce.order;

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
import pageObjects.nopCommerce.ShoppingCartPageObject;
import pageObjects.nopCommerce.WishlistPageObject;
import reportConfig.ExtentTestManager;

public class Order_Nopcommerce extends BaseTest {
	WebDriver driver;
	String totalPrice;
	String processorName, ramName, hddName, osName, softwareMO, softwareAR, softwareTC;
	String nameOfPDFirstCP, nameOfPDSecondCP, priceOfPDFristCP, priceOfPDSecondCP;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		totalPrice = "$1,440.00";
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
		sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToImgNopcommerce();
		verifyFalse(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void TC_01_Add_To_Cart(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Order TC_01_Add_To_Cart");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 01: Click to Random product ");
//		productPage = homePage.clickToFirstProduct();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get proccessor name is: "+ productPage.getProccessorNameDropdown());
//		processorName = productPage.getProccessorNameDropdown();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Select Ram Dropdown ");
//		productPage.selectRAMDropdown("2 GB");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getRamNameDropDown());
//		ramName = productPage.getRamNameDropDown();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 03: Click to 'HDD 320GB' Radio button ");
//		productPage.selectHDDButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getTextHddNameRadio());
//		hddName = productPage.getTextHddNameRadio();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 03: Click to 'Os: Vista Premium [+$60.00]' Radio button ");
//		productPage.selectOSButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getTextOsNameRadio());
//		hddName = productPage.getTextOsNameRadio();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getTextsoftwareMOCheckbox());
//		softwareMO = productPage.getTextsoftwareMOCheckbox();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 03: Click to 'HDD 320GB' Radio button ");
//		productPage.clickOnSoftWareARCheckbox();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getTextsoftwareARCheckbox());
//		softwareMO = productPage.getTextsoftwareARCheckbox();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 03: Click to 'HDD 320GB' Radio button ");
//		productPage.clickOnSoftWareTCCheckbox();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get ram name is: " + productPage.getTextsoftwareTCCheckbox());
//		softwareMO = productPage.getTextsoftwareTCCheckbox();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 04: Click to 'Add to cart' button ");
//		productPage.clickOnButtonByName(driver, "Add to cart");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,	"Order 01_Add_To_Cart - Step 05: Verify Wishlist is added success Message is displayed");
//		verifyTrue(productPage.isAddToCartSuccessMessageDisplayed());
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 04: Click to 'Add to cart' button ");
//	//	productPage.clickOnCloseSuccessMessage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 07: Verify Product is added is displayed ");
//		verifyEquals(productPage.getPrductQtyText(),"(1)");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 07: Verify Product is added is displayed ");
//		productPage.moveToShoppingCart();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 07: Verify Product is added is displayed ");
//		verifyEquals(productPage.getPrductQtyInYourCartText(),"(1)");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 09: Verify All item at 'Your Cart' is Displayed ");
//		verifyEquals(productPage.getTextDetailInMyCartByName(driver, "Processor"), "Processor: "+ processorName+"\nRAM: "+ramName+"\nHDD: "+hddName+"\nOS: "+osName+"\nSoftware: "+softwareMO+"\nSoftware: "+softwareAR+"\nSoftware: "+softwareTC );
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Order 01_Add_To_Cart - Step 07: Verify Product is added is displayed ");
//		verifyTrue(productPage.getSubTotalPriceText().equals("totalPrice"));
//		ExtentTestManager.endTest();
	}

//	@Test
//	public void TC_02_Add_Product_To_Cart(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Register_To_System");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_03_Delete_Wishlist(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_03_Delete_Wishlist");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_04_Add_Product_To_Compare(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_04_Add_Product_To_Compare");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_05_Recenly_Review_Product(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_05_Recenly_Review_Product");
//		ExtentTestManager.endTest();
//	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	ShoppingCartPageObject shoppingcartPage;
	ComputersPageObject computersPage;
	CompareListPageObject compareListPage;
	RecentlyReviewPageObject recentlyReviewPage;
}
