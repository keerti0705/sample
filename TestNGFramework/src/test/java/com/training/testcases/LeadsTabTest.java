package com.training.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.pages.LeadsTabPage;
import com.training.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsTabTest {
	WebDriver driver;
	LoginPage loginPage;
	LeadsTabPage leadsTabPage;
	BasePage basePage;
	String sTestName;
	
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
	public void leadsTabTC20() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage = new LeadsTabPage(driver);
		leadsTabPage.leadsHome(driver);
	}
	@Test
	public void leadsSelectViewTC21() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage = new LeadsTabPage(driver);
		leadsTabPage.leadsHome(driver);
		leadsTabPage.leadSelectView(driver, sTestName);
	}
	@Test
	public void defaultViewLeadsTabTC22() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage = new LeadsTabPage(driver);
		leadsTabPage.leadsHome(driver);
		leadsTabPage.openLeads();
		loginPage.switchToTabUserName(driver);
		Thread.sleep(5000);
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage.secondTimeLeadsTab();
	}
	@Test
	public void todaysLeadsViewTC23() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage = new LeadsTabPage(driver);
		leadsTabPage.leadsHome(driver);
		leadsTabPage.todaysLeads();
		
	}
	@Test
	public void createNewLeadTC24() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		leadsTabPage = new LeadsTabPage(driver);
		leadsTabPage.leadsHome(driver);
		leadsTabPage.createNewLead();
	}
	@AfterMethod
	public void afterMethod(Method method) {
		basePage.takeScreenShots(driver, method);
		driver.close();

	}
}
