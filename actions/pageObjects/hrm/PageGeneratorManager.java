package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private static LoginPO loginPage;
	private static EmpListPO empListPage;
	private static AddEmpPO addEmpPage;
	private static EmpDetailPO empDetailPage;
	private static DashBoardPO dashBoardPage;

	private PageGeneratorManager() {

	}

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static EmpListPO empListPage(WebDriver driver) {
		return new EmpListPO(driver);
	}
	
	public static AddEmpPO addEmpPage(WebDriver driver) {
		return new AddEmpPO(driver);
	}
	
	public static EmpDetailPO empDetailPage(WebDriver driver) {
		return new EmpDetailPO(driver);
	}
	
	public static DashBoardPO dashBoardPage(WebDriver driver) {
		return new DashBoardPO(driver);
	}

}
