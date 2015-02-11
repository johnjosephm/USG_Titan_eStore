package com.us.groceries.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyZipcode {

	public static void main(String[] args) 
	{
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("webdriver.load.strategy", "unstable"); 
		WebDriver driver = new FirefoxDriver(fp);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("http://delivery-qa.walmart.com/");
		driver.findElement(By.cssSelector("#verifyAddress-zip")).sendKeys("94403");
		driver.findElement(By.xpath("//input[@id='verifyAddress-button' and @class = 'button button--primary']")).click();
		
		if (driver.getCurrentUrl().contains("http://delivery-qa.walmart.com/usd-estore/m/home.jsp"))
		{
		System.out.println(driver.findElement(By.cssSelector(".modal__window.modal__window--small>h2")).getText());
		System.out.println(driver.findElement(By.cssSelector(".modal__window.modal__window--small>p")).getText());
		driver.findElement(By.cssSelector(".modal__window__close")).click();
		}
		
		else if (driver.getCurrentUrl().contains("http://delivery-qa.walmart.com/usd-estore/m/home/addressunavailable.jsp"))
		{
			System.out.println(driver.findElement(By.cssSelector(".home.anonymous.maxwidth>h2")).getText());
			driver.findElement(By.cssSelector("#verifyEmail")).sendKeys("jj@gmail.com");
			driver.findElement(By.cssSelector("#verifyEmail-button")).click();
			driver.findElement(By.cssSelector(".home.anonymous.maxwidth>p>a")).click();
		}
		
		else
		{
			driver.findElement(By.cssSelector("#verifyAddress-street")).sendKeys("13762 colorado Blvd");
			driver.findElement(By.cssSelector("#verifyAddress-aptno")).sendKeys("6914");
			driver.findElement(By.cssSelector("#verifyAddress-city")).sendKeys("Thornton");
			new Select(driver.findElement(By.cssSelector("#verifyAddress-state"))).selectByVisibleText("CO");
			driver.findElement(By.xpath("//footer[@class='row button-row']/div[1]/button[@class='button button--primary']")).click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='address_1' and @class = 'clarify--radiobtn']")));
			driver.findElement(By.xpath("//input[@id='address_1' and @class = 'clarify--radiobtn']")).click();
			driver.findElement(By.xpath("//input[@id='aptNumber' and @class = 'field']")).sendKeys("6914");
			driver.findElement(By.cssSelector(".button.button--primary.button--block")).click();
			System.out.println(driver.findElement(By.cssSelector(".modal__window.modal__window--small>h2")).getText());
		}
		
		
		
		}
	}


