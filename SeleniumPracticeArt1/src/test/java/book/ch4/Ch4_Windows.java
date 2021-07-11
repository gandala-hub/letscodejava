 package book.ch4;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.slnm.practice.main.Engine;

import book.test.utils.TestUtils;

public class Ch4_Windows extends Engine {
	
	
	@BeforeTest
	void setup() {
		driver.get("http://guidebook.seleniumacademy.com/Window.html");

	}

	@Test
	public void WindowHanleTest() {
		String FirstWindow = driver.getWindowHandle();
		System.out.println("FirstWindow   :  " + FirstWindow);
		
		WebElement link = driver.findElement(By.linkText("Google Search"));
		link.click();
		
		String SecondtWindow = driver.getWindowHandle();
		System.out.println("SecondtWindow   :  " + SecondtWindow);
		System.out.println("Total Windwo Handles  :  " + driver.getWindowHandles().size());
		
		Iterator<String> it = driver.getWindowHandles().iterator();
		
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	
		//driver.switchTo().window(FirstWindow);
	}
	

		
}
