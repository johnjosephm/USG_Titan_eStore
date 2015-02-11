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
		VerifyZipcode verify = new VerifyZipcode();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("http://delivery-qa.walmart.com/");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#verifyAddress-zip")));
		driver.findElement(By.cssSelector("#verifyAddress-zip")).sendKeys("94403");
		driver.findElement(By.xpath("//input[@id='verifyAddress-button' and @class = 'button button--primary']")).click();
		
		if (driver.getCurrentUrl().contains("http://delivery-qa.walmart.com/usd-estore/m/home.jsp"))
		{
		System.out.println(driver.findElement(By.cssSelector(".modal__window.modal__window--small>h2")).getText());
		System.out.println(driver.findElement(By.cssSelector(".modal__window.modal__window--small>p")).getText());
		//driver.findElement(By.cssSelector(".modal__window__close")).click();
		
		verify.Register(driver);
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
			verify.Register(driver);
			
		}
		
	}
	
	public void Register(WebDriver driver) 
	{
		  System.out.println(driver.getCurrentUrl());	
		  driver.findElement(By.cssSelector(".button.button--secondary.js-zip-register-link")).click();
		  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#FirstName")));
		  driver.findElement(By.cssSelector("#FirstName")).sendKeys("johnny");
		  driver.findElement(By.cssSelector("#LastName")).sendKeys("boy");
		  driver.findElement(By.cssSelector("#Email")).sendKeys("qa12346@usgqa.com");
		  driver.findElement(By.cssSelector("#Password")).sendKeys("airforce1");
		  driver.findElement(By.xpath("//div[1]/input[1][@id ='verifyAddress-street']")).sendKeys("216 36th AVe");
		  driver.findElement(By.xpath("//fieldset[2]/div[2]/input[1][@id = 'verifyAddress-aptno']")).sendKeys("4202");
		  driver.findElement(By.xpath("//fieldset[2]/div[3]/input[1][@id= 'verifyAddress-city']")).sendKeys("San Mateo");
		  new Select(driver.findElement(By.xpath("//div[1]/main/div/form/fieldset[2]/div[4]/select[@id='verifyAddress-state']"))).selectByVisibleText("CA");
		  driver.findElement(By.xpath("//fieldset[2]/div[5]/input[1][@id = 'verifyAddress-zip']")).sendKeys("636007");
		  driver.findElement(By.xpath("//fieldset[2]/div[6]/input[1][@id = 'HomePhone']")).sendKeys("9944799447");
		  driver.findElement(By.xpath("//fieldset[2]/div[9]/div/span[@class = 'checkbox-toggle']")).click();
		  driver.findElement(By.xpath("//fieldset[3]/input[1][@id = 'register-button']")).click();
		  new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/p[2]/a[@href='#/usd-estore/m/home.jsp' and contains(text(),'Continue')]")));
		  driver.findElement(By.xpath("//div/p[2]/a[@href='#/usd-estore/m/home.jsp' and contains(text(),'Continue')]")).click();
		  System.out.println(driver.getCurrentUrl());
	}
	}



