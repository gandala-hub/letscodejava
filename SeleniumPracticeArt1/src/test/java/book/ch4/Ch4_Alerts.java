 package book.ch4;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.slnm.practice.main.Engine;


public class Ch4_Alerts extends Engine {
	
	
	@BeforeTest
	void setup() {
		  
		   driver.get("https://demoqa.com/alerts");
		   driver.manage().window().maximize();

	}

	@Test
	public void AlertTest() {
		  // This step will result in an alert on screen
		    driver.findElement(By.id("alertButton")).click();
		    Alert simpleAlert = driver.switchTo().alert();
		    simpleAlert.accept();
	}
	
	
	@Test
	public void AlertTxtTest() {
		  // This step will result in an alert on screen
		   WebElement element = driver.findElement(By.id("promtButton"));
		   element.click();
		   //((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		   Alert promptAlert  = driver.switchTo().alert();
		   String alertText = promptAlert.getText();
		   System.out.println("Alert text is " + alertText);
		  //Send some text to the alert
		   promptAlert.sendKeys("Test User : Giribabu");
		   promptAlert.accept();
	}
	
	


		
}
