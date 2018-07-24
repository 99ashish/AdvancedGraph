package com.jda.advanced_utility;
import java.io.File;
import com.jda.advanced_utility.AddressBook;

public class ManagerAddressBook {
 private static AddressBook addressBook= null;
 public void createFile()
 {
	 addressBook=new AddressBook();
	 addressBook.createAddressBook();	 
 }
 public void close()
 {
	addressBook.saveFile();
	try
	{
	//addressBook.fileName.close();
	}
	catch(Exception e)
	{
		System.out.print("Unable to close file " + e);
	}
 }
 public void save()
 {
	 addressBook.saveFile(); 
 }
 public void saveAs()
 {
	 
 }
 public void open()
 {
	 addressBook=new AddressBook();
	 try {	
		 File fileName=addressBook.openFile();
		 addressBook.readFromFile(fileName);
		 while(true)
		 {
			System.out.println(
					"1.Add" + "\n" + "2.Edit" + "\n" + "3.Delete" + "\n" + "4.Sort By Name" + "\n" + "5.Sort By Zip" +"\n" +"6.Go to back");
			int opt = Input.getInteger();
			Input.getString();
			if(opt==6)
				break;
			switch(opt)
			{
			case 1:addressBook.addPerson();break;
			case 2:addressBook.editPerson();break;
			case 3:addressBook.deletePerson();break;
			case 4:addressBook.sortByName();break;
			case 5:addressBook.sortByZipCode();break;
			}
		 }
		 addressBook.writeToFile(fileName);
        }
	 catch(Exception e)
	 {
		 System.out.println("Unable to open file " + e);
	 }
}
}
