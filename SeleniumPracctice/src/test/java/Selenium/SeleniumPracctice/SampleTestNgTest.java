package Selenium.SeleniumPracctice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Selenium.SeleniumPracctice.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    String title = driver.findElement(By.tagName("title")).toString();
    System.out.println("homepage.header       = ====== " + homepage.header.toString());
    System.out.println("homepage.header       = ====== " + title);
    //Assert.assertFalse("".equals(homepage.header.getText()));
  }
}
