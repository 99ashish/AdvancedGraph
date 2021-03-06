package com.jda.advanced_core;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class JsonFileWriter {
	public static void main(String[] args) {
		 JSONObject countryObj = new JSONObject();  
	        countryObj.put("Name", "USA");  
	        countryObj.put("Population", new Integer(1000000));  
	        JSONArray listOfStates = new JSONArray();  
	        listOfStates.add("Maxico");  
	        listOfStates.add("New York");  
	        listOfStates.add("Las vegas");  
	        countryObj.put("States", listOfStates);  
		try{
		            File file=new File("/home/bridgelabz/JsonFile1.json");  
		            file.createNewFile();  
		            FileWriter fileWriter = new FileWriter(file);  
		            System.out.println("Writing JSON object to file");  
		            System.out.println("-----------------------");  
		            System.out.print(countryObj);  

		            fileWriter.write(countryObj.toJSONString());  
		            fileWriter.flush();  
		            fileWriter.close();  

		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  

		    }   

	}
