package book.ch4;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.slnm.practice.main.Engine;

import book.test.utils.TestUtils;

public class Ch4_Frames extends Engine {
	
	
	@BeforeTest
	void setup() {
		driver.get("http://guidebook.seleniumacademy.com/Frames.html");

	}

	@Test
	public void SwitshBetweenFrames() {
		driver.switchTo().frame(0); // id 0 or Name : "frameOne"
		driver.findElement(By.name("1")).sendKeys("I'm Frame One");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);   // id 1 or Name : "frameTwo"
		driver.findElement(By.name("2")).sendKeys("I'm Frame Two");
		
	}		
}
