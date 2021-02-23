package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Convertor implements XMLJSONConverter{
	

	
	   public  String toString(String key,Object value,String dataType,String encloser)
	            throws JSONException {
	    	StringBuilder sb = new StringBuilder();
	    	if(value instanceof JSONObject) {
	    		JSONObject jsonObject =(JSONObject)value;
	    		Set<String> keys =	jsonObject.keySet();
	    		sb.append(getTagForNonNullValue(key, null, "object",encloser,true));
	    		for(String tempKey : keys) {
	    				Object val =	jsonObject.opt(tempKey);
	    				sb.append(toString(tempKey, val, null, encloser));
	    		}
	    		sb.append("</object>");
	    		
	    	}else if (value instanceof JSONArray) {
	    		JSONArray	ja = (JSONArray) value;
	            int jaLength = ja.length();
	    		sb.append(getTagForNonNullValue(key, null, "array",encloser,true));
				for (int i = 0; i < jaLength; i++) {
					Object val =	ja.get(i);
					sb.append(toString(null, val, null, encloser));
				}
				sb.append("</array>");
	    	}else if(value == JSONObject.NULL) {
	    		sb.append(getTagForNullValue(key, "null",encloser));
	    	}else if(value instanceof String) {
	    		sb.append(getTagForNonNullValue(key, value, "string",encloser,false));
	    	}else if(value instanceof Number) {
	    		sb.append(getTagForNonNullValue(key, value, "number",encloser,false));
	    	}else if(value instanceof Boolean) {
	    		sb.append(getTagForNonNullValue(key, value, "boolean",encloser,false));
	    	}
	    	return sb.toString();
	    }
	    
	    
	    
	    private  StringBuffer getTagForNonNullValue(String key,Object value,String dataType,String encloser,boolean start) {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("<");
	    	sb.append(dataType);
	    	if(key !=null) {
	    		sb.append(" name=");
	    		sb.append(encloser);
	    		sb.append(key);
	    		sb.append(encloser);
	    	}
	    	if(value ==null && ! start) {
	    		sb.append("/>");
	    	}if(value ==null &&  start) {
	    		sb.append(">");
	    	}else {
	    	sb.append(">");
	    	sb.append(value);
	    	sb.append("</");
	    	sb.append(dataType);
	    	sb.append(">");
	    	}
	    	return sb;
	    }
	    private  StringBuffer getTagForNullValue(String key,String dataType,String encloser) {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("<");
	    	sb.append(dataType);
	    	sb.append(" name=");
	    	sb.append(encloser);
	    	sb.append(key);
	    	sb.append(encloser);
	    	sb.append("/>");
	    	return sb;
	    }



		@Override
		public void convertJSONtoXML(String inputPath, String outputPath) {
			File inputFile = new File(inputPath);
			File outputFile = new File(outputPath);
			try(FileInputStream str = new FileInputStream(inputFile);
			InputStreamReader inputStreamReader = new InputStreamReader(str);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	 		FileOutputStream fileOutputStream = new FileOutputStream(outputFile)){
			
			StringBuffer buffer = new StringBuffer();
			String c = 	bufferedReader.readLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			while(c !=null ) {
				 buffer.append(c);
				 c = 	bufferedReader.readLine();
			}
			String str1  = buffer.toString();
			JSONObject jsonObject =	new JSONObject(str1);
			String output =	toString(null, jsonObject, null, "\"");
			fileOutputStream.write(output.getBytes());
			fileOutputStream.close();
			}catch (Exception e) {
				System.out.println("error"+e.getMessage() );
			}
			
		}

	
}
