package com.calliduscloud.testing.util;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonReader {

	public static String readJson(String filepathwithName,String requiredValue) 

	{
		String reqKeyValue=null;
		try
		{		
			JSONParser jsonparser=new JSONParser();
			File file=new File("inputdata/"+filepathwithName+".json");
			System.out.println("inputdata/"+filepathwithName+".json");
			Object object=jsonparser.parse(new FileReader(file));    
			JSONObject obj=(JSONObject)object;
			reqKeyValue = (String) obj.get(requiredValue);
			System.out.println(reqKeyValue);
		}
		catch(Exception e)
		{

			SeleniumMethods.catch_code(e);
		}
		return reqKeyValue;
	}

	public static Object[] getArrayData(String filepathwithName,String requiredValue)
	{
		Object values[]=null;

		try {
			JSONParser jsonparser=new JSONParser();
			File file=new File("inputdata/"+filepathwithName+".json");
			Object object=jsonparser.parse(new FileReader(file));
			JSONObject obj=(JSONObject)object;
			JSONArray msg = (JSONArray) obj.get(requiredValue);
			values= msg.toArray();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			SeleniumMethods.catch_code(e);
		}
		return values;   
	}

	@SuppressWarnings("unchecked")
	public static void writeTo_JsonFile(JSONObject obj,String fileName) throws Exception
	{
		FileWriter file = new FileWriter("inputdata/"+fileName+".json");
		try{
			file.write(obj.toJSONString());
			System.out.println("Successfully data inserted to Json File...");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			file.flush();
			file.close();
		}
	}
}