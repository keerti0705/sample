package com.training.pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.training.base.BasePage;

public class LeadsTabPage extends BasePage {
	@FindBy (xpath = "//a[@title='Leads Tab']")
	WebElement leadsTab;
	@FindBy (xpath = "//option[text()='All Open Leads']")
	WebElement openLeads;
	@FindBy (xpath = "//option[text()='My Unread Leads']")
	WebElement unreadLeads;
	@FindBy (xpath = "//option[text()='Recently Viewed Leads']")
	WebElement recentlyViewedLeads;
	@FindBy (xpath = "//option[@value='00BDm0000046ZwE']")
	WebElement todayLeads;
	@FindBy (xpath = "//option[text()='View - Custom 1']")
	WebElement customLeads;
	@FindBy (xpath = "//option[text()='View - Custom 2']")
	WebElement custom2Leads;
	@FindBy (xpath = "//input[@title='New']")
	WebElement newBtn;
	@FindBy (id = "name_lastlea2")
	WebElement lastName;
	@FindBy (id = "lea3")
	WebElement cmpyName;
	@FindBy (xpath = "//input[@title='Save']")
	WebElement saveBtn;
	
	public LeadsTabPage(WebDriver driver) {
		super(driver);
	}
	public void leadsHome(WebDriver driver) throws InterruptedException {
		leadsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				WebElement closeWnd = driver.findElement(By.id("tryLexDialogX"));
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
	}
	public void openLeads() {
		openLeads.click();
	}
	public void todaysLeads() {
		todayLeads.click();
	}
	public void leadSelectView(WebDriver driver, String sTestName) throws InterruptedException {
		openLeads.click();
		takeScreenShots(driver, sTestName);
		waitforVisibility(5, openLeads);
		//Thread.sleep(5000);
		unreadLeads.click();
		takeScreenShots(driver, sTestName);
		Thread.sleep(5000);
		recentlyViewedLeads.click();
		takeScreenShots(driver, sTestName);
		Thread.sleep(5000);
		todayLeads.click();
		takeScreenShots(driver, sTestName);
		Thread.sleep(5000);
		customLeads.click();
		takeScreenShots(driver, sTestName);
		Thread.sleep(5000);
		custom2Leads.click();
	}
	public void secondTimeLeadsTab() {
		leadsTab.click();
	}
	public void createNewLead() throws InterruptedException {
		newBtn.click();
		lastName.sendKeys("ABCD");
		cmpyName.sendKeys("ABCD");
		Thread.sleep(5000);
		saveBtn.click();
	}
	public void takeScreenShots(WebDriver driver, String sTestName) {
		sTestName = "leadsSelectViewTC21";
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(date);
		String path = "C:\\Users\\15105\\eclipse-workspace\\TestNGFramework\\screenshots\\Tekarch "+timeStamp+""+sTestName+".jpeg";
		File dstFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
