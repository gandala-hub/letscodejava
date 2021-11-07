package com.book.sample.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "/usr/local/");
		driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.get("http://demo-store.seleniumacademy.com/");	
	}
	
	@Test
	public void serachProduct() {
		WebElement serachBox = driver.findElement(By.name("q"));
		serachBox.sendKeys("Phones");
		driver.findElement(By.className("button")).click();
		screenshotTest();
	
	}
	
	
	public void screenshotTest() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("/Users/Giri/eclipse-workspace/SeleniumTests/scrshot.jpg");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@AfterMethod
	public void tearDwon() {
	//	driver.close();
	}
	
	
}