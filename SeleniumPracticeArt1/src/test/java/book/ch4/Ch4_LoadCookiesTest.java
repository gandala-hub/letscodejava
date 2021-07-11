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

public class Ch4_LoadCookiesTest extends Engine {

	
	  @BeforeTest void setup() {
	
	  driver.get("http://demo-store.seleniumacademy.com");
	  
	  }
	 
	@Test
	public void loadCookies() {
		try {
			File dataFile = new File("./target/browser.data");
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {

				StringTokenizer str = new StringTokenizer(line, ";");
				while (str.hasMoreTokens()) {
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					if (!(dt = str.nextToken()).equals("null")) {
						SimpleDateFormat sdf = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy");
						expiry = sdf.parse(dt);
					}

					boolean isSecure = new Boolean(str.nextToken()).booleanValue();

					System.out.println(
							"Cookie Values : ================= " + name + value + domain + path + expiry + isSecure);
					System.out.println(
							"Cookie Values : ================= " + name + value + domain + path + expiry + isSecure);
					
					System.out.println("name =========" +name);
					System.out.println("value =========" +value);
					System.out.println("domain =========" +domain);
					System.out.println("path =========" +path);
					System.out.println("expiry =========" +expiry);
					System.out.println("isSecure =========" +isSecure);
					
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
				
					driver.manage().addCookie(ck);

				}
			}

			driver.get("http://demo-store.seleniumacademy.com/customer/account/index/");
			assertThat(driver.findElement(By.cssSelector("div.page-title")).getText()).isEqualTo("MY DASHBOARD");

		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
}
