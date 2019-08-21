package com.autothon.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * This class  reads the JsonObject from file
 * @author bgovindaraj
 *
 */
public class JsonReaderHelper {
	/**
	 * 
	 * @param fileName
	 * @return JSONObject
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public static JSONObject getJsonObject(String fileName) throws FileNotFoundException, IOException, ParseException {
	JSONParser parser = new JSONParser();	 
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
	}
}