package com.jda.advanced_utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

/**
 * Address Book class for the Address book manager. It have different -2 method for sorting 
 * data like- sort by firstname, Zipcode and etc. For adding person into the address book we
 * have method add and for removing person from the address book we have remove method 
 * which directly remove person from the address book.
 * @author bridgelabz
 *
 */
public class AddressBook{
	Comparator<Person> byName=new Comparator<Person>() {
		 public int compare(Person p1, Person p2) {
	           return p1.getFirstName() .compareTo( p2.getFirstName());
	       }
	};
	Comparator<Person> byZipCode=new Comparator<Person>() {
		 public int compare(Person p1, Person p2) {
	          return p1.getZipCode() -( p2.getZipCode());
	      }
	};
	List<Person> personList = new ArrayList<>();
	
  ////System.out.println("1.Add");
	public void add(Person p)
	{
		personList.add(p);
	}
	public void remove(Person p)
	{
		personList.remove(p);
	}
	public List<Person>  sortByName(List<Person> personList)
	{
		Collections.sort(personList,byName);
		return personList;
	}
	public List<Person>  sortByZipCode(List<Person> personList)
	{
		Collections.sort(personList,byZipCode);
		return personList;
	}
}
