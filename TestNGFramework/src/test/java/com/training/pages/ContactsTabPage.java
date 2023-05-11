package com.training.pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.google.errorprone.annotations.FormatMethod;
import com.training.base.BasePage;
import com.training.log.Log;

public class ContactsTabPage extends BasePage{
	@FindBy (xpath = "//a[text()='Contacts']")
	WebElement contactsTab;
	@FindBy (xpath = "//input[@title='New']")
	WebElement newBtn;
	@FindBy (id = "name_lastcon2")
	WebElement lastName;
	@FindBy (id = "con4")
	WebElement accName;
//	@FindBy (id = "resultsFrame")
//	WebElement frame;
//	@FindBy (xpath = "//tr[@class='dataRow even']/th/a[text()='testing']")
//	WebElement searchResult;
	@FindBy (xpath = "//td[@id='topButtonRow']//input[@title='Save']")
	WebElement saveBtn;
	@FindBy (xpath = "(//a[text()='Create New View'])")
	WebElement createNewView;
	@FindBy (id = "fname")
	WebElement viewName;
	@FindBy (id = "devname")
	WebElement viewUniqueName;
	@FindBy (xpath = "(//input[@title='Save'])[1]")
	WebElement saveBtn1;
	@FindBy (xpath = "//select/option[@value='2']")
	WebElement selectDropDown;
	@FindBy (xpath = "//h3[text()='Recent Contacts']")
	WebElement recentContacts;
	@FindBy (xpath = "//option[text()='My Contacts']")
	WebElement viewDropDown;
	@FindBy (xpath = "//input[@title='Go!']")
	WebElement goBtn;
	@FindBy (xpath = "//a[text()='bhatt05']")
	WebElement recentContact;
	@FindBy (xpath = "//h2[contains(text(),'bhatt05')]")
	WebElement contactPage;
	@FindBy (xpath = "//input[@title='Save'][1]")
	WebElement saveBtn2; 
	@FindBy (xpath = "//div[@class='errorMsg'][1]")
	WebElement errorMsg;
	@FindBy (xpath= "(//input[@title='Cancel'])[1]")
	WebElement cancelBtn; 
	@FindBy (xpath = "//h2[@class='pageDescription']")
	WebElement contactsHomePage;
	@FindBy (xpath = "//input[@title='Save & New'])[2]")
	WebElement saveNewBtn;
	@FindBy (id = "errorDiv_ep")
	WebElement errorPage;
		
	public ContactsTabPage(WebDriver driver) {
		super(driver);
	}
	public void contactsTab(WebDriver driver) throws InterruptedException {
		contactsTab.click();
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
	public void createNewContact(WebDriver driver) throws InterruptedException{
		newBtn.click();
		lastName.sendKeys("bheed");
//		driver.switchTo().frame(frame);
//		searchResult.click();
		accName.sendKeys("sample28");
		DOMConfigurator.configure("log4j.xml");
		Log.info("New account created");
		saveBtn.click();
	}
	public void createNewView () throws InterruptedException{
		DOMConfigurator.configure("log4j.xml");
		createNewView.click();
		Log.info("Create New View clicked");
		viewName.sendKeys("keerti05");
		viewUniqueName.clear();
		viewUniqueName.sendKeys("contactNewView");
		saveBtn1.click();
	}
	public void selectDropDown() {
		selectDropDown.click();
	}
	public void validateRecentlyCreated() {
		String expected = recentContacts.getText();
		DOMConfigurator.configure("log4j.xml");
		Log.info("Expected page :"+expected);
		String actual = "Recent Contacts";
		assertEquals(actual, expected);
		Log.info("Values same, hence Validated");
		
	}
	public void myContacts() {
		viewDropDown.click();
	}
	public void myContactsView() {
		viewDropDown.click();
		goBtn.click();
		DOMConfigurator.configure("log4j.xml");
		Log.info("My Contacts clicked");
	}
	public void firstContact() throws InterruptedException {
		Thread.sleep(5000);
		recentContact.click();
		String actual = contactPage.getText();
		Assert.assertEquals(actual, "bhatt05");
		DOMConfigurator.configure("log4j.xml");
		Log.info("Pages same hence validated");
	}
	public void errorMsgChk() throws InterruptedException {
		Thread.sleep(5000);
		createNewView.click();
		viewUniqueName.sendKeys("EFGH");
		saveBtn2.click();
		String actual = errorMsg.getText();
		Assert.assertEquals(actual, "Error: You must enter a value");
		DOMConfigurator.configure("log4j.xml");
		Log.info("Expected error message displayed");
	}
	public void CancelBtnChk() throws InterruptedException {
		Thread.sleep(5000);
		createNewView.click();
		viewName.sendKeys("ABCD");
		viewUniqueName.sendKeys("EFGH");
		cancelBtn.click();
		String actual = contactsHomePage.getText();
		Assert.assertEquals(actual, "Home");
		DOMConfigurator.configure("log4j.xml");
		Log.info("No new contact created");
	}
	public void saveNewBtnChk() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		Thread.sleep(5000);
		newBtn.click();
		lastName.sendKeys("Indian");
		accName.sendKeys("Global Media");
		saveBtn.click();
		String actual = errorPage.getText();
		Assert.assertEquals(actual, "Error: Invalid Data."+"\n"+"Review all error messages below to correct your data.");
		Log.info("Pages same hence validated");
	}
}
