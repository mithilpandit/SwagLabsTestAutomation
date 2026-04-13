package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaglabs.wait.DriverWait;

public class PageCart {
	
	WebDriver driver;
	DriverWait wait;
	
	public PageCart(WebDriver d)
	{
		this.driver=d;
		wait=new DriverWait(driver);
	}
	
	By checkOut=By.xpath("//div[@class='cart_footer']/child::button[@id='checkout']");
	
	public void checkOut() throws InterruptedException
	{
		//Thread.sleep(3000);
		wait.myWait.until(ExpectedConditions.elementToBeClickable(checkOut)).click();
	}

}
