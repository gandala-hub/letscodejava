package book.ch5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.slnm.practice.main.Engine;

public class Ch5_MouseActions extends Engine {

	@BeforeTest(enabled = false)
	void setup() {

		driver.get("http://guidebook.seleniumacademy.com/Selectable.html");

	}

	
	  
	  @Test(enabled = false) 
	  public void multiSelect() {
	  
	  WebElement one = driver.findElement(By.name("one")); 
	  WebElement three = driver.findElement(By.name("three")); 
	  WebElement five = driver.findElement(By.name("five"));
	  
	  Actions actions = new Actions(driver); 
	  actions.keyDown(Keys.CONTROL)
	  		 .click(one) 
	  		 .click(three) 
	  		 .click(five) 
	  		 .keyUp(Keys.CONTROL)
	  		 .perform();
	  
	  //actions.perform();
	  
	  }
	  
	 
	
	  @Test (enabled = false) 
	  public void moveByOffset() { 
		  int boarder = 1; int tileWidth = 100; 
		  int titleHeight = 80;
	  
	  
	  
	  WebElement three = driver.findElement(By.name("one"));
	  System.out.println(three.getLocation().getX());
	  System.out.println(three.getLocation().getY());
	  
	  Actions actions1 = new Actions(driver);
	  actions1.moveByOffset(three.getLocation().getX()+(tileWidth*3)+boarder,
	  three.getLocation().getY()+(titleHeight*3)+boarder).click();
	  actions1.perform();
	  
	  Actions actions5 = new Actions(driver);
	  actions5.moveByOffset(three.getLocation().getX()-(tileWidth*3)+boarder,
	  three.getLocation().getY()-(titleHeight*2)+boarder).click();
	  actions5.perform(); 
	  
	  }
	  
	 
	@Test(enabled = false) 
	public void multiClick() {

		WebElement one = driver.findElement(By.name("one"));
		WebElement eleven = driver.findElement(By.name("eleven"));
		WebElement five = driver.findElement(By.name("five"));
		Actions actions = new Actions(driver);
		
		actions.click(one).click().click().click(eleven).click().click(five).build().perform();

	}
	
	@Test(enabled = false) 
	public void clickAndHold() {

		driver.get("http://guidebook.seleniumacademy.com/Sortable.html");
		
		Actions actions = new Actions(driver);
		WebElement two = driver.findElement(By.name("two"));
		WebElement three = driver.findElement(By.name("three"));
		WebElement five = driver.findElement(By.name("five"));
		
		//actions.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).perform();
		//actions.clickAndHold(three).release(two).perform();
		actions.moveToElement(three).clickAndHold().moveByOffset(120, 0);
		
	}

	@Test(enabled = true) 
	public void dragAndDrop() {

		driver.get("http://guidebook.seleniumacademy.com/DragAndDrop.html");
		
	
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		
		//actions.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0).perform();
		//actions.clickAndHold(three).release(two).perform();
		actions.dragAndDrop(source, target).perform();
	}
	
}
