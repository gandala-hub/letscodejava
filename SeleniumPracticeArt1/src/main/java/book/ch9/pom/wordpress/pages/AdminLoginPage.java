package book.ch9.pom.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	WebDriver driver;
	
	
	/*
	 * /html/body/div[1]/form/p[1]/label/input #user_login
	 */ 
	
	@FindBy(xpath = "//*[@id=\"user_login\"]")
	WebElement userId;
	@FindBy(xpath = "//*[@id=\"user_pass\"]")
	WebElement passWord;
	@FindBy(xpath = "//*[@id=\"wp-submit\"]")
	WebElement loginBtn;
	
	
	public AdminLoginPage(WebDriver driver){
		this.driver = driver;
		driver.get("http://demo-blog.seleniumacademy.com/wp/wp-admin");	
	}
	
	
	public AllPostsPage login(String username, String password) {
		userId.sendKeys(username);
		passWord.sendKeys(password);
		loginBtn.click();
		
		return PageFactory.initElements(driver, AllPostsPage.class);
		
		
	}
	
}
