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
import pageObjects.nopCommerce.*;
import reportConfig.ExtentTestManager;

public class Order_Nopcommerce extends BaseTest {
    WebDriver driver;
    String totalPrice, editTotalPrice,totalPriceUpdated;
    String processorName, ramName, hddName, osName, softwareMO, softwareAR, softwareTC;
    String processorName02, ramName02, hddName02, osName02;
    String editPrice;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getDriverBrowsers(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        totalPrice = "Sub-Total: $1,500.00";
        editTotalPrice = "Sub-Total: $2,640.00";
        editPrice = "$1,320.00";
        totalPriceUpdated = "$2,500.00";

        loginPage = homePage.clickToLoginPage();

        loginPage.setAllCookie(driver, Common_01_Login_Data.loginPageCookie);
        sleepInSecond(3);
        loginPage.refreshCurrentPage(driver);

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToImgNopcommerce();
        verifyTrue(homePage.isHomePageSliderDisplayed());

    }

    @Test
    public void TC_01_Add_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order TC_01_Add_To_Cart");
        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 01: Click to Random product ");
        productPage = homePage.clickToFirstProduct();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 02: Get proccessor name is: " + productPage.getProcessorNameDropdown());
        processorName = productPage.getProcessorNameDropdown();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 03: Select Ram Dropdown ");
        productPage.selectRAMDropdown("8GB [+$60.00]");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 04: Get ram name is: " + productPage.getRamNameDropDown());
        ramName = productPage.getRamNameDropDown();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 05: Click to 'HDD 400GB' Radio button ");
        productPage.selectHDD400Button();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 06: Get HHD name is: " + productPage.getTextHdd400NameRadio());
        hddName = productPage.getTextHdd400NameRadio();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 07: Click to 'Os: Vista Premium [+$60.00]' Radio button ");
        productPage.selectOSVPRadio();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 08: Get ram name is: " + productPage.getTextOsVPNameRadio());
        osName = productPage.getTextOsVPNameRadio();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 09: Get ram name is: " + productPage.getTextSoftwareMOCheckbox());
        softwareMO = productPage.getTextSoftwareMOCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 10: Click to 'Acrobat Reader [+$10.00]' Radio button ");
        productPage.clickOnSoftWareARCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 11: Get ram name is: " + productPage.getTextSoftwareARCheckbox());
        softwareAR = productPage.getTextSoftwareARCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 12: Click to 'Total Commander [+$5.00]' Radio button ");
        productPage.clickOnSoftWareTCCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 13: Get ram name is: " + productPage.getTextSoftwareTCCheckbox());
        softwareTC = productPage.getTextSoftwareTCCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 14: Click to 'Add to cart' button ");
        productPage.clickOnButtonByName(driver, "Add to cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 15: Verify Product is added to cart success Message is displayed");
        verifyTrue(productPage.isAddToCartSuccessMessageDisplayed());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 16: Click to close success message");
        productPage.clickOnCloseSuccessMessage();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 17: Verify Product is added is displayed ");
        productPage.moveHeaderPageByName(driver, "Shopping cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 18: Verify Product is added is displayed ");
        verifyEquals(productPage.getProductQtyText(), "1 item(s)");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 19: Verify All item at 'Your Cart' is Displayed ");
        verifyEquals(productPage.getTextDetailInMyCartByName(), "Build your own computer\nProcessor: " + processorName + "\nRAM: " + ramName + "\nHDD: " + hddName + "\nOS: " + osName + "\nSoftware: " + softwareMO + "\nSoftware: " + softwareAR + "\nSoftware: " + softwareTC + "\nUnit price: $1,500.00\nQuantity: 1");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 20: Verify Product is added is displayed ");
        verifyEquals(productPage.getSubTotalPriceText(), totalPrice);
        ExtentTestManager.endTest();
    }

    @Test
    public void TC_02_Edit_Product_In_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_02_Edit_Product_In_Cart");
        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart Step 01: Open shopping cart page at footer");
        productPage.openFooterPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart Step 02: Click on Edit Button");
        productPage = shoppingCartPage.clickOnEditButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart Step 02: Click on Edit Button");
        productPage.selectProcessorDropdownByName("2.2 GHz Intel Pentium Dual-Core E2200");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 03: Select Ram Dropdown ");
        productPage.selectRAMDropdown("4GB [+$20.00]");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 04: Click to 'HDD 320GB' Radio button ");
        productPage.selectHDDButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 05: Click to 'Vista Home [+$50.00]' Radio button ");
        productPage.selectOSVHRadio();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 06: Click to 'HDD 320GB' Radio button ");
        productPage.clickOnSoftWareARCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 07: Click to 'HDD 320GB' Radio button ");
        productPage.clickOnSoftWareTCCheckbox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 08: Clear and input Quantity of Product from 1 to 2");
        productPage.inputToQtyProductText("2");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 09: Verify the price is: " + editPrice);
        verifyEquals(productPage.getPriceProductText(), editPrice);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 10: Get all attribute of data");
        processorName02 = productPage.getProcessorNameDropdown();
        ramName02 = productPage.getRamNameDropDown();
        hddName02 = productPage.getTextHdd320NameRadio();
        osName02 = productPage.getTextOsVHNameRadio();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 10: Click to 'Update' button ");
        productPage.clickOnButtonByName(driver, "Update");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 11: Verify Product is added to cart success Message is displayed");
        verifyTrue(productPage.isAddToCartSuccessMessageDisplayed());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 02_Edit_Product_In_Cart - Step 12: Click to close success message");
        productPage.clickOnCloseSuccessMessage();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 17: Verify Product is added is displayed ");
        productPage.moveHeaderPageByName(driver, "Shopping cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 18: Verify Product is added is displayed ");
        verifyEquals(productPage.getProductQtyText(), "2 item(s)");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 19: Verify All item at 'Your Cart' is Displayed ");
        verifyEquals(productPage.getTextDetailInMyCartByName(), "Build your own computer\nProcessor: " + processorName02 + "\nRAM: " + ramName02 + "\nHDD: " + hddName02 + "\nOS: " + osName02 + "\nSoftware: " + softwareMO + "\nUnit price: $1,320.00\nQuantity: 2");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 01_Add_To_Cart - Step 20: Verify Product is added is displayed ");
        verifyEquals(productPage.getSubTotalPriceText(), editTotalPrice);
        ExtentTestManager.endTest();
    }

    @Test
    public void TC_03_Remove_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_03_Remove_Shopping_Cart");
        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 03_Remove_Shopping_Cart - Step 01: Click to 'Shopping Cart' Link at footer");
        productPage.openFooterPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 03_Remove_Shopping_Cart - Step 02: Click to 'Remove' button ");
        shoppingCartPage.clickOnRemoveButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 03_Remove_Shopping_Cart - Step 03: Verify Don't have any product in shopping cart");
        verifyTrue(shoppingCartPage.isShoppingCartEmpty());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 03_Remove_Shopping_Cart - Step 04: Move to Shopping cart at header");
        shoppingCartPage.moveHeaderPageByName(driver, "Shopping cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 03_Remove_Shopping_Cart - Step 05: Verify Shopping Cart is empty");
        verifyTrue(shoppingCartPage.isShoppingCartEmpty());
        ExtentTestManager.endTest();
    }

    @Test
    public void TC_04_Update_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_04_Update_Shopping_Cart");
        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart- Step 01: Click on nopcommerce image");
        shoppingCartPage.clickToImgNopcommerce(driver);
        homePage = PageGeneratorManager.getHomePage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart- Step 02: Input search textbox is: Lenovo IdeaCentre 600 All-in-One PC");
        homePage.inputSearchTextBox("Lenovo IdeaCentre 600 All-in-One PC");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart- Step 03: Click on Search button");
        homePage.areJQueryAndJSLoadedSuccess(driver);
        searchPage = homePage.clickToSearchButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart- Step 04: Click on Search button");
		searchPage.clickToProductByIndex("1");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 05: Click to 'Add to Cart' button ");
        productPage.clickOnButtonByName(driver, "Add to cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 06: Open shopping cart at footer");
        productPage.openFooterPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 07: Clear and input Quantity of Product from 1 to 5");
        shoppingCartPage.inputFirstProductQtyShoppingCart("5");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 08: Click on 'Update Shopping Cart' button");
        shoppingCartPage.clickOnButtonByName(driver,"Update shopping cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 09: Verify Total price of product is: "+totalPriceUpdated);
        verifyEquals(shoppingCartPage.getTotalPriceOfFirstProduct(),totalPriceUpdated);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 02: Click to 'Remove' button ");
        shoppingCartPage.clickOnRemoveButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 03: Verify Don't have any product in shopping cart");
        verifyTrue(shoppingCartPage.isShoppingCartEmpty());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 04: Move to Shopping cart at header");
        shoppingCartPage.moveHeaderPageByName(driver, "Shopping cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order 04_Update_Shopping_Cart - Step 05: Verify Shopping Cart is empty");
        verifyTrue(shoppingCartPage.isShoppingCartEmpty());
        ExtentTestManager.endTest();
    }

    @Test
    public void TC_05_Check_Out_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_05_Check_Out_Order");
        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order- Step 01: Click on nopcommerce image");
        shoppingCartPage.clickToImgNopcommerce(driver);
        homePage = PageGeneratorManager.getHomePage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order- Step 02: Input search textbox is: Lenovo IdeaCentre 600 All-in-One PC");
        homePage.inputSearchTextBox("Apple MacBook Pro 13-inch");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order- Step 03: Click on Search button");
        searchPage = homePage.clickToSearchButton();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order- Step 04: Click on Search button");
        searchPage.clickToProductByIndex("1");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 05: Click to 'Add to Cart' button ");
        productPage.clickOnButtonByName(driver, "Add to cart");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 06: Open shopping cart at footer");
        productPage.openFooterPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 07: Click on the 'Agree' radio button");
        shoppingCartPage.clickOnAgreeCheckBox();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 08: Click on the 'Checkout' button");
        shoppingCartPage.clickOnButtonByName(driver," Checkout ");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 09: Click on the 'Continue' button");
        checkOutPage.clickOnButtonByName(driver,"Continue");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 10: Click on Next Day Air radio button");
        checkOutPage.clickOnRadioButtonByID(driver,"shippingoption_1");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 11: Click on the 'Continue' button");
        checkOutPage.clickOnButtonByName(driver,"Continue");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 12: Click on Next Day Air radio button");
        checkOutPage.clickOnRadioButtonByID(driver,"paymentmethod_0");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 13: Click on the 'Continue' button");
        checkOutPage.clickOnButtonByName(driver,"Continue");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 14: Verify payment status is: NOP SOLUTIONS ,your address here, New York, NY 10001 ,USA");
        verifyEquals(checkOutPage.getPaymentStatus(),"\nNOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Order TC_05_Check_Out_Order - Step 15: Click on the 'Continue' button");
        checkOutPage.clickOnButtonByName(driver,"Continue");



        ExtentTestManager.endTest();
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }

    HomePageObject homePage;
    LoginPageObject loginPage;
    ProductPageObject productPage;
    ShoppingCartPageObject shoppingCartPage;
    SearchPageObject searchPage;
    CheckOutPageObject checkOutPage;
}
