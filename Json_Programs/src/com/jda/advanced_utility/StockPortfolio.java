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
import com.jda.Utility.Queue;
import com.jda.Utility.Stack;
public class StockPortfolio {
	public static List<Stock> stockList = new ArrayList<>();
	private static Input get = Input.getInputInstance();
	private static String path = "/home/bridgelabz/Desktop/JavaCode/StakeHolder/";
	private File fileName;
   Queue<Transaction> que=new Queue<>();
   Stack<Stock> stack=new Stack<>();
 
	public static <T> void readFromFile(File fileName, List<T> putValue) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(fileName);
			for (JsonNode obj : node) {
				T stk = (T) mapper.treeToValue(obj, Stock.class);
				putValue.add(stk);
			}
		} catch (Exception e) {
			System.out.println();
		}
	}

	public static <T> void writeToFile(File fileName, List<T> obj)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
		writer.writeValue(fileName, obj);
	}
	private static boolean checkExisitingFile(String fileName) {
		fileName+=".json";
		File file = new File(path);
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().contains(".json")) {
				if (f.getName().equals(fileName))
					return true;
			}
		}
		return false;
	}
	private void addIntoQueue(List<Stock> list)
	{
		for(int i=0;i<list.size();i++)
			que.push(list.get(i).getTransAction());
	}
	private void addIntoStack(List<Stock> list)
	{
		for(int i=0;i<list.size();i++)
			stack.push(list.get(i));
	}
	void buy() {
		StockBook.stockName.clear();
		StockBook.showStockName();
		stockList.clear();
		que.front=null;
		readFromFile(fileName, stockList);
		addIntoQueue(stockList);
		stack.top=null;
		addIntoStack(stockList);
		Stock stk = new Stock();
		boolean exist = false;
		System.out.println("Enter the stock name");
		stk.setNameOfStack(get.sc.nextLine());
		System.out.println("Number of stock");
		stk.setTotalShare(get.sc.nextDouble());
		int len = StockBook.stockName.size();
		for (int i = 0; i < len; i++) {
			if (stk.getNameOfStack().equals(StockBook.stockName.get(i).getNameOfStack())) {
				if (stk.getTotalShare() <= StockBook.stockName.get(i).getTotalShare()) {
					stk.setPricePerShare(StockBook.stockName.get(i).getPricePerShare());
					Transaction tr = new Transaction();
					tr.setTransactionType("buy");
					tr.setDate();
					stk.setTransAction(tr);
					Stock stkBook = StockBook.stockName.get(i);
					double remainShare = stkBook.getTotalShare() - stk.getTotalShare();
					stkBook.setTotalShare(remainShare);
					StockBook.stockName.set(i, stkBook);
					stockList.add(stk);
					exist = true;
					try {
						que.push(tr);
						writeToFile(fileName, stockList);
						writeToFile(StockBook.fileName, StockBook.stockName);
					} catch (Exception e) {
						System.out.println("Unable to update file  system");
					}
					System.out.println("You successfully buy the share");
				} else {
					System.out.println("Total share is out of bound");
				}
			}

		}
		if (!exist)
			System.out.println("Not able to process your request");
	}

	void sell() throws FileNotFoundException {
		stockList.clear();
		StockBook.stockName.clear();
		readFromFile(fileName, stockList);
		StockBook.showStockName();
		que.front=null;
		addIntoQueue(stockList);
		stack.top=null;
		addIntoStack(stockList);
		Stock stk = new Stock();
		boolean exist=false;
		System.out.println("Enter the stock name");
		stk.setNameOfStack(get.sc.nextLine());
		System.out.println("Number of stock");
		stk.setTotalShare(get.sc.nextDouble());
		int len = stockList.size();
		for (int i = 0; i < len; i++) {
			if (stk.getNameOfStack().equals(stockList.get(i).getNameOfStack())) {
				if (checkStockAvailbility(stk.getNameOfStack(),stk.getTotalShare())) {
					
					stk.setPricePerShare(stockList.get(i).getPricePerShare());
					Transaction tr = new Transaction();
					tr.setTransactionType("sell");
					tr.setDate();
					stk.setTransAction(tr);
					int idx=getIndexOfCompany(stk.getNameOfStack());
					System.out.println(idx);
					if(idx>=0)
					{
						
					Stock stkBook = StockBook.stockName.get(idx);
					double addShare = stkBook.getTotalShare() + stk.getTotalShare();
					stkBook.setTotalShare(addShare);
					StockBook.stockName.set(idx, stkBook);
					stockList.add(stk);
					exist=true;
					try {
						que.push(tr);
						stack.push(stk);
						writeToFile(fileName, stockList);
						writeToFile(StockBook.fileName, StockBook.stockName);
						
					} catch (Exception e) {
						System.out.println("Unable to update file  system");
					}
					System.out.println("You successfully sell the share");	
				}
				}
				break;
			}
			}
		if(!exist)
			System.out.println("Not able to sell the share");
	}

	private int getIndexOfCompany(String nameOfStack) {
		StockBook.stockName.clear();
		readFromFile(StockBook.fileName, StockBook.stockName);
		int len=StockBook.stockName.size();
		for(int i=0;i<len;i++)
		{	if(StockBook.stockName.get(i).getNameOfStack().equals(nameOfStack))
				return i;
		}
		return -1;
	}

	private boolean checkStockAvailbility(String nameOfStack,double share) {
		double totalValue=0;
		for (int i = 0; i < stockList.size(); i++)
		{
	    if(stockList.get(i).getNameOfStack().equals(nameOfStack))
	    {
			if(stockList.get(i).getTransAction().getTransactionType().equals("buy"))
			
			totalValue += stockList.get(i).getTotalShare();
		else
			totalValue -= stockList.get(i).getTotalShare();
			
	    }
		}
		
		if(totalValue>=share)
			return true;
		return false;
	}

	void valueOf() {
		readFromFile(fileName, stockList);
		double totalValue = 0;
		for (int i = 0; i < stockList.size(); i++)
		{
	
			if(stockList.get(i).getTransAction().getTransactionType().equals("buy"))
			
			totalValue += (stockList.get(i).getPricePerShare() * stockList.get(i).getTotalShare());
		else
			totalValue -= (stockList.get(i).getPricePerShare() * stockList.get(i).getTotalShare());
			
	    }
		System.out.println("\t\t\t\t" + "Total value of your account is :" + totalValue + "INR");
	}

	void saveAccount() {
		try {
			writeToFile(fileName, stockList);
		} catch (Exception e) {
			System.out.println("Not able to save your account " + e);
		}
	}

	void getAccountDetail() {
		stockList.clear();
		readFromFile(fileName, stockList);
		
		for (int i = 0; i < stockList.size(); i++) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\t\t\t\t"   + "Company Name:        "+stockList.get(i).getNameOfStack() 
					         + "\n\t\t\t\t" + "Price per share:     "+stockList.get(i).getPricePerShare()
					         + "\n\t\t\t\t" + "Total share:         "+stockList.get(i).getTotalShare() 
					         + "\n\t\t\t\t" + "Transaction Type:     "+stockList.get(i).transAction.getTransactionType() 
					         + "\n\t\t\t\t" + "Date of transaction: "+stockList.get(i).transAction.getDate());
		}
		System.out.println("--------------------------------------------------------------------------");

	}

	private void openAccount() throws FileNotFoundException {
		while (true) {
			System.out.println(
					"\t\t\t" + "1.Buy" + "\n\t\t\t" + "2.sell" + "\n\t\t\t" + "3. Value of total Stock" + "\n\t\t\t"
							+ "4. Save Account" + "\n\t\t\t" + "5.Print Account Detail" + "\n\t\t\t" + "6.Go to back");
			int opt = get.sc.nextInt();
			get.sc.nextLine();
			switch (opt) {
			case 1:buy();break;
			case 2:sell();break;
			case 3:valueOf();break;
			case 4:saveAccount();break;
			case 5:getAccountDetail();break;
			case 6:return;
			default:System.out.println("Choose valid option");openAccount();break;
			}
		}
	}

	public void stockAccount() throws IOException {
		get.sc.nextLine();
		while(true)
		{
		System.out.println("Enter your account name");
		String filename = get.sc.nextLine();
		if (!checkExisitingFile(filename)) {
			try {
				fileName = new File(path+filename+".json");
				fileName.createNewFile();
				break;
			} catch (Exception e) {
				System.out.println("Unable to open account");
			}
		} else {
			System.out.println("Account already exist try with another name");
		}
		}
		
	}
	public static File openFile(String filename, List<Stock> putValue) throws FileNotFoundException {
		filename = path + filename + ".json";
		File fileName = new File(filename);
		readFromFile(fileName, putValue);
		return fileName;
	}
	public void openStockAccount() {
		get.sc.nextLine();
		while(true)
		{
		System.out.println("Enter your account name");
		String filename = get.sc.nextLine();
		if (checkExisitingFile(filename)) {
			try {
				fileName = new File(path+filename+".json");
				openAccount();
				break;
			} catch (Exception e) {
				System.out.println("Unable to open account");
			}
		} else {
			System.out.println("Account name doesn't exist");
		}
		}
		
	}
}
