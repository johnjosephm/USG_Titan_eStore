package com.us.groceries.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLogin {

	public static void main(String[] args)
	{
		
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("webdriver.load.strategy", "unstable"); 
		WebDriver driver = new FirefoxDriver(fp);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("http://delivery-qa.walmart.com/");
		driver.findElement(By.cssSelector(".primary-nav__link.link__flush-right.text-small.margin-top.on-medium")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#EmailID")));
		System.out.println(driver.getCurrentUrl());		
		driver.findElement(By.cssSelector("#EmailID")).sendKeys("johnusgqa@gmail.com");
		driver.findElement(By.cssSelector("#PasswordPin")).sendKeys("test123");
		driver.findElement(By.cssSelector(".button.button--primary")).click();
		if (driver.getCurrentUrl().contains("http://delivery-qa.walmart.com/usd-estore/m/home.jsp"))
		{
		System.out.println(driver.findElement(By.xpath("//li[1]/span[@class = 'primary-nav__link navbar__callout-text']")).getText());
		}
		else
		{
		System.out.println(driver.findElement(By.xpath(".//div[2][@id='serverSideErrors']")).getText());
		}
		
	}

}
