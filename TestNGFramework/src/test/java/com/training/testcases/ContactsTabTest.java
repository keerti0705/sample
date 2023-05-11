package com.training.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.pages.ContactsTabPage;
import com.training.pages.LeadsTabPage;
import com.training.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactsTabTest {
	WebDriver driver;
	LoginPage loginPage;
	ContactsTabPage contactsTabPage;
	BasePage basePage;
	String sTestName;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		contactsTabPage = new ContactsTabPage(driver);
		basePage = new BasePage(driver);
	}
	@Test
	public void createNewContactTC25() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.createNewContact(driver);
	}
	@Test
	public void createNewViewTC26 () throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.createNewView();
	}
	@Test
	public void recentlyCreatedTC27() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.selectDropDown();
		contactsTabPage.validateRecentlyCreated();
	}
	@Test
	public void myContactsPageTC28() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.myContactsView();
	}
	@Test
	public void contactTC29() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.firstContact();
	}
	@Test
	public void errMsgChkTC30() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.errorMsgChk();
	}
	@Test
	public void CancelBtnChkTC31() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.CancelBtnChk();
	}
	@Test
	public void saveNewBtnChkTC32() throws InterruptedException {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		contactsTabPage.contactsTab(driver);
		contactsTabPage.saveNewBtnChk();
	}
	
	@AfterMethod
	public void afterMethod(Method method) {
		basePage.takeScreenShots(driver, method);
		driver.close();

	}

}
