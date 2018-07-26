package com.jda.advanced_utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class StockAccount {
	private static Input get =Input.getInputInstance();
	private static String path="/home/bridgelabz/Desktop/JavaCode/"; 
	public void createNewAccount(String fileName)
	{
		try{
		File file=new File(path+fileName +".json");
		file.createNewFile();
		Stock stk=new Stock();
		stk.setNameOfStack(fileName);
		System.out.println("Value of per stock");
		stk.setPricePerShare(get.sc.nextDouble());
		System.out.println("Total stock");
		stk.setTotalShare(get.sc.nextDouble());
		stk.setTotValue();
		writeToFile(file,stk);
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public double valueOf()
	{
		StockPortfolio obj= new StockPortfolio();
		obj.readFromFile();
		return obj.stockList.get(0).getTotValue();
		
	}
private void writeToFile(File fileName,Stock stk) throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
			writer.writeValue(fileName,
					stk);
	}
}
