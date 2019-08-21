package com.autothon.config;

import com.autothon.util.AutomationConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class have the logic of calling the Endpoint
 * @author bgovindaraj
 *
 */
public class RestAssuredConfig {
	/**
	 * It will return the response Object from service
	 * @param url
	 * @param contentType
	 * @param auth
	 * @return
	 */

	public static Response get(String url, String contentType, String auth) {
		Response response = RestAssured.given()
				.header(AutomationConstants.CONTENT_TYPE, contentType)
				.header(AutomationConstants.AUTHORIZATION, auth).when().get(url);
		return response;
	}
	/**
	 * It will return the response Object from service
	 * @param url
	 * @param token
	 * @param format
	 * @param param
	 * @return
	 */

	public static Response getParam(String url, String token, String format,String param) {
		Response response = RestAssured.given()
				.param(AutomationConstants.TOKEN, token).param(AutomationConstants.FORMAT, format).param(AutomationConstants.DATA, param)
				.when().get(url);
		return response;
	}
	/**
	 * It will return the end point
	 * @param host
	 * @param resource
	 * @param pnr
	 * @return
	 */
	public static String getEndpoint(String host, String resource) {
		String endpointURL = host + resource;
		return endpointURL;
	}
	/**
	 * 
	 * @param url
	 * @param contentType
	 * @return
	 */
	public static Response get(String url, String contentType) {
		Response response = RestAssured.when().get(url, contentType);
		return response;
	}
	/**
	 * 
	 * @param url
	 * @param contentType
	 * @param body
	 * @return
	 */
	public static Response put(String url, String contentType, String body) {
		Response response = RestAssured.given().contentType(contentType)
				.body(body).when().put(url);
		return response;
	}
	/**
	 * 
	 * @param url
	 * @param contentType
	 * @param body
	 * @return
	 */
	public static Response delete(String url, String contentType, String body) {
		Response response = RestAssured.given().contentType(contentType)
				.body(body).when().delete(url);
		return response;
	}
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static Response getAcceptUrl(String url) {
		Response response = RestAssured.when().get(url);
		return response;
	}
	/**
	 * 
	 * @param url
	 * @param header
	 * @return
	 */
	public static Response getHeaderUrl(String url,String header) {
		Response response = RestAssured.given().headers("Accept", header).when().get(url);
		return response;
	}
	/**
	 * Function to add  BaseURI in the request
	 * @RequestSpecification @BaseURI
	 * 
	 */	
	public RequestSpecification setBaseURI(RequestSpecification httpRequest, String url) {
		return httpRequest.baseUri(url);
	}
	
	/**
	 * Function to add basePath in the request
	 * @RequestSpecification @BasePath
	 * 
	 */	
	public RequestSpecification setBasePath(RequestSpecification httpRequest, String path) {
		return httpRequest.basePath(path);
	}
	
	/**
	 * Function to add header in the request
	 * @RequestSpecification @key @value
	 * 
	 */	
	public RequestSpecification setHeader(RequestSpecification httpRequest,String key, String value) {
		return httpRequest.header(key, value);
	}
	
	/**
	 * Function to create an empty request
	 * 
	 */
	public RequestSpecification createEmptyRequest() {
		return RestAssured.given();
	}
	/**
	 * Method to get response
	 * @RequestSpecification
	 * 
	 */
	
	public Response getResponse(RequestSpecification httpRequest) {
		return httpRequest.get();		
	}	

}
