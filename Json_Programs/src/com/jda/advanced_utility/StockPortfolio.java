package com.jda.advanced_utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
public class StockPortfolio {
private List<Stock> stockList= new ArrayList<>();
private static Input get =Input.getInputInstance();
private static String path="/home/bridgelabz/Desktop/JavaCode/StakeHolder/";
File fileName;
public static void readFromFile(File fileName,List<Stock> putValue)
{
	try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fileName);
        for(JsonNode obj:node)
        {
        	Stock stk=mapper.treeToValue(obj,Stock.class);
        	putValue.add(stk);
        }
      }
	catch(Exception e)
	{
		System.out.println("Unable to read file");
	}
}
public static void writeToFile(File fileName,List<Stock> obj) throws JsonGenerationException, JsonMappingException, IOException 
{
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer();
		writer.writeValue(fileName,
			                           obj);
}
private boolean checkExisitingFile(String fileName) {
	File file = new File(path);
	File[] files = file.listFiles();
	for (File f : files) {
		if (f.getName().contains(".json")) {
			if (f.getName().equals(fileName + ".json"))
				return true;
		}
	}
	return false;
}
void buy()
{
	StockBook.stockName.clear();
	StockBook.showStockName();
	Stock stk=new Stock();
	boolean exist=false;
	System.out.println("Enter the stock name");
	stk.setNameOfStack(get.sc.nextLine());
	System.out.println("Number of stock");
	stk.setTotalShare(get.sc.nextDouble());
	int len=StockBook.stockName.size();
	for(int i=0;i<len; i++)
	{
		if(stk.getNameOfStack().equals(StockBook.stockName.get(i).getNameOfStack()))
		{
			if(stk.getTotalShare()<=StockBook.stockName.get(i).getTotalShare())
			{
			stk.setPricePerShare(StockBook.stockName.get(i).getPricePerShare());
			Transaction tr=new Transaction();
			tr.setTransactionType("buy");
			tr.setDate();
			stk.setTransAction(tr);
			Stock stkBook=StockBook.stockName.get(i);
			double remainShare=stkBook.getTotalShare()-stk.getTotalShare();
			stkBook.setTotalShare(remainShare);
			StockBook.stockName.set(i,stkBook);
			stockList.add(stk);
			exist=true;
			try
			{
			writeToFile(fileName, stockList);
			writeToFile(StockBook.fileName, StockBook.stockName);
			}
			catch(Exception e)
			{
				System.out.println("Unable to update file  system");
			}
			System.out.println("You successfully buy the share");
		}
			else
			{
				System.out.println("Total share is out of bound");
			}
	}
	
	}
	if(!exist)
		System.out.println("Not able to process your request");
}
void sell()
{
	/*stockList.clear();
	StockBook.stockName.clear();*/
	readFromFile(fileName, stockList);
	readFromFile(StockBook.fileName, StockBook.stockName);
Stock stk=new Stock();
System.out.println("Enter the stock name");
stk.setNameOfStack(get.sc.nextLine());
System.out.println("Number of stock");
stk.setTotalShare(get.sc.nextDouble());
int len=StockBook.stockName.size();
for(int i=0;i<len; i++)
{
	if(stk.getNameOfStack().equals(stockList.get(i).getNameOfStack()))
	{
		if(stk.getTotalShare()<=stockList.get(i).getTotalShare())
		{
			stk.setPricePerShare(stockList.get(i).getPricePerShare());
		Transaction tr=new Transaction();
		tr.setTransactionType("sell");
		tr.setDate();
		stk.setTransAction(tr);
		Stock stkBook=StockBook.stockName.get(i);
		double addShare=stkBook.getTotalShare()+stk.getTotalShare();
		stkBook.setTotalShare(addShare);
		StockBook.stockName.set(i,stkBook);
		Stock updatedStock=stockList.get(i);
		double remainShare=updatedStock.getTotalShare()-stk.getTotalShare();
		updatedStock.setTotalShare(remainShare);
		if(remainShare==0.0)
		stockList.remove(updatedStock);
		else
		{
			stockList.set(i,updatedStock);
			stockList.add(stk);
		}
		try
		{
		writeToFile(fileName, stockList);
		writeToFile(StockBook.fileName, StockBook.stockName);
		}
		catch(Exception e)
		{
			System.out.println("Unable to update file  system");
		}
		System.out.println("You successfully sell the share");
	}
		else
		{
			System.out.println("Total share is out of bound");
		}
}
}
}
void valueOf()
{
	double totalValue=0;
	for(int i=0;i<stockList.size();i++)
		totalValue+=(stockList.get(i).getPricePerShare()*stockList.get(i).getTotalShare());
	System.out.println("\t\t\t\t" +"Total value of your account is :" + totalValue +"INR");
}
void saveAccount()
{
	try{
	writeToFile(fileName, stockList);
	}
	catch(Exception e)
	{
		System.out.println("Not able to save your account "+ e);
	}
}
void getAccountDetail()
{
	System.out.println("Company Name"+"\t\t\t"+"Price per share"+"\t\t\t" +"total share" +"\t\t\t"+"Transaction Type"+ "\t\t\t"+ "Tranaction Date");
	for(int i=0;i<stockList.size();i++)
	{
		System.out.println(stockList.get(i).getNameOfStack() +"\t\t\t\t\t\t" + stockList.get(i).getPricePerShare()
				                          +"\t\t\t\t\t\t" +stockList.get(i).getTotalShare() +"\t\t\t\t\t\t" +stockList.get(i).transAction.getTransactionType()+
				                          "\t\t\t\t\t\t" + stockList.get(i).transAction.getDate());
	}
}
private void openAccount()
{
	readFromFile(fileName, stockList);
	while(true)
	{
	System.out.println("\t\t\t"+"1.Buy" +"\n\t\t\t"+"2.sell" +"\n\t\t\t" +"3. Value of total Stock" +"\n\t\t\t"
                                     + "4. Save Account" +"\n\t\t\t"+"5.Print Account Detail"+"\n\t\t\t" +"6.Go to back");
	int opt=get.sc.nextInt();
	get.sc.nextLine();
	switch(opt)
	{
	case 1:buy();break;
	case 2:sell();break;
	case 3:valueOf();break;
	case 4:saveAccount();break;
	case 5:getAccountDetail();break;
	case 6:return;
	default:
		System.out.println("Choose valid option");
		openAccount();break;
	}
	}
}
public void stockAccount()
{
	get.sc.nextLine();
	System.out.println("Enter your account name");
	String filename = path +   get.sc.nextLine() +".json";
	if(!checkExisitingFile(filename))
	{
	try{
	 fileName= new File(filename);
	 fileName.createNewFile();
	 openAccount();
	}
	catch(Exception e)
	{
		System.out.println("Unable to open account");
	}
	}
	else
	{
		System.out.println("Account already exist try with another name");
		stockAccount();
	}
}
public static File openFile(String filename,List<Stock> putValue) throws FileNotFoundException
{
	  filename = path +   filename+".json";
	 File fileName= new File(filename);
	 readFromFile(fileName,putValue);
	 return fileName;
}
/*public void buy(String fileName)
{
	fileName=openFile(fileName,stockList);
}*/
public void getStockValue()
{
	for(int i=0;i<stockList.size();i++);
	//System.out.println("\t\t\t" + stockList.get(i).getNameOfStack() +": " + stockList.get(i).getTotValue());
}
public double getTotStockValue()
{
	readFromFile(fileName,stockList);
	double totalValue=0;
	for(int i=0;i<stockList.size();i++)
	{
		//totalValue+=(stockList.get(i).getTotValue());
	}
	return totalValue;
}
}
