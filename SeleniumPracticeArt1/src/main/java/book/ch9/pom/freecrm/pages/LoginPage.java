package book.ch9.pom.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(css = "body > div.page > header > div > nav > div > div > a > span.icon.icon-xs.mdi-chart-bar")
	WebElement primaryLoginBtn;
	
	@FindBy(css= "#ui > div > div > form > div > div:nth-child(1) > div > input[type=text]")
	WebElement username;
	
	@FindBy(css= "#ui > div > div > form > div > div:nth-child(2) > div > input[type=password]")
	WebElement password;
	
	
	@FindBy(css= "#ui > div > div > form > div > div.ui.fluid.large.blue.submit.button")
	WebElement secondaryLoginBtn;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get("https://freecrm.com/");
	}

	
	public HomePage login(String usr, String pwd) {
		
		primaryLoginBtn.click();
		username.sendKeys(usr);
		password.sendKeys(pwd);
		secondaryLoginBtn.click();
		
		return PageFactory.initElements(driver, HomePage.class);
		
		
	}
	
	
}
