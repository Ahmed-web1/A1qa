package com.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorDemo {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","D:\\Extension\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		WebElement Name = driver.findElement(By.id("user-name"));
		
		WebElement Password = driver.findElement(By.name("password"));
		
		WebElement LoginBtn = driver.findElement(By.cssSelector("#login-button"));
		
		//Test Case for valid name and password
		
		/*
		String ExpectedPostCondition = ("Products");
		Name.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		LoginBtn.click();
		
		String ActualTest = driver.findElement(By.cssSelector(".title")).getText();
		
		if(ExpectedPostCondition.contains(ActualTest))
		{
			System.out.println("Login success, Test case passed");
			
		}
		else
		{
			System.out.println("Test case failed, Bug found");
		}
		
		*/
		
		//Test Case for invalid name and password
		
		Name.sendKeys("test");
		Password.sendKeys("1234456");
		LoginBtn.click();
		
		String ExpectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		
		String ActualMessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();


		if(ExpectedErrorMessage.equals(ActualMessage)) 
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed, Bug found");
		}	
	}

}
