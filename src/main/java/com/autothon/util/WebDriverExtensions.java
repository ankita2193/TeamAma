package com.autothon.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains the web element 
 * @author bgovindaraj
 *
 */
public class WebDriverExtensions {

	public static int waitTime = 30;
	public static WebElement element;
	private static Logger logger;

	public static WebElement waitforElementById(WebDriver driver, String id) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(id)));
		return element;
	}

	public static WebElement waitforElementByName(WebDriver driver, String name) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.name(name)));
		return element;
	}


	@SuppressWarnings("finally")
	public static WebElement waitforElementByXpath(WebDriver driver,
			String xpath) {
		UtilityMethods.getLogger(WebDriverExtensions.class.getName());
		WebDriverWait wait = null;
		try{
			wait = new WebDriverWait(driver, waitTime);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xpath)));
		}catch (NoSuchElementException e){
			logger.error("NoSuchElementException" + e.getMessage());
		}
		finally {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xpath)));
			return element;
		}
		
	}

	@SuppressWarnings("finally")
	public static WebElement waitforElementByCssSelector(WebDriver driver,
			String cssselector) {
		UtilityMethods.getLogger(WebDriverExtensions.class.getName());
		WebDriverWait wait = null;
		try{
			wait = new WebDriverWait(driver, waitTime);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(cssselector)));
			
		}catch (NoSuchElementException e){
			logger.error("NoSuchElementException" + e.getMessage());
		}
		finally {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(cssselector)));
			return element;
		}
	}

	public static WebElement waitforElementByClass(WebDriver driver,
			String className) {
		UtilityMethods.getLogger(WebDriverExtensions.class.getName());
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className(className)));
		return element;
	}

	public static void waitForPageToLoad(WebDriver driver) {
		UtilityMethods.getLogger(WebDriverExtensions.class.getName());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean readyState = js.executeScript("return document.readyState")
				.equals("complete");
		int count = 0;
		while (!readyState) {
			count++;
			if (count == waitTime)
				break;
		}
	}
}
