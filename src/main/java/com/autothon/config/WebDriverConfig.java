package com.autothon.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.autothon.util.AutomationConstants;

/**
 * 
 * @author bgovindaraj
 *
 */
public class WebDriverConfig extends AbstractWebDriverEventListener {

	protected static EventFiringWebDriver driver;
	protected static List<String> logText = new ArrayList<String>();
	static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy HH_mm_ss");
	static Date dateobj = new Date();
	private static PrintWriter pw;
	/**
	 * determineDriver
	 * @return
	 */
	private WebDriver determineDriver() {
		if (AutomationConstants.BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"Drivers//chromedriver.exe");
			return new ChromeDriver();
		} else if (AutomationConstants.BROWSER.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"Drivers//geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			return new FirefoxDriver(options);
		} else if (AutomationConstants.BROWSER.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"Drivers//IEDriverServer.exe");
			return new InternetExplorerDriver();
		} else
			throw new IllegalArgumentException("Browser is not correct");
	}
	/**
	 * setup
	 */
	@BeforeMethod
	public void setup() {
		driver = new EventFiringWebDriver(determineDriver());
		driver.register(new WebDriverConfig());
		driver.navigate().to(AutomationConstants.ATURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/**
	 * beforeClickOn
	 */
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logText.add("Clicking on the button : " + element.getText());
	}
	/**
	 * beforeNavigateTo
	 */
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logText.add("Navigating to the url : " + url);
	}
	/**
	 * afterNavigateTo
	 */
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logText.add("Landed to the page located at : " + driver.getTitle());
	}
	/**
	 * beforeChangeValueOf
	 */
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		logText.add("Change the value of the field : "
				+ element.getAttribute("name"));
	}
	/**
	 * afterChangeValueOf
	 */
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		logText.add("Value of the field : " + element.getAttribute("name")
				+ " is changed to : " + element.getAttribute("value"));
	}
	/**
	 * onException
	 */
	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		logText.add("There is an exception in the script, please find the below error description \n"
				+ arg0.getStackTrace());
	}
	/**
	 * takeSnapShot
	 */
	public static void takeSnapShot(String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(AutomationConstants.screenshotFolder + fileName);
		FileUtils.copyFile(srcFile, destFile);
	}

	/**
	 * printAndSaveLogToTextFile
	 */
	private static void printAndSaveLogToTextFile() throws Exception {
		FileWriter fw = new FileWriter(AutomationConstants.logFolder + "log "
				+ df.format(dateobj));
		pw = new PrintWriter(fw);
		for (String log : logText) {
			pw.println(log);
			pw.println();
			pw.flush();
		}
		pw.close();
		fw.close();
	}
	/**
	 * tearDown
	 */
	@AfterMethod
	public static void tearDown() {
		driver.close();
		try {
			printAndSaveLogToTextFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}