package com.jda.advanced_utility;
import java.io.File;
import java.io.FileNotFoundException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import com.jda.advanced_utility.AddressBook;
/**
 * Manager Address Book class have multiple features like create new file,
 * open existing file, close file, save file and saveAs file.   
 * @author bridgelabz
 *
 */
/**
 * @author bridgelabz
 *
 */
public class ManagerAddressBook {
 private static AddressBook addressBook= null;
 private static String path="/home/bridgelabz/Desktop/JavaCode/"; 
 private static Input get =Input.getInputInstance();
 /**
 * Create a new address book which is created by manager of 
 * the address book.
 */
public void createFile()
 {
	System.out.println("Enter the name of the Address Book");
	String addressBookName;
	 while(true)
	 {
		  addressBookName= get.sc.nextLine();
	   if (checkExisitingFile(addressBookName)) 
		System.out.println("file already exist try another name");
	   else
		   break;
	}
	try {
		String filename = path + addressBookName + ".json";
		 File file = new File(filename);
		file.createNewFile();
		System.out.println("File created successfully");
	} catch (Exception e) {
		System.out.println("Unable to create file");
	}	 
 }
 /**
 * Close a existing file which is already opened by 
 * manager of address book.
 */
public void close()
 {
	save();
	addressBook=null;
	System.out.println("File closed successfully");
 }
 /**
 * Save the data into the file opened by
 * manager of address book. 
 */
public void save()
 {
	try {
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer();
		writer.writeValue(new File(path + addressBook.addressBookName + ".json"),
				addressBook.personList);
		System.out.println("File saved successfully");
	} catch (Exception e) {
     System.out.println("Unable to update the file");
	}
}
public void saveAs() 
{
	System.out.println(" File name with extension");
	 String filename= path +get.sc.nextLine();
	 try
	 {
	 File file = new File(filename);
		file.createNewFile();
		addressBook.writeToFile(file);
	 }
	 catch(Exception e)
	 {
		 System.out.println("Unable to create file");
	 }
 }

/**
 * Save a file which is already opened by
 * manager of address book,
 * @param No parameter
 * @return void
 */
private void showOption()
{
	while(true)
	 {
		System.out.println("\n\t\t\t"+"1.Add" + "\n\t\t\t" +"2.View" +"\n\t\t\t"+ "3.Edit" + "\n\t\t\t" + "4.Delete" 
	                                      + "\n\t\t\t" + "5.Sort By Name" + "\n\t\t\t" + "6.Sort By Zip" 
		                                  +"\n\t\t\t" +"7.Go to back");
		int opt = get.sc.nextInt();
		get.sc.nextLine();
		if(opt==7)
			break;
		switch(opt)
		{
		case 1:addressBook.addPerson();break;
		case 2:addressBook.view();break;
		case 3:addressBook.editPerson();break;
		case 4:addressBook.deletePerson();break;
		case 5:addressBook.sortByName();break;
		case 6:addressBook.sortByZipCode();break;
		}
	 }
}
private File openFile() throws FileNotFoundException
{
	 System.out.println("Enter the name of the Existing Address Book");
	 addressBook.addressBookName=get.sc.nextLine();
	 String filename = path + addressBook.addressBookName + ".json";
	 File fileName= new File(filename);
	 return fileName;
}
public void open()
 {
	 showTotalJsonFile();
	 try {	
		 addressBook=new AddressBook();
		 File fileName=openFile();
		 addressBook.readFromFile(fileName);
		 showOption();
		 }
	 catch(Exception e)
	 {
		 System.out.println("Unable to open file " + e);
	 }
  }
private void showTotalJsonFile() {
	File file = new File(path);
	File[] files = file.listFiles();
	for (File f : files) {
		if (f.getName().contains(".json")) {
			System.out.print(f.getName() + " ");
		}
	}
	System.out.println();
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
}
