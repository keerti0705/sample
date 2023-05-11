package com.training.pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.training.base.BasePage;
import com.training.log.Log;

public class RandomScenariosPage extends BasePage{
	BasePage basePage;
	@FindBy (xpath = "//a[@title='Home Tab']")
	WebElement homeTab;
	@FindBy (xpath = "//h1/a[text()='keerti ABCD@@$']")
	WebElement nameLink;
//	@FindBy (id = "tryLexDialogX")
//	WebElement closeWnd;
//	@FindBy (xpath = "//input[contains(@value,'New')]")
//	WebElement newAccounts;
//	@FindBy (id = "acc2")
//	WebElement accName;
//	@FindBy (xpath = "//option[@value='Technology Partner']")
//	WebElement type;
//	@FindBy (xpath = "//select/option[text()='High']")
//	WebElement priority;
//	@FindBy (xpath = "//input[@title='Save']")
//	WebElement saveButton;
//	@FindBy (xpath = "//a[text()='Create New View']")
//	WebElement createNewLink;
//	@FindBy (id = "fname")
//	WebElement viewName;
//	@FindBy (id = "devname")
//	WebElement viewUniqueName;
//	@FindBy (xpath = "//select[@id='fcf']/option[@selected='selected']")
//	WebElement selectedViewName;
//	@FindBy (xpath = "//input[contains(@value,'Save')]")
//	WebElement saveButton1;
//	@FindBy (xpath = "//select/option[text()='march']")
//	WebElement viewDropDownValue;
//	@FindBy (xpath = "//a[text()='Edit']")
//	WebElement editButton;
//	@FindBy (id = "fname")
//	WebElement editViewName;
//	@FindBy (id = "devname")
//	WebElement editViewUniqueName;
//	@FindBy (xpath = "//select[@id='fcol1']/option[text()='Account Name']")
//	WebElement field1;
//	@FindBy (xpath = "//select[@id='fop1']/option[@value='c']")
//	WebElement field2;
//	@FindBy (id = "fval1")
//	WebElement field3;
//	@FindBy (xpath = "(//input[@title='Save'])[2]")
//	WebElement saveButton2;
//	@FindBy (xpath = "//a[text()='Merge Accounts']")
//	WebElement mergeAccs;
//	@FindBy (id = "srch")
//	WebElement searchAcc;
//	@FindBy (xpath = "//input[@value='Find Accounts']")
//	WebElement findAccsButton;
//	@FindBy (xpath = "//input[@title='Next' and @name='goNext']")
//	WebElement nextButton;
//	@FindBy (xpath = "(//input[@title='Merge'])[2]")
//	WebElement mergeButton;
//	@FindBy (xpath = "//a[@title='My Profile']")
//	WebElement myProfile;
//	@FindBy (xpath = "//a[@class='contactInfoLaunch editLink']")
//	WebElement editProfile;
//	@FindBy (id = "contactInfoTitle")
//	WebElement editProfilePage;
//	@FindBy (id = "contactInfoContentId")
//	WebElement frame;
//	@FindBy (id = "aboutTab")
//	WebElement aboutTab;
//	@FindBy (xpath = "//input[@id='lastName']")
//	WebElement lastName;
//	@FindBy (xpath = "//input[@value='Save All']")
//	WebElement saveAllButton;
//	@FindBy (xpath = "//span[text()='Post']")
//	WebElement postLink;
//	@FindBy (xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
//	WebElement iframePost;
//	@FindBy (xpath = "//body[contains(text(),'Share an update')]")
//	WebElement textareaPost;
//	@FindBy (xpath = "//input[@id='publishersharebutton']")
//	WebElement shareButton;
//	@FindBy (xpath = "//span[text()='File']")
//	WebElement fileLink;
//	@FindBy (id = "chatterUploadFileAction")
//	WebElement fileFromComputer;
//	@FindBy (xpath = "//input[@id='chatterFile']")
//	WebElement fileToUpload;
//	@FindBy (xpath = "//a[text()='Accounts with last activity > 30 days']")
//	WebElement reportsLink;
//    @FindBy	(id = "ext-gen148")
//	WebElement dropDown; 
//    @FindBy (xpath = "//div[text()='Created Date']")
//    WebElement dateField;
//    @FindBy (id = "ext-gen152")
//    WebElement range; 
//    @FindBy (id = "ext-gen281")
//    WebElement fromTodayButton;
//    @FindBy (id = "ext-gen154")
//    WebElement range1; 
//    @FindBy (id = "ext-gen296")
//    WebElement toTodayButton; 
//    @FindBy (id = "ext-gen63")
//    WebElement runReport; 
//	
//    @FindBy (id = "ext-gen49")
//    WebElement saveBtn;
//    @FindBy (id = "saveReportDlg_reportNameField")
//    WebElement reportName;
//    @FindBy (id = "saveReportDlg_DeveloperName")
//    WebElement reportUniqueName;
//    @FindBy (xpath = "//button[text()='Save and Run Report']")
//    WebElement saveRunReport;
    
