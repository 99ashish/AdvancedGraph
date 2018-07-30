package com.jda.advanced_utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class StockBook 
{
	public static List<Stock> stockName=new ArrayList<>();
	private static Input get =Input.getInputInstance();
	static File fileName;
	public static void showStockName()
	{
		try
		{
	      stockName.clear();
	      fileName=StockPortfolio.openFile("StockBook",stockName);
	      System.out.println("--------------------------------------------------------------------------");
        	for(int i=0;i<stockName.size();i++)
        	{
		          System.out.println("\t\t\t\t"  + "Company Name:     "+stockName.get(i).getNameOfStack()
		        		            +"\n\t\t\t\t"+ "Price per share:  "+stockName.get(i).getPricePerShare()
		        		            +"\n\t\t\t\t"+ "Available share:  "+stockName.get(i).getTotalShare()+"\t\t\t\t\t");
        	System.out.println("--------------------------------------------------------------------------");
        	}
        	System.out.println("--------------------------------------------------------------------------");
        	}
		catch(Exception e)
		{
			System.out.println("Unable to show stock");
		}
	}
	private void addStock()
	{
		Stock stk= new Stock();
		get.sc.nextLine();
		System.out.println("Company Name");
		stk.setNameOfStack(get.sc.nextLine());
		System.out.println("Price per share");
		stk.setPricePerShare(get.sc.nextDouble());
		System.out.println("Number of Share");
		stk.setTotalShare(get.sc.nextDouble());
		stockName.add(stk);
	}
	public void addStockInStockBook() throws FileNotFoundException
	{  
    try
	 {
    	stockName.clear();
	    fileName=StockPortfolio.openFile("StockBook",stockName);
		System.out.println("Number of stocks");
		int totNumberOfStock=get.sc.nextInt();
		for(int i=0;i<totNumberOfStock;i++)
			addStock();
		try{
		StockPortfolio.writeToFile(fileName,stockName);
		}
		catch(Exception e)
		{
			System.out.println("Unable to write file");
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception :" + e);
	}
	}
}
