package com.swaglabs.test;

import org.testng.annotations.*;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.PageLogin;
import com.swaglabs.utility.ExcelUtility;

public class TestPageLogin extends BaseClass {
	
	PageLogin pl;
	
	public TestPageLogin()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driverSetup();
		pl=new PageLogin(driver);
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData()
	{
	    ExcelUtility excel = new ExcelUtility();
	    return excel.excelRead();
	}
	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pwd)
	{
		pl.login(uname, pwd);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		browserShut();
	}
}
