package com.autothon.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * This class has the util methods required for project
 * @author bgovindaraj
 *
 */
public class UtilityMethods {
	public static Logger logger;


	/**
	 * Open the .properties file
	 * @param filePath
	 * @return
	 */
	public static Properties OpenProperties(String filePath) {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath);
			prop.load(file);
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			logger.info("IOException" + e.getMessage());
		}
		return prop;
	}
	/**
	 * It will update the host entries from system 
	 * @throws IOException
	 */
	public static void updateHostFile() throws IOException {
		Logger logger = Logger.getLogger(UtilityMethods.class.getName());
		PropertyConfigurator.configure(AutomationConstants.LOG4J);
		logger.info("-----------------------------------------------------------------------------------");	
		logger.info("                        HOSTS file updation starts                 ");
		logger.info("-----------------------------------------------------------------------------------");
			Properties prop = new Properties();
			prop = UtilityMethods.OpenProperties(AutomationConstants.SYSTEM_PATH + AutomationConstants.ENV_PROP_PATH);
			String IP1 = prop.getProperty(AutomationConstants.IP1);
			String IP2 = prop.getProperty(AutomationConstants.IP2);
			String Site1 = prop.getProperty(AutomationConstants.SITE_1);
			String Site2 = prop.getProperty(AutomationConstants.SITE_2);
			String Site3 = prop.getProperty(AutomationConstants.SITE_3);
			String Site4 = prop.getProperty(AutomationConstants.SITE_4);
			String hostFileContent = "";
			hostFileContent = "#" + "Air Canada Port Configuration" + "\r\n"
					+ "\r\n" + IP1 + "\t " + Site1 + "\r\n" + "\r\n" + IP1
					+ "\t " + Site2 + "\r\n" + "\r\n" + IP2 + "\t " + Site3
					+ "\r\n" + "\r\n" + IP2 + "\t " + Site4 + "\r\n";
			String hostFilePath = "C:\\WINDOWS\\system32\\drivers\\etc\\" + "hosts";
			File file = new File(hostFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fstreamhost = new FileWriter(hostFilePath, false);
			BufferedWriter out = new BufferedWriter(fstreamhost);
			out.newLine();
			out.write(hostFileContent);
			out.newLine();
			out.flush();
			out.close();
			logger.info("-----------------------------------------------------------------------------------");	
			logger.info("     HOSTS file updated! Mapped to: Air Canada Port Configuration          ");
			logger.info("-----------------------------------------------------------------------------------");
	}
	
	public static void getLogger(String className) {
	Logger logger = Logger.getLogger(className);
	PropertyConfigurator.configure(AutomationConstants.LOG4J);
	}
}
