package com.swaglabs.wait;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
	
	public WebDriver driver;
	public WebDriverWait myWait;
	
	public DriverWait(WebDriver driver)
	{
		this.driver=driver;
		myWait=new WebDriverWait(driver, Duration.ofSeconds(25));
	}

}
