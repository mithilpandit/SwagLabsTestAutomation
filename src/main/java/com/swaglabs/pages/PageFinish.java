package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaglabs.wait.DriverWait;

public class PageFinish {
	
	WebDriver driver;
	DriverWait wait;
	
	public PageFinish(WebDriver driver)
	{
		this.driver=driver;
		wait=new DriverWait(driver);
	}
	
	By finish=By.xpath("//div[@class='cart_footer']/child::button[@name='finish']");
	By burgerBtn=By.xpath("//div[@class='bm-burger-button']/child::button[@id='react-burger-menu-btn']");
	By logout=By.xpath("//div[@class='bm-menu-wrap']/descendant::a[@id='logout_sidebar_link']");
	
	public void clickFinsih()
	{
		wait.myWait.until(ExpectedConditions.elementToBeClickable(finish)).click();
	}
	
	public void signOut()
	{
		driver.findElement(burgerBtn).click();
		wait.myWait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}

}
