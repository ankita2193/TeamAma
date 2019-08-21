package com.autothon.helper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.Select;

public class UIHelper {
	public static void sendKeysToElement(WebElement element, String text)
			throws NoSuchElementException {
		try {
			if (element.isDisplayed()) {
				element.sendKeys(new CharSequence[]{text});
			}
		} catch (NoSuchElementException var3) {
			var3.printStackTrace();
		}

	}


	public static void clickAnElement(WebElement element)
			throws NoSuchElementException {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			}
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static void mouseHoverAnElement(WebDriver driver, WebElement element)
			throws NoSuchElementException {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (NoSuchElementException var3) {
			var3.printStackTrace();
		}

	}

	public static void takeScreenShot(WebDriver driver, String destination)
			throws IOException {
		try {
			File dest = new File(destination);
			File src = (File) ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, dest);
		} catch (IOException var4) {
			var4.printStackTrace();
		}

	}

	public static void dropDownSelectorByInnerText(WebElement element,
			String innerText) throws Exception {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(innerText);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void dropDownSelectorByIndex(WebElement element, int index)
			throws Exception {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void dropDownSelector(WebElement element, String value)
			throws Exception {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void multipleValueSelectDrDList(List<WebElement> elements)
			throws Exception {
		try {
			Iterator var2 = elements.iterator();

			while (var2.hasNext()) {
				WebElement element = (WebElement) var2.next();
				Select select = new Select(element);
				select.selectByVisibleText(element.getText());
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

	}

	public static void mouseHoverAndClickAnElement(WebElement element,
			WebDriver driver) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void doubleClickAnElement(WebDriver driver, WebElement element)
			throws Exception {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).doubleClick().build().perform();
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void goToPreviousPage(WebDriver driver) throws Exception {
		try {
			driver.navigate().back();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static void refreshPage(WebDriver driver) throws Exception {
		try {
			driver.navigate().refresh();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static void switchToAnotherWindow(WebDriver driver) throws Exception {
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> availableWindows = driver.getWindowHandles();
			Iterator var4 = availableWindows.iterator();

			while (var4.hasNext()) {
				String cWindow = (String) var4.next();
				if (!cWindow.equals(currentWindow)) {
					driver.switchTo().window(cWindow);
				}
			}
		} catch (Exception var5) {
			var5.printStackTrace();
		}

	}

	public static void switchBackToCurrentWindow(WebDriver driver)
			throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static boolean isAlertPresent(WebDriver driver) throws Exception {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception var2) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, String locator)
			throws Exception {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (Exception var3) {
			return false;
		}
	}

	public static boolean isElementPresentForCss(WebDriver driver,
			String locator) throws Exception {
		try {
			return driver.findElement(By.cssSelector(locator)).isDisplayed();
		} catch (Exception var3) {
			return false;
		}
	}

	public static void acceptAlert(WebDriver driver) throws Exception {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static void declineAlert(WebDriver driver) throws Exception {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	public static void iframeSwitcher(WebDriver driver, WebElement element)
			throws Exception {
		try {
			driver.switchTo().frame(element);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public static void switchOutofFrame(WebDriver driver) throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}
}