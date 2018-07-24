package com.jda.advanced_utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import java.io.*;
/**
 * Address Book class for the Address book manager. It have different -2 method for sorting 
 * data like- sort by firstname, Zipcode and etc. For adding person into the address book we
 * have method add and for removing person from the address book we have remove method 
 * which directly remove person from the address book.
 *
 */
public class AddressBook{
	String addressBookName;
	File addressBookFile;
	List<Person> personList = new ArrayList<>();
	public AddressBook(String addressBookName){
		this.addressBookName=addressBookName;
	}
	public static void showTotalJsonFile()
	{
		File file=new File("/home/bridgelabz/Desktop/java-programs/");
		File[] files=file.listFiles();
		for(File f: files)
		{
			if(f.getName().contains(".json"))
			{
			System.out.print(f.getName() + " ");
			}
		}
		System.out.println();
	}
	public boolean checkExisitingFile(String fileName)
	{
		File file=new File("/home/bridgelabz/Desktop/java-programs/");
		File[] files=file.listFiles();
		for(File f: files)
		{
			if(f.getName().contains(".json"))
			{
			if(f.getName().equals(fileName+".json"))
			return true;
			}
		}
		return false;
	}
	public void createFile()
	{
		if(checkExisitingFile(addressBookName))
		{
			System.out.println("file already exist");
			return;
		}
		try{
			String filename="/home/bridgelabz/Desktop/java-programs/" + addressBookName+ ".json";
			addressBookFile=new File(filename);  
			addressBookFile.createNewFile();  
		}
		catch(Exception e)
		{
			System.out.println("Unable to create file");
		}
	}
	public  void save()
	{
		System.out.println("Saved");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
		try{
		writer.writeValue(new File("/home/bridgelabz/Desktop/java-programs/"+ addressBookName +".json"), personList);
		}
		catch(Exception e)
		{
			
		}
	}
	public void closeAddBook()
	{
		save();
	}
	public void saveAs()
	{
		System.out.println("New Name of the file");
		this.addressBookName=Input.getString();
	}
	public void add(Person p)
	{
		personList.add(p);
	}
	public void remove(Person p)
	{
		personList.remove(p);
	}
	public static List<Person>  sortByName(List<Person> personList)
	{
		Collections.sort(personList,byName);
		return personList;
	}
	public void editPersonDetail(int idx,Person p)
	{
		personList.set(idx,p);
	}
	public static List<Person>  sortByZipCode(List<Person> personList)
	{
		Collections.sort(personList,byZipCode);
		return personList;
	}
	public void openFunction(AddressBook NameOfOpenedAddressBook)
	{
		ObjectMapper mapper = new ObjectMapper();
		 //mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try{
		 Person pr= mapper.readValue(new FileInputStream("/home/bridgelabz/Desktop/java-programs/"+ addressBookName +".json"), Person.class );
		System.out.println(pr.getFirstName());
		System.out.println("1.Add"+ "\n" + "2.Edit" + "\n" + "3.Delete" +"\n" +"4.Sort By Name" + "\n" + "5.Sort By Zip");
		int opt=Input.getInteger();
		 int len=personList.size(),idx=-1;
		 System.out.println(len);
		 Input.getString();
		  switch(opt) 
		  {
		  case 1:
			          Person p1= new Person();
			          System.out.println("First name");
		              p1.setFirstName(Input.getString());
		              System.out.println("Last name");
		              p1.setLastName(Input.getString());
		              System.out.println("Address");
		              p1.setAddress(Input.getString());
		              System.out.println("City");
		              p1.setCity(Input.getString());
		              System.out.println("Zip");
		              p1.setZipCode(Input.getInteger());
		              System.out.println("Mobile Number");
		              p1.setMobileNumber(Input.getLong());
		              personList.add(p1);
		              break;
		  case 2:
			         System.out.println("Enter the first and last name of the person");
			         String firstName=Input.getString();
			         String lastName=Input.getString();
			         Person p = null;
			         for(int i=0;i<len;i++)
			         {
			        	 if(personList.get(i).getFirstName()==firstName && personList.get(i).getLastName()==lastName)
			        	 {
			        		 idx=i;
			        		 p=personList.get(i);
			        	 }
			         }
			         if(idx>=0)
			         {
			            System.out.println("1.FirstName" +"\n" + "2.LastName" + "\n" +"3.address" + "\n" + "4.Moblie number");
			            int opt1=Input.getInteger();
			            Input.getString();
			              switch(opt1)
			             {
			              case 1:
				                      System.out.println("First Name");
				                      personList.set(idx, p.setFirstName(Input.getString()));
				                      break;
			              case 2:
			            	        System.out.println("Last Name");
			            	        personList.set(idx, p.setLastName(Input.getString()));
			            	        break;
			              case 3:
			            	       System.out.println("Address");
		            	           personList.set(idx, p.setAddress(Input.getString()));
		            	           break;
			              case 4:
			            	       System.out.println("Moblie Number");
		            	            personList.set(idx, p.setMobileNumber(Input.getLong()));
		            	            break;
		            	 default: 
		            		 System.out.println("worng Entery");
			            }
			         }
			         else
			        	 System.out.println("Person not exist");
			             break;
		  case 3:
			         System.out.println("Enter the first and last name of person");
			         String deleteFirstName=Input.getString();
			         String deleteLastName=Input.getString();
			         Person person = null;
			         for(int i=0;i<len;i++)
			         {
			        	 if(personList.get(i).getFirstName()==deleteFirstName && personList.get(i).getLastName()==deleteLastName)
			        	 {
			        		 person=personList.get(i);
			        	 }
			         }
			         if(person!=null)
			         personList.remove(person);
			         else
			        	 System.out.println("Sorry Person not exist");
		  case 4:
			 personList=AddressBook.sortByName(personList);
			 break;
		  case 5:
			  personList=AddressBook.sortByZipCode(personList);
			  break;
			default:
				System.out .println("Worng Entry");
				break;
		  }
		}
		catch(Exception e)
		{
			System.out.println("Unable to read data from file "+ addressBookName +".json");
		}
		
	}
	static Comparator<Person> byName=new Comparator<Person>() {
		 public int compare(Person p1, Person p2) {
			 if(p1.getLastName().equals(p2.getLastName()))
				 return p1.getFirstName().compareTo(p2.getFirstName());
	           return p1.getLastName() .compareTo( p2.getLastName());
	       }
	};
	static Comparator<Person> byZipCode=new Comparator<Person>() {
		 public int compare(Person p1, Person p2) {
	          return p1.getZipCode() -( p2.getZipCode());
	      }
	};


	public void closeAddressBook() {
		// TODO Auto-generated method stub
		
	}
	}