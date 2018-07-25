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
public class AddressBook 
{
	String addressBookName;
	List<Person> personList = new ArrayList<>();
	private static Input get =Input.getInputInstance();
    // Add a new person in the address book 
	public void addPerson()
    {
    	Person p1 = new Person();
		System.out.println("First name");
		p1.setFirstName(get.sc.nextLine());
		System.out.println("Last name");
		p1.setLastName(get.sc.nextLine());
		System.out.println("Address");
		p1.setAddress(get.sc.nextLine());
		System.out.println("City");
		p1.setCity(get.sc.nextLine());
		System.out.println("state");
		p1.setState(get.sc.nextLine());
		System.out.println("Zip");
		p1.setZipCode(get.sc.nextInt());
		System.out.println("Mobile Number");
		p1.setMobileNumber(get.sc.nextLong());
		personList.add(p1);
    }
	// Edit person detail in the address book.
    public void editPerson()
    {
    	int len=personList.size();
    			int idx=-1;
    	System.out.println("first name");
		String firstName = get.sc.nextLine();
		System.out.println("last name");
		String lastName = get.sc.nextLine();
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
    // Update address book of the person.
    private void updateAddress(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Address");
    	personList.set(idx, p.setAddress(get.sc.nextLine()));	
    }
    //Update mobile number of the person.
    private void updateMobileNumber(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Mobile Number");
    	p.setMobileNumber(get.sc.nextInt());
    	personList.set(idx, p);	
    }
    //Update Zip code of the person in address book.
    private void updateZipCode(int idx)
    {
    	Person p=personList.get(idx);
    	System.out.println("New Zip Code");
    	p.setZipCode(get.sc.nextInt());
    	personList.set(idx, p); 		
    }
    // Editable option which is provided to manager of address book.
    private void editableOption(int idx)
    {
			System.out.println(
					 "1.Update Address" + "\n" + "2.Update Moblie number" + "\n" + "3.Update Zip Code");
			int opt1 = get.sc.nextInt();
			get.sc.nextLine();
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
    //Delete a person from address book.
    public void deletePerson()
    {
		System.out.println("Enter the first and last name of person");
		String deleteFirstName = get.sc.nextLine();
		String deleteLastName = get.sc.nextLine();
		int len=personList.size();
		for (int i = 0; i < len; i++) {
			if (personList.get(i).getFirstName() .equalsIgnoreCase( deleteFirstName)
					&& personList.get(i).getLastName().equalsIgnoreCase(deleteLastName)) {
				personList.remove(personList.get(i));
				return;
			}
		}
		
			System.out.println("Sorry Person dosn't exist");
    }
    // Show total json file of the existing file.

	
	
	public void saveFile() {
			}

		public  void sortByName() {
		Collections.sort(personList, byName);
		for(Person pr:personList)
		{
			printPersonDetail(pr);
		}
	}

	/*public void editPersonDetail(int idx, Person p) {
		personList.set(idx, p);
	}*/
    private void printPersonDetail(Person p) {
    	System.out.println("****************************************************");
    	System.out.println(p.getFirstName()+p.getLastName());
    	System.out.println("\t\t\t\t"+p.getAddress()+"\n\t\t\t\t"+p.getCity()
    	+"\n\t\t\t\t"+p.getState()+ "\n\t\t\t\t"+p.getZipCode()
    	  +"\n\t\t\t\t" + p.getMobileNumber());
	}
	public void sortByZipCode() {
		Collections.sort(personList, byZipCode);
		for(Person pr:personList)
		{
			printPersonDetail(pr);
		}
	}
	public void view()
	{
		for(Person pr:personList)
		{
			printPersonDetail(pr);
		}
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
			if (p1.getLastName().equalsIgnoreCase(p2.getLastName()))
				return p1.getFirstName().compareTo(p2.getFirstName());
			return p1.getLastName().compareTo(p2.getLastName());
		}
	};
private	static Comparator<Person> byZipCode = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.getZipCode() - (p2.getZipCode());
		}
	};

}
