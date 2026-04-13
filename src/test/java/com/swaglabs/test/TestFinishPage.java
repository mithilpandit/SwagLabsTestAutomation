package com.swaglabs.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.PageCart;
import com.swaglabs.pages.PageCheckoutInfo;
import com.swaglabs.pages.PageFinish;
import com.swaglabs.pages.PageHome;
import com.swaglabs.pages.PageLogin;

public class TestFinishPage extends BaseClass {
	
	PageLogin pl;
	PageHome ph;
	PageCart pc;
	PageCheckoutInfo pci;
	PageFinish pf;
	
	public TestFinishPage()
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
		pc.checkOut();
		pci=new PageCheckoutInfo(driver);
		pci.infoPage();
		pci.click();
		pf=new PageFinish(driver);
	}
	
	@Test(priority=1)
	public void clickFinsihTest()
	{
		pf.clickFinsih();
	}
	
	@Test(priority=2)
	public void clickSignOutTest()
	{
		pf.signOut();
	}

	@AfterClass
	public void closeBrowser()
	{
		browserShut();
	}
	
}
