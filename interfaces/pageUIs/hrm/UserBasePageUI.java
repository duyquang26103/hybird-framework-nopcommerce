package pageUIs.hrm;

public class UserBasePageUI {
	public static final String INPUT_TEXTBOX = "//input[@id='%s']";
	public static final String INPUT_CHECKBOX = "//input[@id='%s']";
	public static final String INPUT_BUTTON = "//input[@id='%s']";
	public static final String BUTTON_LINK = "//button[text()='%s']";
	public static final String BUTTON_ID = "//button[@id='%s']";
	public static final String SELECT_BY_ID = "//select[@id='%s']";

	public static final String MENU_HEADER = "//div[@class='menu']//li/a[contains(.,'%s')]";
	public static final String SUB_MENU_HEADER = "//div[@id='mainMenu']//a[text()='%s']";

	public static final String TABLE_HEADER_BY_ID_AND_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_ID_BY_COLUMN_INDEX_AND_BY_ROW_INDEX = "//table[@id='%s']//tr[%s]/td[%s]/a";

}
