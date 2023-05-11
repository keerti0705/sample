package com.training.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCB extends BaseTest {

	WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;
	
	@Parameters({"browser"})
	@Test
	public void LoginChrome(String browser) {
		System.out.println("Value from xml: "+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
		}
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("loginTC01");
	}
		
	@Parameters ({"browser"})
	@Test
	public void LoginFirefox(String value) {
		if(value.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://tekarch-bc-dev-ed.develop.my.salesforce.com/");
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
		}
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLogin();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("loginTC01");
	}
	
}
