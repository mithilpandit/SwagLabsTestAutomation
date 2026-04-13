package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaglabs.wait.DriverWait;

public class PageLogin {
	
	WebDriver driver;
	DriverWait wait;
	
	public PageLogin(WebDriver d)
	{
		this.driver=d;
		wait=new DriverWait(driver);
	}
	
	//login locators
	By username=By.id("user-name");
	By passWord=By.name("password");
	By loginBtn=By.id("login-button");
	
	//login method
	public void login(String user, String password)
	{
		wait.myWait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(user);
		wait.myWait.until(ExpectedConditions.elementToBeClickable(passWord)).sendKeys(password);
		wait.myWait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();;
	}
	
}
