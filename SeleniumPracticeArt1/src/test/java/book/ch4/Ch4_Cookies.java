package book.ch4;

import static org.testng.Assert.assertThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.slnm.practice.main.Engine;

import org.openqa.selenium.Cookie;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Ch4_Cookies extends Engine {
	

	  @BeforeTest void setup() {
	  driver.get("http://demo-store.seleniumacademy.com/customer/account/login/");
	  
	  }
	 

	 @Test
	public void storeCookies() {
		driver.findElement(By.id("email")).sendKeys("giribabu.andala@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("tester");
		driver.findElement(By.id("send2")).submit();
		
		
		File dataFile = new File("./target/browser.data");
		try{
			
			dataFile.delete();
			dataFile.createNewFile();
			FileWriter fos = new FileWriter(dataFile);
			BufferedWriter bos = new BufferedWriter(fos);
			for (Cookie ck: driver.manage().getCookies()) {
				bos.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"+ ck.getExpiry() + ";" + ck.isSecure());
				bos.newLine();
			}
			
			System.out.println(driver.manage().getCookies());
			
			bos.flush();
			bos.close();
			fos.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */

	 

}