	public RandomScenariosPage(WebDriver driver) {
		  super(driver); 
		}
	public void homeTab(WebDriver driver) throws InterruptedException {
		homeTab.click();
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
		String actual = nameLink.getText();
		DOMConfigurator.configure("log4j.xml");
		Assert.assertEquals(actual, "keerti ABCD@@$");
		Log.info("Link displayed correctly");
		nameLink.click();
		Thread.sleep(5000);
		String strTitle = driver.getTitle();
		System.out.println("Title: "+strTitle);
		Assert.assertEquals(strTitle, "User: keerti ABCD@@$ ~ Salesforce - Developer Edition");
		Log.info("Profile page displayed");
	}
	/*public void myProfile() throws InterruptedException {
		myProfile.click();
		Thread.sleep(5000);
	}
	public void editProfile(WebDriver driver) throws InterruptedException {
		editProfile.click();
		Thread.sleep(5000);
		Actions actionProfile = new Actions(driver);
		actionProfile.moveToElement(editProfilePage);
		driver.switchTo().frame(frame);
		aboutTab.click();
		lastName.sendKeys("$");
		saveAllButton.click();
		postLink.click();
		driver.switchTo().frame(iframePost);
		textareaPost.sendKeys("Welcome Salesforce");
		driver.switchTo().defaultContent();
		shareButton.click();
		Thread.sleep(5000);		
		fileLink.click();
		fileFromComputer.click();
		Thread.sleep(5000);
		fileToUpload.sendKeys("C:\\Users\\15105\\Desktop\\keerti\\Assignments\\Assign3.png");
		shareButton.click();

	}
	public void UserName(WebDriver driver) throws InterruptedException {
		waitforVisibility(10, switchToTab);
		Actions actions = new Actions(driver);
		actions.moveToElement(switchToTab).build().perform();
		switchToTab.click();
		Thread.sleep(5000);
		developerConsole.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}
	public void AccTab(WebDriver driver) throws InterruptedException {
		accountsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		System.out.println(windows.size());
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}
	public void accountsTab(WebDriver driver) throws InterruptedException {
		accountsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		System.out.println(windows.size());
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		newAccounts.click();
		accName.sendKeys("March26");
		type.click();
		priority.click();
		saveButton.click();
	}
	public void createNewView(WebDriver driver) throws InterruptedException {
		accountsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		System.out.println(windows.size());
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		createNewLink.click();
		createNewLink.clear();
		viewName.sendKeys("march28");
		viewUniqueName.sendKeys("march28unique");
		saveButton1.click();
	}
	public void validateCreatedAcc() {
		String strExpected = "march28unique";
		Select select = new Select(selectedViewName); 
		String strActual = select.getFirstSelectedOption().getText();
		assertEquals(strActual, strExpected);
		DOMConfigurator.configure("log4j.xml");
		Log.info("New View validated");
	}
	public void editView(WebDriver driver) throws InterruptedException {
		accountsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		System.out.println(windows.size());
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		viewDropDownValue.click();
		editButton.click();
		editViewName.sendKeys("March26ViewName");
		editViewUniqueName.sendKeys("March26UniqueName");
		field1.click();
		field2.click();
		field3.click();
		saveButton2.click();
	}
	public void mergeAccs(WebDriver driver) throws InterruptedException {
		accountsTab.click();
		String homeWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator it = windows.iterator();
		System.out.println(windows.size());
		String currentWindow;
		while(it.hasNext()) {
			currentWindow = it.next().toString();
			if(currentWindow.equals(homeWindow)) {
				Thread.sleep(5000);
				closeWnd.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		mergeAccs.click();
		searchAcc.sendKeys("cell");
		findAccsButton.click();
		Thread.sleep(5000);
		nextButton.click();
		mergeButton.click();
		driver.switchTo().alert().accept();
	}
	public void reportsLink() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		reportsLink.click();
		Thread.sleep(5000);
		dropDown.click();
		Log.info("Date Field selected");
		dateField.click();
		range.click();
		waitforVisibility(5, range);
		fromTodayButton.click();
		Thread.sleep(5000);
		Log.info("From date selected");
		range1.click();
		Thread.sleep(5000);
		waitforVisibility(5, range1);
		toTodayButton.click();
		Thread.sleep(1000);
		Log.info("To date selected");
		saveBtn.click();
		Thread.sleep(5000);
		reportName.sendKeys("sampleReport");
		Thread.sleep(5000);
		Log.info("Report Name enetered");
		//Select reportUniqueName1 = new Select(reportUniqueName);
		//reportUniqueName1.selectByVisibleText(reportUniqueName.getText());
		//reportUniqueName.selectByVisibleText("sampleReport");
		reportUniqueName.clear();
		reportUniqueName.sendKeys("uniqueReport");
		Log.info("Unique name entered");
		Thread.sleep(5000);
		saveRunReport.click();
		Thread.sleep(5000);
		//runReport.click();
	}*/
	
}