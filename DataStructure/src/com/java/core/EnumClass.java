package com.java.core;

enum Name{
	Ashish, Ankur, Amit, Rohit, Neeraj
}
public class EnumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Name nameList[] = Name.values();
        for (Name name : nameList) {
        	System.out.println(name);	
		}
        System.out.println(Name.valueOf("Ashish"));
        Name nameOfTheStudent = Name.Amit;
        if(nameOfTheStudent == Name.Amit)
        {
        	System.out.println(nameOfTheStudent);
        }
	}
}
