package book.ch8;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		// System.setProperty("webdriver.chrome.driver",
		// System.getenv("webdriver.chrome.driver"));

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.ANY);
		/*
		 * ChromeOptions options = new ChromeOptions(); options.merge(caps);
		 */
		driver = new RemoteWebDriver(new URL("http://172.26.128.1:4444/wd/hub"), caps);
		driver.get("https://www.google.com/");
		assertThat(driver.getTitle()).isEqualTo("Google");

	}

	/*
	 * @Test public void searchProduct() { WebElement searchBox =
	 * driver.findElement(By.name("q")); searchBox.sendKeys("Phones"); WebElement
	 * searchButton = driver.findElement(By.className("seach-button"));
	 * searchButton.click();
	 * assertThat(driver.getTitle()).isEqualTo("Search results for: 'Phones'");
	 * 
	 * }
	 */
	
	 @Test public void validateTitle() {
		 assertThat(driver.getTitle()).isEqualTo("Google");
	 }
	
}
