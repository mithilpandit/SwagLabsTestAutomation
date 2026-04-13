package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaglabs.wait.DriverWait;

public class PageCheckoutInfo {
	
	WebDriver driver;
	DriverWait wait;
	
	public PageCheckoutInfo(WebDriver driver)
	{
		this.driver=driver;
		wait=new DriverWait(driver);
	}
	
	By fname=By.id("first-name");
	By lname=By.name("lastName");
	By postalCode=By.id("postal-code");
	By continueBtn=By.xpath("//input[@id='continue']");
	
	public void infoPage()
	{
		wait.myWait.until(ExpectedConditions.presenceOfElementLocated(fname)).sendKeys("abcd");
		wait.myWait.until(ExpectedConditions.elementToBeClickable(lname)).sendKeys("xyz");
		wait.myWait.until(ExpectedConditions.elementToBeClickable(postalCode)).sendKeys("400050");
	}
	
	public void click()
	{
		wait.myWait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	}

}
