package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestNG {
	
	WebDriver driver;
	
  @BeforeMethod
  public void openTestURL()
  {
	  driver.get("https://www.saucedemo.com/");
  }
  
  @AfterMethod
  public void closeTestTab()
  {
	  driver.close();
  }
  
  @BeforeTest
  public void browserConfig()
  {
	  System.setProperty("webdriver.gecko.driver","D:\\Extension\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
  }
  
  @Test
  public void login()
  {
	  WebElement Name = driver.findElement(By.id("user-name"));
		
		WebElement Password = driver.findElement(By.name("password"));
		
		WebElement LoginBtn = driver.findElement(By.cssSelector("#login-button"));
		
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
  
  @AfterTest
  public void closeTest()
  {
	  driver.quit();
  }
}
