package com.swaglabs.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.PageCart;
import com.swaglabs.pages.PageHome;
import com.swaglabs.pages.PageLogin;

public class TestCartPage extends BaseClass {
	
	PageLogin pl;
	PageHome ph;
	PageCart pc;
	
	public TestCartPage()
	{
		super();
	}
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		driverSetup();
		pl=new PageLogin(driver);
		pl.login("standard_user", "secret_sauce");
		ph=new PageHome(driver);
		ph.itemSearch();
		ph.buttonClick();
		ph.cartClick();
		pc=new PageCart(driver);
	}

	@Test
	public void checkOutTest() throws InterruptedException
	{
		pc.checkOut();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		browserShut();
	}

}
