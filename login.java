


	package com.us.groceries.main;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;


	public class Loginpage {
	
		public WebDriver driver;
		
		
		public Loginpage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	
		
	@FindBy(css=".primary-nav__link.link__flush-right.text-small.margin-top.on-medium")
	WebElement signin_link;

	@FindBy(css="#EmailID")
	WebElement user_email;

	@FindBy(css="#PasswordPin")
	WebElement password;

	@FindBy(css=".button.button--primary")
	WebElement signin_button;

	@FindBy(xpath="//li[1]/span[@class = 'primary-nav__link navbar__callout-text']")
	WebElement signin_username;

	@FindBy(xpath =".//div[2][@id='serverSideErrors']")
	WebElement serverSideErrors;
			
	String username = "johnusgqa@gmail.com";
	String userpassword = "test123";
	String homepage = "http://delivery-qa.walmart.com/usd-estore/m/home.jsp";

	
	public void Login_action()
	 {
		 System.out.println("inside main");
		    signin_link.click();
		    System.out.println("click");
			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(user_email));
		    
			System.out.println(driver.getCurrentUrl());		
			
			user_email.sendKeys(username);
			password.sendKeys(userpassword);
			signin_button.click();
			if (driver.getCurrentUrl().contains(homepage))
			{
			System.out.println(signin_username.getText());
			}
			else
			{
			System.out.println(serverSideErrors.getText());
			}
	
	 }
	}
	
	
	
