package AdhocExamples;

import com.slnm.practice.main.Engine;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


import com.slnm.practice.util.SrcUtil;

import book.test.utils.ExcelUtil;
import book.test.utils.TestUtils;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Ex1 extends Engine {

//Engine Engn;




@BeforeTest
void setup()
{
	driver.get("https://www.tmsandbox.co.nz/motors/used-cars");

}

@Test
void SearchTest(){
	System.out.println(driver.getTitle());
	List<WebElement> hrefList = driver.findElements(By.className("tmm-search-card-list-view__link"));
	System.out.println("href Items = " + hrefList.size());
	
	
	
	List<WebElement> liList = driver.findElements(By.className("tmm-search-card-list-view"));
	System.out.println("Li Items = " + liList.size());
	
	
}

@AfterTest
void CleanUp(){
	driver.manage().deleteAllCookies();
	//driver.close();
	//driver.quit();
	
}


}
