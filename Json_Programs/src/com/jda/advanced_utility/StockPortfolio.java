package com.jda.advanced_utility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
public class StockPortfolio {
List<Stock> stockList= new ArrayList<>();
private static Input get =Input.getInputInstance();
public void getStockValue()
{
	for(int i=0;i<stockList.size();i++)
	System.out.println("\t\t\t" + stockList.get(i).getNameOfStack() +": " + stockList.get(i).getTotValue());
}
public double getTotStockValue()
{
	readFromFile();
	double totalValue=0;
	for(int i=0;i<stockList.size();i++)
	{
		totalValue+=(stockList.get(i).getTotValue());
	}
	return totalValue;
}
public void readFromFile() 
{
	System.out.println("Enter Filename");
	String file= get.sc.nextLine();
	File fileName=new File(file);
	try 
	{
	ObjectMapper mapper = new ObjectMapper();
	JsonNode node = mapper.readTree(fileName);
    for(JsonNode obj:node)
    {
    	Stock stock=mapper.treeToValue(obj,Stock.class);
    	stockList.add(stock);
    }
	}
	catch(Exception e)
	{
		System.out.println("Empty File");
	}
}
}
