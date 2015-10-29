/*
as a user 
I want to login
so that I can be an active and good student at the university of pittsburgh

given an incorrect username
when I try to login
then I should be told to try again
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

public class LoginIncorrectUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://my.pitt.edu/portal/server.pt";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginIncorrectUser() throws Exception {
    driver.get(baseUrl + "/portal/server.pt");
    driver.findElement(By.id("pt-login-username-textbox")).clear();
    driver.findElement(By.id("pt-login-username-textbox")).sendKeys("NotAUsername");
    driver.findElement(By.name("in_pw_userpass")).clear();
    driver.findElement(By.name("in_pw_userpass")).sendKeys("wrongPassword");
    // ERROR: Caught exception [ERROR: Unsupported command [keyPress | name=in_pw_userpass | \13]]
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
