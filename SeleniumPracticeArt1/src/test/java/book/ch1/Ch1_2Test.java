package book.ch1;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.slnm.practice.main.Engine;
import com.slnm.practice.util.SrcUtil;

import book.test.utils.ExcelUtil;
import book.test.utils.TestUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Ch1_2Test extends Engine {

//Engine Engn;
	ExcelUtil exutil = new ExcelUtil();

	@BeforeTest
	void setup() {
		driver.get(TestUtils.URL);
		/*
		 * try{ exutil.setExcelFile(TestUtils.Path_TestData+TestUtils.File_TestData,
		 * "Search_Data"); System.out.println("xls found"); }catch(IOException IOEx) {
		 * System.out.println(IOEx);
		 * 
		 * }
		 */

	}

	@Test
	void SearchTest() {

		// driver.findElement(By.className("gLFyf gsfi")).sendKeys("Hello");

		// System.out.println(exutil.getCellData(1, 1));
		// driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(exutil.getCellData(1,
		// 1));

//	WebElement seachBox = driver.findElement(By.id("search"));
//	seachBox.sendKeys(exutil.getCellData(7, 1));
//	seachBox.submit();

		// By CSS

		
		  
		  WebElement seachBox = driver.findElement(By.name("q"));
		  seachBox.sendKeys("Bags"); 
		  seachBox.submit();
		  
		  
		  System.out.println(driver.getTitle()); assertThat
		  (driver.getTitle()).isEqualTo("Search results for: 'Bags'");
		  
		 
		// Test2

		WebElement ResultBox1 = driver.findElement(By.linkText("CLASSIC HARDSHELL SUITCASE"));
		ResultBox1.click();
		System.out.println(driver.getTitle());
		assertThat(driver.getTitle()).isEqualTo("Classic Hardshell Suitcase");

		// <a
		// href="http://demo-store.seleniumacademy.com/classic-hardshell-suitcase-583.html"
		// title="Classic Hardshell Suitcase">Classic Hardshell Suitcase</a>

		// Test3 CSS

//	try {
//		Thread.currentThread().wait(10000);		
//	}catch (Exception e) {
//		// TODO: handle exception
//	}

//	WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
//	searchBtn.click();

//	Actions actions = new Actions(driver);
//	actions.moveToElement(searchBtn).click().build().perform();

	}

	@AfterTest
	void CleanUp() {
		driver.manage().deleteAllCookies();
		// driver.close();
		// driver.quit();

	}

}
