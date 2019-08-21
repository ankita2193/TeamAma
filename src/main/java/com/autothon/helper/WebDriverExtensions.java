package com.autothon.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author bgovindaraj
 *
 */
public class WebDriverExtensions {

	public static int waitTime = 30;
	public static WebElement element;

	/**
	 * 
	 * @param driver
	 * @param id
	 * @return
	 */
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

	/**
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	@SuppressWarnings("finally")
	public static WebElement waitforElementByXpath(WebDriver driver,
			String xpath) {
		WebDriverWait wait = null;
		try{
			wait = new WebDriverWait(driver, waitTime);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xpath)));
		}catch (NoSuchElementException e){
			
		}
		finally {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(xpath)));
			return element;
		}
		
	}
	/**
	 * 
	 * @param driver
	 * @param cssselector
	 * @return
	 */
	@SuppressWarnings("finally")
	public static WebElement waitforElementByCssSelector(WebDriver driver,
			String cssselector) {
		WebDriverWait wait = null;
		try{
			wait = new WebDriverWait(driver, waitTime);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(cssselector)));
			
		}catch (NoSuchElementException e){
			
		}
		finally {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(cssselector)));
			return element;
		}
	}
	/**
	 * 
	 * @param driver
	 * @param className
	 * @return
	 */
	public static WebElement waitforElementByClass(WebDriver driver,
			String className) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className(className)));
		return element;
	}
	/**
	 * 
	 * @param driver
	 */
	public static void waitForPageToLoad(WebDriver driver) {
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