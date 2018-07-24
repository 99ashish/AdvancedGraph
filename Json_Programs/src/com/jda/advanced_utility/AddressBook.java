package com.jda.advanced_utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import java.io.*;

/**
 * Address Book class for the Address book manager. It have different -2 method
 * for sorting data like- sort by firstname, Zipcode and etc. For adding person
 * into the address book we have method add and for removing person from the
 * address book we have remove method which directly remove person from the
 * address book.
 *
 */
public class AddressBook {
	String addressBookName;
	List<Person> personList = new ArrayList<>();
    public void addPerson()
    {
    	Person p1 = new Person();
		System.out.println("First name");
		p1.setFirstName(Input.getString());
		System.out.println("Last name");
		p1.setLastName(Input.getString());
		System.out.println("Address");
		p1.setAddress(Input.getString());
		System.out.println("City");
		p1.setCity(Input.getString());
		System.out.println("state");
		p1.setState(Input.getString());
		System.out.println("Zip");
		p1.setZipCode(Input.getInteger());
		System.out.println("Mobile Number");
		p1.setMobileNumber(Input.getLong());
		personList.add(p1);
    }
    public void editPerson()
    {
    	int len=personList.size(),idx=-1;
    	System.out.println("first name");
		String firstName = Input.getString();
		System.out.println("last name");
		String lastName = Input.getString();
		for (int i = 0; i < len; i++) {
			if (personList.get(i).getFirstName().equals( firstName) && personList.get(i).getLastName().equals( lastName)) {
				idx = i;
			}
		}
		if(idx>=0)
		{
			editableOption(idx);
			return;
		}
		System.out.println("Person not exist");
    }
    private void updateAddress(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Address");
    	personList.set(idx, p.setAddress(Input.getString()));
    	
    }
    private void updateMobileNumber(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Mobile Number");
    	p.setMobileNumber(Input.getLong());
    	personList.set(idx, p);
    	
    }
    private void updateZipCode(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Zip Code");
    	p.setZipCode(Input.getInteger());
    	personList.set(idx, p); 		
    }
    private void editableOption(int idx)
    {
			System.out.println(
					 "1.Update Address" + "\n" + "2.Update Moblie number" + "\n" + "3.Update Zip Code");
			int opt1 = Input.getInteger();
			Input.getString();
			switch (opt1) {
			case 1:
				updateAddress(idx);
				break;
			case 2:
				updateMobileNumber(idx);
				break;
			case 3:
				updateZipCode(idx);
				break;
			default:
				System.out.println("worng Entery");
			}
		}
    public void deletePerson()
    {
		System.out.println("Enter the first and last name of person");
		String deleteFirstName = Input.getString();
		String deleteLastName = Input.getString();
		Person person = null;
		int len=personList.size();
		for (int i = 0; i < len; i++) {
			if (personList.get(i).getFirstName() == deleteFirstName
					&& personList.get(i).getLastName() == deleteLastName) {
				person = personList.get(i);
			}
		}
		if (person != null)
			personList.remove(person);
		else
			System.out.println("Sorry Person dosn't exist");
    }
	public static void showTotalJsonFile() {
		File file = new File("C:/Users/1022784/Desktop/gitProgram/");
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().contains(".json")) {
				System.out.print(f.getName() + " ");
			}
		}
		System.out.println();
	}

	private boolean checkExisitingFile(String fileName) {
		File file = new File("C:/Users/1022784/Desktop/gitProgram/");
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().contains(".json")) {
				if (f.getName().equals(fileName + ".json"))
					return true;
			}
		}
		return false;
	}

	public void createAddressBook() {
		System.out.println("Enter the name of the Address Book");
		 addressBookName = Input.getString();
		if (checkExisitingFile(addressBookName)) {
			System.out.println("file already exist");
	 		return;
		}
		try {
			String filename = "C:/Users/1022784/Desktop/gitProgram/" + addressBookName + ".json";
			 File file = new File(filename);
			file.createNewFile();
		} catch (Exception e) {
			System.out.println("Unable to create file");
		}
	}
	public void saveFile() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
		try {
			writer.writeValue(new File("C:/Users/1022784/Desktop/gitProgram/" + addressBookName + ".json"),
					personList);
		} catch (Exception e) {

		}
	}
	public void closeAddBook() {
		
	}

	public void saveAs() {
		System.out.println("New Name of the file");
		this.addressBookName = Input.getString();
	}

	public void add(Person p) {
		personList.add(p);
	}

	public void remove(Person p) {
		personList.remove(p);
	}

	public  void sortByName() {
		Collections.sort(personList, byName);
		for(Person pr:personList)
		{
			printPersonDetail(pr);
		}
	}

	public void editPersonDetail(int idx, Person p) {
		personList.set(idx, p);
	}
    private void printPersonDetail(Person p) {
    	System.out.println("****************************************************");
    	System.out.println(p.getFirstName()+p.getLastName());
    	System.out.println("\t\t\t\t"+p.getAddress()+"\n\t\t\t\t"+p.getCity()
    	+"\n\t\t\t\t"+p.getState()+ "\n\t\t\t\t"+p.getZipCode()
    	  +"\n\t\t\t\t" + p.getMobileNumber());
    	System.out.println("****************************************************");
	}
	public void sortByZipCode() {
		Collections.sort(personList, byZipCode);
		for(Person pr:personList)
		{
			printPersonDetail(pr);
		}
	}
	public File openFile() throws FileNotFoundException
	{
		AddressBook.showTotalJsonFile();
		 System.out.println("Enter the name of the Existing Address Book");
		 addressBookName=Input.getString();
		 String filename = "C:/Users/1022784/Desktop/gitProgram/" + addressBookName + ".json";
		 File fileName= new File(filename);
		 return fileName;
	}
	public void readFromFile(File fileName) 
	{
		try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fileName);
        for(JsonNode obj:node)
        {
        	Person pr=mapper.treeToValue(obj,Person.class);
        	personList.add(pr);

        }
		}
		catch(Exception e)
		{
			System.out.println("Empty File");
		}

	}
	public void writeToFile(File fileName) throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
			writer.writeValue(fileName,
					personList);
	}
private	static Comparator<Person> byName = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			if (p1.getLastName().equals(p2.getLastName()))
				return p1.getFirstName().compareTo(p2.getFirstName());
			return p1.getLastName().compareTo(p2.getLastName());
		}
	};
private	static Comparator<Person> byZipCode = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.getZipCode() - (p2.getZipCode());
		}
	};

	public void closeAddressBook() {
		// TODO Auto-generated method stub

	}
}
