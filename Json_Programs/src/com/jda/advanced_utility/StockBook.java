package com.jda.advanced_utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class StockBook {
	private static String path="C:\\Users\\1022784\\Desktop\\gitProgram\\";
	List<Stock> stockName=new ArrayList<>();
	private static Input get =Input.getInputInstance();
	public void showStockName()
	{
	readFromFile();
	System.out.println("Name"+"\t\t" + "Price Per Share" +"\t\t" +"Total Share");
	for(int i=0;i<stockName.size();i++)
		System.out.println(stockName.get(i).getNameOfStack()+"\t\t"
				           +stockName.get(i).getPricePerShare()+"\t\t"
				           +stockName.get(i).getTotalShare());
	}
	private void readFromFile()
	{
		String filename = path + get.sc.nextLine() + ".json";
		 File fileName= new File(filename);
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(fileName);
	        for(JsonNode obj:node)
	        {
	        	Stock stk=mapper.treeToValue(obj,Stock.class);
	        	stockName.add(stk);
	        }
	      }
		catch(Exception e)
		{
			System.out.println("Unable to read file");
		}
	}

}
