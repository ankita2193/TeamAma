package com.autothon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * This class is used to take error scenarios of UI testing
 */
public class CaptureScreenshot {
	public static String Capture(WebDriver driver, String varScreenshotName) throws IOException	{
		TakesScreenshot objTakesScreenshot = (TakesScreenshot)driver;
		File varSource = objTakesScreenshot.getScreenshotAs(OutputType.FILE);
		String varDest = AutomationConstants.SYSTEM_PATH +"/ErrorScreenshots/"+ varScreenshotName +".png";
		File varDestination = new File(varDest);
		FileUtils.copyFile(varSource, varDestination);
		return varDest;
	}
}