package com.swaglabs.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	Properties prop;
	public WebDriver driver;
	
	public BaseClass()
	{
		prop=new Properties();
		try {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/swaglabs/config/config.properties");
		prop.load(fs);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void driverSetup()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	public void browserShut()
	{
		driver.quit();
	}

}
