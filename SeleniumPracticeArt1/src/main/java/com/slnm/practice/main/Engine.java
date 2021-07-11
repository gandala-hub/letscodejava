package com.slnm.practice.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import com.slnm.practice.util.SrcUtil;



public class Engine {
	
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public Engine() {

		System.out.println("webdriver.chrome.driver value" + System.getenv("webdriver.chrome.driver"));
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		
		//ChromeOptions ChOpts= new ChromeOptions().setExperimentalOption("autofill.enabled", false);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(SrcUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(SrcUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	
	}

}
