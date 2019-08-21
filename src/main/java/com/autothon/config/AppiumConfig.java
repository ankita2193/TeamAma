package com.autothon.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumConfig {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	
	
	  
	  public AppiumDriverLocalService startServer() throws IOException, InterruptedException
	     {
		    boolean flag=	checkIfServerIsRunnning(4723);		    
		    if(flag)
		    	{ 
		    	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Thread.sleep(3000);
		    	  }
		    service=AppiumDriverLocalService.buildDefaultService();
	    	service.start();
	    	return service;	
		}
	  
	
      public static boolean checkIfServerIsRunnning(int port) 
      	{
    	  boolean isServerRunning = false;
    	  ServerSocket serverSocket;
    	  	try {
    	  		serverSocket = new ServerSocket(port);
    	  		serverSocket.close();
    	  	} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			     isServerRunning = true;
    	  	} finally {
			     serverSocket = null;
    	  	} 
		return isServerRunning;
	    }
      
      
      public static void startEmulator() throws IOException, InterruptedException
      {
    	  	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\startEmulator.bat");
    	  	Thread.sleep(6000);
      	}
      
      public static  AndroidDriver<AndroidElement> capabilities(String appType) throws IOException, InterruptedException
      	{
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\env.properties");
		Properties prop=new Properties();
		prop.load(fis);	
		
		if(appType.equalsIgnoreCase("NativeApp")) {
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get("ApkName"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		} else if(appType.equalsIgnoreCase("WebApp")) {
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		}	
		
		String deviceType=(String) prop.get("DeviceType");
		String emulatorName=(String) prop.get("DeviceName");
		if(deviceType.contains("Android_emulator"))
			{
			startEmulator();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
		}else if(deviceType.contains("Android_real")){
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    return driver;
	}
		

}
