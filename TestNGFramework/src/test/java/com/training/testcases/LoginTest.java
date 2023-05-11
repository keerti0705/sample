package com.training.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {

	WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void loginTC01() {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("loginTC01");
	}
	@Test
	public void incorrectLoginTC02() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterIncorrectPassword();
		loginPage.clickLogin();
		loginPage.errorMessage();
		Thread.sleep(5000);
		}
	@Test
	public void userNameTabTC03() {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.rememberMe();
		loginPage.validate();
		loginPage.clickLogin();
		loginPage.switchToTabUserName(driver);
			
	}
	@Test
	public void forgotPwdTC04a() {
		loginPage.forgotPwd();
		loginPage.invalidUserName();
		}
	@Test
	public void incorrectUsernamePwdTC04b() {
		loginPage.wrongUserName();
		loginPage.wrongPassword();
		loginPage.clickLogin();
		loginPage.errorMsgUsernamePwd();
		}
	@Test
	public void UserNameDropDownTC05() {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		loginPage.UserNameDropdown(driver);
		}
	
	@AfterMethod
	public void afterMethod(Method method) {
		loginPage.takeScreenShots(driver, method);
		driver.close();

	}
}
