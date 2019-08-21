package com.autoton.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.autothon.config.AppiumConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AppiumDemo extends AppiumConfig {
	
	@Test
	public void apiDemoTest() throws IOException, InterruptedException
	{
			// TODO Auto-generated method stub
				service=startServer();
		    	AndroidDriver<AndroidElement> driver=capabilities("WebApp");
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.get("https://www.google.com");
	            service.stop();
	}
}