package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	private WebElement getWebElement(WebDriver driver, String xpathlocator) {
		return driver.findElement(getXpath(xpathlocator));
	}

	private List<WebElement> getWebElements(WebDriver driver, String xpathlocator) {
		return driver.findElements(getXpath(xpathlocator));
	}

	private By getXpath(String xpathlocator) {
		return By.xpath(xpathlocator);
	}

	public void clickToElement(WebDriver driver, String xpathlocator) {
		getWebElement(driver, xpathlocator).click();
	}

	public void sendKeyToElement(WebDriver driver, String xpathlocator, String textValue) {
		WebElement element = getWebElement(driver, xpathlocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathlocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathlocator));
		select.selectByValue(textItem);
	}

	public String getSelectItemDefaultDropdown(WebDriver driver, String xpathlocator) {
		Select select = new Select(getWebElement(driver, xpathlocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMutiple(WebDriver driver, String xpathlocator) {
		Select select = new Select(getWebElement(driver, xpathlocator));
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

	public String getAttributeValue(WebDriver driver, String xpathlocator, String attributeName) {
		return getWebElement(driver, xpathlocator).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).getText();
	}

	public String getCssValue(WebDriver driver, String xpathlocator, String propertyName) {
		return getWebElement(driver, xpathlocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathlocator) {
		return getWebElements(driver, xpathlocator).size();
	}

	public void checkTheCheckboxOrRadio(WebDriver driver, String xpathlocator) {
		WebElement element = getWebElement(driver, xpathlocator);
		if (!element.isEnabled()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String xpathlocator) {
		WebElement element = getWebElement(driver, xpathlocator);
		if (element.isEnabled()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String xpathlocator) {
		return getWebElement(driver, xpathlocator).isEnabled();
	}

	public void switchToIframeFrame(WebDriver driver, String xpathlocator) {
		driver.switchTo().frame(getWebElement(driver, xpathlocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(WebDriver driver, String xpathlocator) {
		Actions action = new Actions(driver);
		;
		action.moveToElement(getWebElement(driver, xpathlocator)).perform();
		;
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

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String xpathlocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathlocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathlocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathlocator));
	}

	public void scrollToElement(WebDriver driver, String xpathlocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathlocator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathlocator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, xpathlocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathlocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathlocator));
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

	public String getElementValidationMessage(WebDriver driver, String xpathlocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathlocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathlocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathlocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.visibilityOfElementLocated(getXpath(xpathlocator)));
	}

	public void waitForAllsElementVisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(xpathlocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(xpathlocator)));
	}

	public void waitForAllsElementInvisible(WebDriver driver, String xpathlocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathlocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathlocator) {
		WebDriverWait explicit = new WebDriverWait(driver, longTimeout);
		explicit.until(ExpectedConditions.elementToBeClickable(getXpath(xpathlocator)));
	}

	private long shortTimeout = 5;

	private long longTimeout = 30;

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
