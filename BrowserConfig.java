package com.Basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

	public static void main(String[] args) {
		
	/*
	 * step 1: Launch Browser
	 * step 2: Open test Site
	 * step 3: Test
	 * WebDriver: Interface
	 * driver: reference variable
	 * new = keyword
	 * FirefoxDriver() = constructor of FirefoxDriver class
	 */

		//step 1
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","D:\\Extension\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver","D:\\Extension\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//step 2
		driver.get("https://bbc.com/");
		
		
		//offline test
		driver.get("file:///D:/a1qa/Your Store.html");
		
		driver.close();
		
		//driver.quit();
	}

}
