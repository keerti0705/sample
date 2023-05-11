package com.training.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityTabPage;
import com.training.pages.UserMenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OppotunityTabTest {
	WebDriver driver;
	LoginPage loginPage;
	OpportunityTabPage oppTabPage;
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
	public void OppDropDownTC15() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		oppTabPage = new OpportunityTabPage(driver);
		oppTabPage.opportunitiesTab(driver);
	}
	@Test
	public void oppPileLinkTC17() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		oppTabPage = new OpportunityTabPage(driver);
		oppTabPage.oppTabHome(driver);
		oppTabPage.oppPipeLine();
	}
	@Test
	public void stuckPileLinkTC18() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		oppTabPage = new OpportunityTabPage(driver);
		oppTabPage.oppTabHome(driver);
		oppTabPage.stuckOpp();
	}
	@Test
	public void testSumReportTC19() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		oppTabPage = new OpportunityTabPage(driver);
		oppTabPage.oppTabHome(driver);
		oppTabPage.testSumReport();
	}
	@AfterMethod
	public void afterMethod(Method method) {
		basePage.takeScreenShots(driver, method);
	}

}
