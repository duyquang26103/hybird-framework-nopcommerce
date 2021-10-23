package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static MyAccountPageObject myaccountPage;
	private static AddressesPageObject addessesPage;
	private static ChangePasswordPageObject changepasswordPage;
	private static ProductPageObject productPage;
	private static MyProductReviewPageObject myProductReviewPage;
	private static SearchPageObject searchPage;
	private static ComputersPageObject computersPage;
		
	private PageGeneratorManager() {
		
	}
	
//	public static HomePageObject getHomePage(WebDriver driver) {
//		if(homePage == null) {
//			homePage = new HomePageObject(driver);
//		}
//		return homePage;
//	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
//	public static LoginPageObject getLoginPage(WebDriver driver) {
//		if(loginPage == null) {
//			loginPage = new LoginPageObject(driver);
//		}
//		return loginPage;
//	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
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
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		if(productPage == null) {
			productPage = new ProductPageObject(driver);
		}
		return productPage;
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		if(myProductReviewPage == null) {
			myProductReviewPage = new MyProductReviewPageObject(driver);
		}
		return myProductReviewPage;
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static ComputersPageObject getComputerPage(WebDriver driver) {
		if(computersPage == null) {
			computersPage = new ComputersPageObject(driver);
		}
		return computersPage;
	}

}
