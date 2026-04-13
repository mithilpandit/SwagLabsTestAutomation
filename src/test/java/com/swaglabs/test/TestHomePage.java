package com.swaglabs.test;

import org.testng.annotations.*;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.PageHome;
import com.swaglabs.pages.PageLogin;

public class TestHomePage extends BaseClass {

	PageLogin pl;
	PageHome ph;
	
	public TestHomePage()
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
	}
	
	@Test(priority=1)
	public void itemSearchTest() throws InterruptedException
	{
		ph.itemSearch();
	}
	
	@Test(priority=2)
	public void buttonClickTest()
	{
		ph.buttonClick();
	}
	
	@Test(priority=3)
	public void cartClickTest() throws InterruptedException
	{
		ph.cartClick();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		browserShut();
	}
	
}
