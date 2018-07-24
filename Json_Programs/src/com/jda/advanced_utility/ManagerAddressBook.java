package com.jda.advanced_utility;

import com.jda.advanced_utility.Person;
import com.jda.advanced_utility.AddressBook;
import com.jda.advanced_utility.Input;

public class ManagerAddressBook {
	
public static void main(String )	
	do
		{
		     System.out.println("1. Create New Address Book");
		     System.out.println("2. Open Existing Address Book");
		     System.out.println("3. Close ");
		     System.out.println("4. Save");
		     System.out.println("5. Save as");
		     System.out.println("6. Quit");
		     int opt=Input.getInteger();
		     AddressBook  addressBook;
		       switch(opt)
		       {
		           case 1:
		                       System.out.println("Enter the name of the Address Book");
		                       String nameOfAddressBook=Input.getString();
		                       addressBook=new AddressBook(nameOfAddressBook);
		                       break;
		           case 2: 
		        	           System.out.println("Enter the name of the Existing Address Book");
		        	           String nameOfOpeningAddressBook=Input.getString();
		        	           addressBook = new AddressBook(nameOfOpeningAddressBook);	
		        	           break;
		         default:
		        	          System.out.println("Worng Entry"); break;
		       }
		}while(true);
}}