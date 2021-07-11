package book.ch9.pom.wordpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WordPressTests {
	
	WebDriver driver;
	String username = "admin";
	String password = "$$SUU3$$N#";
	
	@BeforeMethod
	public void setUp() {		
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));		
		driver = new ChromeDriver();
		
		
	}

	
	@Test
	public void testAddNewPost() {
		
		
	}
	
	@Test
	public void testEditPost() {
		
		
	}
	
	@Test
	public void testDeletePost() {
		
		
	}
	
	@Test
	public void testCountPosts() {
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		
	}
}
