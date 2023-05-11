package com.training.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class OpportunityTabPage extends BasePage{
	@FindBy (xpath = "//a[@title='Opportunities Tab']")
	WebElement opportunitiesTab;
	@FindBy (id = "fcf")
	WebElement originalDropdown;
	@FindBy (xpath = "//a[text()='Opportunity Pipeline']")
	WebElement oppPipeLink;
	@FindBy (xpath = "//a[text()='Stuck Opportunities']")
	WebElement stuckOpp;
	@FindBy (xpath = "//option[@value='current']")
	WebElement interval;
	@FindBy (xpath = "//option[@value='all']")
    WebElement include;
    @FindBy  (xpath = "//input[@title='Run Report']")
    WebElement runReport;
    
        
	public OpportunityTabPage(WebDriver driver) {
		super(driver);
	}
	public void oppTabHome(WebDriver driver) throws InterruptedException {
		opportunitiesTab.click();
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
	public void opportunitiesTab(WebDriver driver) throws InterruptedException {
		opportunitiesTab.click();
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
		Select original = new  Select(originalDropdown);
		List<WebElement> originalListElements = original.getOptions();
		List<String> originalList = new ArrayList<String>();
		for (WebElement webElement : originalListElements) {
			originalList.add(webElement.getText());
		}
		List<String> targetList = new ArrayList<String>();
		targetList.add("All Opportunities");
		targetList.add("Closing Next Month");
		targetList.add("Closing This Month");
		targetList.add("My Opportunities");
		targetList.add("New Last Week");
		targetList.add("New This Week");
		targetList.add("Opportunity Pipeline");
		targetList.add("Private");
		targetList.add("Recently Viewed Opportunities");
		targetList.add("Won");
		
		Assert.assertEquals(originalList, targetList); 
		System.out.println("Values equal");
	}
	public void oppPipeLine() {
		oppPipeLink.click();
	}
	public void stuckOpp() {
		stuckOpp.click();
	}
	public void testSumReport() {
		interval.click();
		include.click();
		runReport.click();
	}

}
