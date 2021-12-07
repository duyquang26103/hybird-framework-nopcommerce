package com.hrm.employee;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.hrm.AddEmpPO;
import pageObjects.hrm.DashBoardPO;
import pageObjects.hrm.EmpDetailPO;
import pageObjects.hrm.EmpListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;
import reportConfig.ExtentTestManager;

public class Employee_Hrm extends BaseTest {
//	WebDriver driver;
//	String firstName, lastName, fullName, empUserName, empPassword, adminUserName, adminPassword;
//
//	@Parameters({ "browser", "url" })
//	@BeforeClass
//	public void beforeClass(String browserName, String appUrl) {
//
//		driver = getDriverBrowsers(browserName, appUrl);
//		loginPage = PageGeneratorManager.getLoginPage(driver);
//
//		adminUserName = "Admin";
//		adminPassword = "admin123";
//		empUserName = RandomEmail();
//		empPassword = "automationpass@";
//		firstName = "Raken";
//		lastName = "Silika";
//		fullName = firstName + " " + lastName;
//		dashBoardPage = loginPage.loginToSystem("txtUsername", "txtPassword", "btnLogin", adminUserName, adminPassword);
//	}
//
//	@Test
//	public void TC_01_Add_New_Employee(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Add_New_Employee");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 01: Click to 'PIM' Menu");
//		dashBoardPage.openMenuHeaderAndSubMenuByName(driver, "PIM", "Employee List");
//		empListPage = PageGeneratorManager.empListPage(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 02: Click to 'Add' buttom");
//		empListPage.isJQueryAjaxLoadedSuccess(driver);
//		empListPage.clickOnButtonByID(driver, "btnAdd");
//		addEmpPage = PageGeneratorManager.addEmpPage(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 03: Input To First Name Textbox: "+ firstName);
//		addEmpPage.inputTextBoxByID(driver,firstName, "firstName");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 04: Input To First Name Textbox: "+ lastName);
//		addEmpPage.inputTextBoxByID(driver,lastName,"lastName");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 05: Click to 'Create Login Details' Check box");
//		addEmpPage.clickOnCheckBoxByID(driver,"chkLogin");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 06: Input To User Name Textbox: "+ empUserName);
//		addEmpPage.inputTextBoxByID(driver,empUserName,"user_name");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 07: Input To Password Textbox: "+ empPassword);
//		addEmpPage.inputTextBoxByID(driver,empPassword,"user_password");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 08: Input To Confirm Password Textbox: "+ empPassword);
//		addEmpPage.inputTextBoxByID(driver,empPassword,"re_password");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 09: Select Status dropdown is Enabled");
//		addEmpPage.selectDropdownByName(driver, "status","Enabled");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 10: Click to 'Save' Button");
//		addEmpPage.clickOnButtonByID(driver, "btnSave");
//		empDetailPage = PageGeneratorManager.empDetailPage(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 11: Click to 'Employee List' SubMenu");
//		empDetailPage.openMenuHeaderAndSubMenuByName(driver, "PIM", "Employee List");
//		empListPage = PageGeneratorManager.empListPage(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 12: Input To Name search Textbox: "+ firstName);
//		empListPage.isJQueryAjaxLoadedSuccess(driver);
//		empListPage.inputTextBoxByID(driver,firstName,"empsearch_employee_name_empName");
//		empListPage.isJQueryAjaxLoadedSuccess(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 13: Click to 'Search' Button");
//		empListPage.clickOnButtonByID(driver, "searchBtn");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 15: Verify First Name in the grid is: "+ firstName);
//		verifyEquals(empListPage.getValueTableByIDByRowIndexAndColumnName(driver,"resultTable","1","First (& Middle) Name"),firstName);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Employee 01_Add_New_Employee - Step 16: Verify Last Name in the grid is: "+ lastName);
//		verifyEquals(empListPage.getValueTableByIDByRowIndexAndColumnName(driver,"resultTable","1","Last Name"),lastName);
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_02_Upload_Avatar(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_03_Personal_Details(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_04(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void TC_05(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
//		ExtentTestManager.endTest();
//	}

	@Test
	public void TC_06(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Custom_Info");
		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

	LoginPO loginPage;
	EmpListPO empListPage;
	AddEmpPO addEmpPage;
	EmpDetailPO empDetailPage;
	DashBoardPO dashBoardPage;
}
