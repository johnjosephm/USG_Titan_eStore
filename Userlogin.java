

	package com.us.groceries.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	
	
	public class UserLogin{
		public WebDriver driver;
		Loginpage obj1;
		
@BeforeTest
 public void eStore()
  {
    FirefoxProfile fp = new FirefoxProfile();
	fp.setPreference("webdriver.load.strategy", "unstable"); 
	driver = new FirefoxDriver(fp);
	obj1=new Loginpage(driver);
	driver.manage().window().maximize();
	driver.navigate().refresh();
	driver.get("http://delivery-qa.walmart.com/");
	System.out.println("Page loaded");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.stop();");
  }

@Test
  public void userLogin(){
	obj1.Login_action();
  
 
  }
  
 
 @AfterTest
 public void exitBrowser()
  {
	 System.out.println("Page closed");
	 driver.quit();
      System.exit(0);
  }
 
 }

