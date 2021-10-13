package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	Select select;

	String email = "dark" + RandomInt() + "@gmail.com";
	String username = "automatiom1" + RandomInt();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		driver.findElement(By.cssSelector(".ico-user.sprite-image")).click();
		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmEmail-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Username-error")).getText(), "Username is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Hihihi");
		driver.findElement(By.cssSelector("#Email")).sendKeys(email + "#");
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(email);
		driver.findElement(By.cssSelector("#Username")).sendKeys("Automation65412");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123123");
		driver.findElement(By.cssSelector("#Username")).sendKeys("123123");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Hihihi");
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(email);
		driver.findElement(By.cssSelector("#Username")).sendKeys(username);
		driver.findElement(By.cssSelector("#Password")).sendKeys("123123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123123");
		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyIndustryId")));
		select.selectByVisibleText("Other");

		select = new Select(driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseId")));
		select.selectByVisibleText("Other");

		driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseText")).sendKeys("abcd");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyRoleId")));
		select.selectByVisibleText("Store administrator (manager)");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanySizeId")));
		select.selectByVisibleText("More than 15");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),\"Almost\")]")).isDisplayed());

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector(".ico-user.sprite-image")).click();
		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Hihihi");
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(email);
		driver.findElement(By.cssSelector("#Username")).sendKeys(username);
		driver.findElement(By.cssSelector("#Password")).sendKeys("123123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123123");
		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyIndustryId")));
		select.selectByVisibleText("Other");

		select = new Select(driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseId")));
		select.selectByVisibleText("Other");

		driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseText")).sendKeys("abcd");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyRoleId")));
		select.selectByVisibleText("Store administrator (manager)");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanySizeId")));
		select.selectByVisibleText("More than 15");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertTrue(driver.findElement(By.xpath(
				"//div[@class='message-error validation-summary-errors']//li[text()='The specified email already exists']"))
				.isDisplayed());

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector(".ico-user.sprite-image")).click();
		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Hihihi");
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(email);
		driver.findElement(By.cssSelector("#Username")).sendKeys(username);
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123");
		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyIndustryId")));
		select.selectByVisibleText("Other");

		select = new Select(driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseId")));
		select.selectByVisibleText("Other");

		driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseText")).sendKeys("abcd");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyRoleId")));
		select.selectByVisibleText("Store administrator (manager)");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanySizeId")));
		select.selectByVisibleText("More than 15");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error li")).getText(),
				"must have at least 6 characters");

	}

	@Test
	public void TC_06__Register_Wrong_Confirm_Password() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector(".ico-user.sprite-image")).click();
		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Hihihi");
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys("ahi" + email);
		driver.findElement(By.cssSelector("#Username")).sendKeys(username + "123");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123qwd");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123qwe");
		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyIndustryId")));
		select.selectByVisibleText("Other");

		select = new Select(driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseId")));
		select.selectByVisibleText("Other");

		driver.findElement(By.cssSelector("#Details_NopCommerceIntendedUseText")).sendKeys("abcd");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanyRoleId")));
		select.selectByVisibleText("Store administrator (manager)");

		select = new Select(driver.findElement(By.cssSelector("#Details_CompanySizeId")));
		select.selectByVisibleText("More than 15");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int RandomInt() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
