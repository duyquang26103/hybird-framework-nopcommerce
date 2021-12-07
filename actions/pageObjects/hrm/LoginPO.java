package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPO extends BasePage{
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public DashBoardPO loginToSystem(String idUserName,String idPassword, String iDButton, String adminUserName, String adminPassword) {
		inputTextBoxByID(driver, adminUserName,idUserName);
		inputTextBoxByID(driver, adminPassword,idPassword);
		//clickOnButtonByID(driver, iDButton);
		return PageGeneratorManager.dashBoardPage(driver);
	}

}
