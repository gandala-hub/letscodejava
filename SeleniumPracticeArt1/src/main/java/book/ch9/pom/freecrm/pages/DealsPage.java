package book.ch9.pom.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsPage {
	
	WebDriver driver;
	
	@FindBy(css= "#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > a:nth-child(7) > button")
	WebElement createBtn;
	
	public DealsPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void createDeal() {
		createBtn.click();
		
	}
	
}
