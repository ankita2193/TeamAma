package com.autothon.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWait {
   public static int minimumWait = 40;
   public static int maximumWait = 80;

   public static void implicitWaitForMinimum(WebDriver driver) throws Exception {
      try {
         driver.manage().timeouts().implicitlyWait((long)minimumWait, TimeUnit.SECONDS);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public static void implicitWaitForSeconds(WebDriver driver) throws Exception {
      try {
         driver.manage().timeouts().implicitlyWait(8L, TimeUnit.SECONDS);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public static void implicitWaitForMaximum(WebDriver driver) throws Exception {
      try {
         driver.manage().timeouts().implicitlyWait((long)maximumWait, TimeUnit.SECONDS);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public static void waitUntilPageLoadForMinimum(WebDriver driver) throws Exception {
      try {
         driver.manage().timeouts().pageLoadTimeout((long)minimumWait, TimeUnit.SECONDS);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public static void waitUntilPageLoadForMaximum(WebDriver driver) throws Exception {
      try {
         driver.manage().timeouts().pageLoadTimeout((long)maximumWait, TimeUnit.SECONDS);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public static boolean explicitInvisibilityOfElementLocate(WebDriver driver, String locator) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, 20L);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
         return true;
      } catch (Exception var3) {
         return false;
      }
   }

   public static void explicitVisibilityOfElement(WebDriver driver, WebElement element) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, (long)maximumWait);
         wait.until(ExpectedConditions.visibilityOf(element));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public static void explicitElementToBeClickable(WebDriver driver, WebElement element) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, (long)maximumWait);
         wait.until(ExpectedConditions.elementToBeClickable(element));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public static void explicitCheckPageTitle(WebDriver driver, String title) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, (long)maximumWait);
         wait.until(ExpectedConditions.titleContains(title));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public static void explicitPresentsOfElementDOM(WebDriver driver, String locator) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, (long)maximumWait);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public static void explicitVisibilityOfElementD(WebDriver driver, WebElement element) throws Exception {
      try {
         WebDriverWait wait = new WebDriverWait(driver, (long)minimumWait);
         wait.until(ExpectedConditions.visibilityOf(element));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}