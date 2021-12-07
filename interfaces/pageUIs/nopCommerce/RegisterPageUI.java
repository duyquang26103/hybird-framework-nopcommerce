package pageUIs.nopCommerce;

public class RegisterPageUI {
	public static final String GENDER_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXBOX = "//input[@id='FirstName']";
	public static final String lAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String SUCCESS_MESSAGE = "//div[text()='Your registration completed']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";
	public static final String ERROR_MESSAGE_BY_ID = "//span[@id='%s']";
	public static final String EXIST_MESSAGE = "//div[@class='message-error validation-summary-errors']//li";
	public static final String WRONG_PASSWORD_MESSAGE = "//span[@id='Password-error' and contains(.,'Password must meet the following rules:')]//li[text()='must have at least 6 characters']";

}
