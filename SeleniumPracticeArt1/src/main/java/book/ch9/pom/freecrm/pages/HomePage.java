package book.ch9.pom.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(css = "#main-nav > div:nth-child(5) > a > i")
	WebElement deals_icon;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DealsPage openDealsPage() {
		deals_icon.click();
		
		return PageFactory.initElements(driver, DealsPage.class);
		
	}

}
