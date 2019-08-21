package com.autoton.Testcases;

import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.autothon.config.RestAssuredConfig;
import com.autothon.util.AutomationConstants;
import com.autothon.util.JsonReaderHelper;
import com.autothon.util.UtilityMethods;



public class APIDemo {
	private static Logger logger;
	private static JSONObject jsonObj;
	private static JSONObject requestObj;
	private static String host;
	private static String resource;
	private static String data;
	private static String format;
	private static String endpoint;	
	
/**
 * Setting up the logger and env variables
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	@BeforeTest
	public void setup() throws FileNotFoundException, IOException, ParseException {
		logger = Logger.getLogger("APIDemo");
		PropertyConfigurator.configure(AutomationConstants.LOG4J);
		logger.info("-------------------------------------------------------------");	
		logger.info("           API Testing is Started Successfully               ");
		logger.info("-------------------------------------------------------------");	
		jsonObj = JsonReaderHelper.getJsonObject(AutomationConstants.SYSTEM_PATH + AutomationConstants.RESOURCE_PATH + "API_TestData_IMDB.json");	
		if(jsonObj != null) {
		requestObj = (JSONObject) jsonObj.get(AutomationConstants.REQUEST);			
		host = (String) requestObj.get(AutomationConstants.HOST);
		resource = (String) requestObj.get(AutomationConstants.RESOURCE);
		endpoint = RestAssuredConfig.getEndpoint(host, resource);
		}
	}
	/**
	 * It will validate the response from Service
	 */
	@Test
	public void validateGetResponse() {

		String token = null; 
		Properties prop =  new Properties();
		
		try {
		token = (String) requestObj.get(AutomationConstants.TOKEN);
		format = (String) requestObj.get(AutomationConstants.FORMAT);
		data = (String) requestObj.get(AutomationConstants.DATA);
		if(endpoint != null && token != null) {
			Response responseObj = RestAssuredConfig.getParam(endpoint, token, format, data);
			if(responseObj != null) {				
				Assert.assertEquals(AutomationConstants.STATUS_CODE, responseObj.getStatusCode());
				//saving the values in to prop file
				prop = UtilityMethods.OpenProperties(AutomationConstants.SYSTEM_PATH + AutomationConstants.ENV_PROP_PATH);
				prop.store(new FileOutputStream(AutomationConstants.SYSTEM_PATH + AutomationConstants.ENV_PROP_PATH), null);
				logger.info("-------------------------------------------------------------");	
				logger.info("                API Testing Ended Successfully               ");
				logger.info("-------------------------------------------------------------");	
			}
			} }catch (FileNotFoundException e) {
				logger.error("FileNotFoundException"+ e.getMessage());					
				} catch (IOException e) {
					logger.error("IOException"+ e.getMessage());		
				}
				
			}
	
}
