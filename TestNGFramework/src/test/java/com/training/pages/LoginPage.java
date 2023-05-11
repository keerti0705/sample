package com.training.pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.google.errorprone.annotations.FormatMethod;
import com.training.base.BasePage;
import com.training.utilities.CommonUtilities;

public class LoginPage extends BasePage{
	@FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 username']")
	WebElement username;
	@FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 password']")
	WebElement password;
	@FindBy(xpath = "//input[@class='button r4 wide primary']")
	WebElement loginButton;
	@FindBy (id = "rememberUn")
	WebElement rememberCheckBox;
	@FindBy (xpath = "//input[@class='input r4 wide mb16 mt8 username']")
	WebElement usernameValue;
	@FindBy (xpath ="//label[text()='Remember me']")
	WebElement chechkBox;
	@FindBy(xpath = "//div[text()='Please enter your password.']")
	WebElement errorMessage;
	@FindBy(id = "userNavLabel") 
	WebElement switchToTab;
	@FindBy(xpath = "//a[@title='Logout']")
	WebElement logoutButton;
	@FindBy(id = "forgot_password_link")
	WebElement forgotPwd;
	@FindBy(xpath = "//input[@class='input wide mb12 mt8 username']")  
	WebElement invalidUserName;
	@FindBy(xpath = "//input[@value='Continue']")  
	WebElement continueButton;
	@FindBy(id = "error") 
	WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
	  super(driver); 
	}
	public void enterUserName() {
		username.sendKeys("selenium@gm.com");
	}
	public void enterPassword() {
		password.sendKeys("salesforce05");
	}
	public void rememberMe() {
		rememberCheckBox.click();
	}
	public void enterIncorrectPassword() {
		password.sendKeys("");

	}
	public void wrongUserName() {
		username.sendKeys("123");

	}
	public void wrongPassword() {
		password.sendKeys("22131");
	}
	public void errorMsgUsernamePwd() {
		System.out.println(errorMsg.getText());
	}
	public void errorMessage() {
		System.out.println(errorMessage.getText());

	}
	public void clickLogin() {
		loginButton.click();
	}
	public void switchToTabUserName(WebDriver driver) {
		waitforVisibility(10, switchToTab);
		Actions actions = new Actions(driver);
		actions.moveToElement(switchToTab).build().perform();
		switchToTab.click();
		waitforVisibility(20, logoutButton);
		logoutButton.click();
	}
	public void UserNameDropdown(WebDriver driver) {
		waitforVisibility(10, switchToTab);
		Actions actions = new Actions(driver);
		actions.moveToElement(switchToTab).build().perform();
		switchToTab.click();
		waitforVisibility(20, logoutButton);
	}
	
	public void forgotPwd() {
		forgotPwd.click();

	}
	public void invalidUserName() {
		invalidUserName.sendKeys("sample@gm.com");
		continueButton.click();
	}
	public void validate() {
		String str = usernameValue.getText();
		System.out.println(str);
		if(str.equalsIgnoreCase("selenium@gm.com"))
			System.out.println("Values same hence validated");
		System.out.println(chechkBox.getText());
	}
	public void takeScreenShots(WebDriver driver, Method method) {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-mm-dd").format(date);
		String path = "C:\\Users\\15105\\eclipse-workspace\\TestNGFramework\\screenshots\\Tekarch "+timeStamp+""+method.getName()+".jpeg";
		File dstFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
