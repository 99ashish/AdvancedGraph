package com.jda.advanced_core;

import java.io.FileNotFoundException;

import com.jda.advanced_utility.Input;
import com.jda.advanced_utility.StockBook;
import com.jda.advanced_utility.StockPortfolio;

public class StockMarket {
	private static Input get =Input.getInputInstance();
	public static void main(String[] args) throws FileNotFoundException {
		while(true)
		{
			System.out.println("1.Add into stock book" + "\n" +"2.Create Account" +"\n" +"3.Show Stock Book" +"\n" +"4.Quit");
			int opt=get.sc.nextInt();
	    if(opt==4)
	    	break;
	    StockBook stockBook=new StockBook();
	    switch(opt)
	    {
	    case 1:stockBook.addStockInStockBook();break;
	    case 2:StockPortfolio user= new StockPortfolio();user.stockAccount();break;
	    case 3:stockBook.showStockName();break;
		default:System.out.println("Worng entry"); break;
		}
		}
	}

}
