package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.nopCommerce.UserBasePageUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void getURL(WebDriver driver, String name) {
		driver.get(name);
	}

	public String getTitle(WebDriver driver, String name) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver, String name) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver, String name) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		return explicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver).accept();

	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitAlertPresence(driver).getText();
	}

	public void sendKeyToAlert(WebDriver driver, String textAlert) {
		waitAlertPresence(driver).sendKeys(textAlert);
	}

	public void switchToWindownByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}

	}

	public void switchToWindownByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			driver.switchTo().window(id);
			String titleWindow = driver.getTitle();
			if (titleWindow.equals(expectedTitle)) {
				break;
			}
		}

	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}

	}

	public Set<Cookie> getAllCookie(WebDriver driver) {
		Set<Cookie> allCookies = driver.manage().getCookies();
		return allCookies;
	}

	public void setAllCookie(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
		allCookies = driver.manage().getCookies();
	}

	protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getXpath(xpathLocator));
	}

	protected List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getXpath(xpathLocator));
	}

	private By getXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public String getDymamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... params) {
		getWebElement(driver, getDymamicLocator(xpathLocator, params)).click();
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... params) {
		xpathLocator = getDymamicLocator(xpathLocator, params);
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText().trim();
	}

	protected String getElementText(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDymamicLocator(xpathLocator, params)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropdownByText(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}

	public String getSelectItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMutiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator);
		sleepInSecond(1);

		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		List<WebElement> ListItems = explicit
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXpath(childItemLocator)));

		for (WebElement item : ListItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getWebElements(driver, xpathLocator).size();
	}

	public void checkTheCheckboxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isEnabled()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isEnabled()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDymamicLocator(xpathLocator, params)).isDisplayed();
	}

	public boolean isControlUnDisplayed(WebDriver driver, String xpathLocator) {
		overrideGlobalTime(driver, shortTimeout);
		List<WebElement> elements = getWebElements(driver, xpathLocator);
		overrideGlobalTime(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void overrideGlobalTime(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isControlSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public void switchToIframeFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	public void moveToElement(WebDriver driver, String xpathLocator, String...params) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDymamicLocator(xpathLocator, params))).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToTopPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,0)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}
	
	public void scrollToElement(WebDriver driver, String xpathLocator, String...params) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDymamicLocator(xpathLocator, params)));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.visibilityOfElementLocated(getXpath(xpathLocator)));
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(
				ExpectedConditions.visibilityOfElementLocated(getXpath(getDymamicLocator(xpathLocator, params))));
	}

	public void waitForAllsElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(xpathLocator)));
	}

	public void waitForAllsElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, shortTimeout);
		explicit.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.elementToBeClickable(getXpath(xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.elementToBeClickable(getXpath(getDymamicLocator(xpathLocator, params))));
	}

	public void waitForElementSelected(WebDriver driver, String xpathLocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.elementToBeSelected(getXpath(getDymamicLocator(xpathLocator))));
	}

	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.FOOTER_LINK, pageName);
		clickToElement(driver, UserBasePageUI.FOOTER_LINK, pageName);
	}

	public void openHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.HEADER_LINK, pageName);
		clickToElement(driver, UserBasePageUI.HEADER_LINK, pageName);
	}
	public void moveHeaderPageByName(WebDriver driver, String pageName) {
		scrollToTopPage(driver);
		waitForElementVisible(driver, UserBasePageUI.HEADER_LINK, pageName);
		moveToElement(driver, UserBasePageUI.HEADER_LINK, pageName);
	}

	public void inputTextBoxByID(WebDriver driver, String value, String idName) {
		waitForElementVisible(driver, UserBasePageUI.INPUT_TEXTBOX_BY_ID, idName);
		sendKeyToElement(driver, UserBasePageUI.INPUT_TEXTBOX_BY_ID, value, idName);
	}
	
	public void clickOnButtonByName(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, UserBasePageUI.BUTTON_BY_TEXT, buttonName);
		if(driver.toString().contains("chrome")){
			sleepInSecond(1);
		}
		clickToElement(driver, UserBasePageUI.BUTTON_BY_TEXT, buttonName);
	}
	public void clickOnRadioButtonByID(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, UserBasePageUI.RADIO_BUTTON_BY_ID, buttonName);
		clickToElement(driver, UserBasePageUI.RADIO_BUTTON_BY_ID, buttonName);
	}

	public List<Integer> addElementToList(WebDriver driver, String listItem) {
		List<WebElement> AllItems = getWebElements(driver, listItem);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < AllItems.size(); i++) {
			String textItem = AllItems.get(i).getText().trim().replace("$", "").replace(",", "").replace(".", "");
			int price = Integer.parseInt(textItem);
			list.add(price);
		}
		return list;
	}

	public boolean checkElementSortLowToHigh(WebDriver driver, String listItem) {
		List<Integer> list = addElementToList(driver, listItem);
		Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= arr[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkElementSortHighToLow(WebDriver driver, String listItem) {
		List<Integer> list = addElementToList(driver, listItem);
		Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
		for (int i = 0; i < arr.length + 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkThreeProductDisplayed(WebDriver driver, String Locator) {
		List<WebElement> AllItems = getWebElements(driver, Locator);
		if(AllItems.size() <= 3) {
			return true;
		} else
			return false;
	}

	public boolean checkSixProductDisplayed(WebDriver driver, String Locator) {
		List<WebElement> AllItems = getWebElements(driver, Locator);
		if (AllItems.size() <= 6) {
			return true;
		} else
			return false;
	}

	public boolean checkNineProductDisplayed(WebDriver driver, String Locator) {
		List<WebElement> AllItems = getWebElements(driver, Locator);
		if (AllItems.size() <= 9) {
			return true;
		} else
			return false;
	}
	
	public void clickToImgNopcommerce(WebDriver driver) {
		if(driver.toString().contains("chrome")){
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserBasePageUI.NOPCOMMERCE_IMG);
		clickToElement(driver, UserBasePageUI.NOPCOMMERCE_IMG);
	}

	private long shortTimeout = GlobalConstants.SHORT_TIME_OUT;

	private long longTimeout = GlobalConstants.LONG_TIME_OUT;

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
