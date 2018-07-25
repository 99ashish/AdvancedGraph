package com.jda.advanced_core;
import com.jda.advanced_utility.Input;
import com.jda.advanced_utility.ManagerAddressBook;
public class MainAddressBook 
{
	private static ManagerAddressBook managerAddressBook = null;
	private  static Input get =Input.getInputInstance();
	public static void main(String[] args) 
	{
		while (true)
		{
			System.out.println("1. New ....");
			System.out.println("2. Open....");
			System.out.println("3. Close ...");
			System.out.println("4. Save....");
			System.out.println("5. Save as....."+ "\n" +"6.Quit");
			 int opt = get.sc.nextInt();
			 if(opt==6)
				 System.exit(0);
			 get.sc.nextLine();
			managerAddressBook = new ManagerAddressBook();
			switch (opt) 
			{
			case 1:
				managerAddressBook.createFile();
				break;
			case 2:
				managerAddressBook.open();
				break;
			case 3:
				 managerAddressBook.close();
				break;
			case 4:
				managerAddressBook.save();
				break;
			case 5:
				 managerAddressBook.saveAs();
				 break;
			default:
				System.out.println("Worng Entry");
			}
		}
	}
}
