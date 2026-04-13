package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.swaglabs.wait.DriverWait;

public class PageHome {
	
	WebDriver driver;
	JavascriptExecutor js;
	DriverWait wait;
	
	public PageHome(WebDriver driver)
	{
		this.driver=driver;
		wait=new DriverWait(driver);
	}
	
	By drpdownClick=By.xpath("//select[@class='product_sort_container']");
	By text=By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Fleece Jacket']");
	By addBtn=By.xpath("//div[@class='pricebar']/child::button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	By clickCartBtn=By.xpath("//div[@class='shopping_cart_container']/child::a[@class='shopping_cart_link']");
	
	public void itemSearch() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement drpDown= wait.myWait.until(ExpectedConditions.elementToBeClickable(drpdownClick));
		Select sel=new Select(drpDown);
		sel.selectByValue("lohi");
		Thread.sleep(1000);
		WebElement element=wait.myWait.until(ExpectedConditions.elementToBeClickable(text));
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(1000);
	}
			
	public void buttonClick()
	{
		driver.findElement(addBtn).click();
	}
	
	public void cartClick() throws InterruptedException
	{
		WebElement cart=driver.findElement(clickCartBtn);
		js=(JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", cart);
		Thread.sleep(1000);
		driver.findElement(clickCartBtn).click();
	}

}
