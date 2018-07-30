package com.jda.advanced_core;

import java.io.IOException;

import com.jda.advanced_utility.Input;
import com.jda.advanced_utility.StockBook;
import com.jda.advanced_utility.StockPortfolio;

public class StockMarket {
	private static Input get =Input.getInputInstance();
	static StockPortfolio user=null;
	public static void main(String[] args) throws IOException {
		while(true)
		{
			System.out.println("1.Add into stock book" + "\n" +"2.Create Account" +"\n"+"3.Existing Account"+"\n" +"4.Show Stock Book" +"\n" +"5.Quit");
			int opt=get.sc.nextInt();
	    if(opt==5)
	    	break;
	    StockBook stockBook=new StockBook();
	    switch(opt)
	    {
	    case 1:stockBook.addStockInStockBook();break;
	    case 2:if(user==null) user= new StockPortfolio();user.stockAccount();break;
	    case 3:if(user==null) user= new StockPortfolio();user.openStockAccount();break;
	    case 4:StockBook.showStockName();break;
		default:System.out.println("Worng entry"); break;
		}
		}
	}

}
