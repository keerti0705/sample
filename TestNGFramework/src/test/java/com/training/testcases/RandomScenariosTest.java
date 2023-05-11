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
import com.training.pages.RandomScenariosPage;
import com.training.pages.UserMenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomScenariosTest {
	WebDriver driver;
	LoginPage loginPage;
	RandomScenariosPage randomScenariosPage;
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
	public void firstLastNameChkTC33() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		randomScenariosPage = new RandomScenariosPage(driver);
		randomScenariosPage.homeTab(driver);
	}
	@Test
	public void TC34() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		randomScenariosPage = new RandomScenariosPage(driver);
		randomScenariosPage.homeTab(driver);
	}
	@AfterMethod
	public void tearDown(Method method) {
		basePage = new BasePage(driver);
		basePage.takeScreenShots(driver, method);
		driver.close();
	}

}
