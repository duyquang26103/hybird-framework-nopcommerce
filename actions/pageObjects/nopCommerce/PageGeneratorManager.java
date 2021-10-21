package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static MyAccountPageObject myaccountPage;
	private static AddressesPageObject addessesPage;
	private static ChangePasswordPageObject changepasswordPage;
		
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if(myaccountPage == null) {
			myaccountPage = new MyAccountPageObject(driver);
		}
		return myaccountPage;
	}
	
	public static AddressesPageObject getAddessesPage(WebDriver driver) {
		if(addessesPage == null) {
			addessesPage = new AddressesPageObject(driver);
		}
		return addessesPage;
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		if(changepasswordPage == null) {
			changepasswordPage = new ChangePasswordPageObject(driver);
		}
		return changepasswordPage;
	}

}
