package AdhocExamples;

import com.slnm.practice.main.Engine;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import com.slnm.practice.util.SrcUtil;

import book.test.utils.ExcelUtil;
import book.test.utils.TestUtils;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeleniumPractice extends Engine {

//Engine Engn;




@BeforeTest
void setup()
{
	driver.get("https://google.com");

}

@Test
void SearchTest(){
	System.out.println(driver.getTitle());
	
	//Explicit Wait
	
	WebDriverWait explicitwait = new WebDriverWait(driver, 60);
	By searchBox_byElement = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
	explicitwait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_byElement)).sendKeys("Restaturants near me");
	WebElement searchBox= driver.findElement(searchBox_byElement);
	searchBox.submit();
	
	//explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.RNNXgb > div > div.a4bIc > input")));
	
	
	
}

@AfterTest
void CleanUp(){
	driver.manage().deleteAllCookies();
	//driver.close();
	//driver.quit();
	
}
}