/*
as a user
I want to access my email account
so that I can stay in touch with the world and be a good student

given I don’t know how to access my email via MyPitt
when I look for a help resource
then I find resource links that help me access my email via MyPitt
*/

package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JUnitStory3Case4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://my.pitt.edu/portal/server.pt/community/my_pitt_home/805";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJUnitStory3Case4() throws Exception {
    assertEquals("My Pitt Home", driver.getTitle());
    driver.get(baseUrl + "/portal/server.pt/community/my_pitt_home/805");
    driver.findElement(By.xpath("//ul[@id='ali-nav']/li[7]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='pt-portlet-content-8348']/table/tbody/tr[10]/td/a/strong")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | article_pop_DA_182113 | 30000]]
    assertEquals("My Pitt Help Me", driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
