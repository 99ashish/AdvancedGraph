package com.jda.advanced_core;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SimpleJsonFileReader {

	public static void main(String[] args) {
		 JSONParser parser = new JSONParser();
		// TODO Auto-generated method stub
		 try{
		JSONArray a = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Desktop/java-programs/data1.json"));

		  for (Object o : a)
		  {
		    JSONObject person = (JSONObject) o;

		    String name = (String) person.get("name");
		    System.out.println(name);

		    String city = (String) person.get("city");
		    System.out.println(city);

		    String job = (String) person.get("job");
		    System.out.println(job);

		    JSONArray cars = (JSONArray) person.get("cars");

		    for (Object c : cars)
		    {
		      System.out.println(c+"");
		    }
		  }
	}
	catch(Exception x)
	{
		System.out.println(x);
	}
	}

}
