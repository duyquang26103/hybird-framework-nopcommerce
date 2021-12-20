package commons;

import java.io.File;

public class GlobalConstants {
	public static final long LONG_TIME_OUT = 30;
	public static final long SHORT_TIME_OUT = 5;
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";

	public static final String BROWSER_USERNAME = "quangvuong_Kfg6Up";
	public static final String BROWSER_AUTOMATE_KEY = "vySpLGTws2ceSP22sxZw";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


}
