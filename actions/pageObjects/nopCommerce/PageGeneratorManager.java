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
	private static WishlistPageObject wishlistPage;
	private static CompareListPageObject compareListPage;
	private static RecentlyReviewPageObject recentlyReviewPage;
		
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
		return new RegisterPageObject(driver);
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
		return new MyAccountPageObject(driver);
	}
	
	public static AddressesPageObject getAddessesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ComputersPageObject getComputerPage(WebDriver driver) {
		return new ComputersPageObject(driver);
	}

	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static CompareListPageObject getComPareListPage(WebDriver driver) {
		return new CompareListPageObject(driver);
	}

	public static RecentlyReviewPageObject getRecentlyReviewPage(WebDriver driver) {
		return new RecentlyReviewPageObject(driver);
	}

}
