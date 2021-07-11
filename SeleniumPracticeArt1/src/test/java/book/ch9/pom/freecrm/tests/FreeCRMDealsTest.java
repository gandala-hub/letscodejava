package book.ch9.pom.freecrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import book.ch9.pom.freecrm.pages.DealsPage;
import book.ch9.pom.freecrm.pages.HomePage;
import book.ch9.pom.freecrm.pages.LoginPage;

public class FreeCRMDealsTest {
	
	WebDriver driver;
	String username = "giribabu.andala@gmail.com";
	String password = "Monisaket@0802";
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {		
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}

	
	@Test
	public void testAddNewDeal() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homepage= loginpage.login(username, password);
		DealsPage dealsPage= homepage.openDealsPage();
		dealsPage.createDeal();

		
		
	}
	
	/*
	 * @Test public void testEditDeal() {
	 * 
	 * 
	 * }
	 * 
	 * @Test public void testDeleteDeal() {
	 * 
	 * 
	 * }
	 * 
	 * @Test public void testCountDeals() {
	 * 
	 * 
	 * }
	 */
	
	@AfterMethod
	public void tearDown() {
		
		
	}
}
