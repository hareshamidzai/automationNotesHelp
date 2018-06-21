package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTests {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void amazonSearchOne() {
	driver.get("http://amazon.com");
	String str ="Selenium Testing Tools Cookbook - Second Edition";
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str
	+ Keys.ENTER);
	
	// now verify tht a result with " Selenium Testing Tools Cookbookbook "
	String xpath = "//*[@id='result_0']/div/div/div/div[2]/"
			+ "div[1]/div[1]/a/h2";
	
	Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
	
	
	System.out.println(driver.findElement(By.xpath(xpath)).isDisplayed());
	// clear display
	driver.findElement(By.id("twotabsearchtextbox")).clear();
	
	// java OCA book
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA book"
			+ Keys.ENTER);
	
	Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
	
	
	
	
	
	
	}
	
	
	
	

}
