package com.training.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuTest {
	WebDriver driver;
	LoginPage loginPage;
	UserMenuPage userMenuPage;
	BasePage basePage;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		basePage = new BasePage(driver);
	}
	@Test
	public void userNameTC06() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.switchToTabUserName(driver);
		userMenuPage.myProfile();
		userMenuPage.editProfile(driver);
	}
	@Test
	public void UserNameTC08() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		basePage = new BasePage(driver);
		userMenuPage.UserName(driver);
		//basePage.takeScreenShots(driver, method);

	}
	@Test
	public void accsTabTC10 () throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.accountsTab(driver);
	}
	@Test
	public void createNewViewTC11() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.createNewView(driver);
		userMenuPage.validateCreatedAcc();
	}
	@Test
	public void editViewTC12 () throws InterruptedException
	{
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.editView(driver);
	}
	@Test
	public void mergeAccsTC13() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.mergeAccs(driver);
	}
	@Test
	public void createAccReportTC14() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		userMenuPage = new UserMenuPage(driver);
		userMenuPage.AccTab(driver);
		userMenuPage.reportsLink();
	}
	@AfterMethod
	public void tearDown(Method method) {
		basePage = new BasePage(driver);
		basePage.takeScreenShots(driver, method);
		driver.close();
	}

}
