package com.jda.utility;
import  java.util.Scanner;

public class FunctionalUtility {
	
	public static int getInteger()
	{
	Scanner sc = new Scanner(System.in);
	String getval=sc.next();
	int value=Integer.valueOf(getval);
	return value;
	}
	public static String getString()
	{
	Scanner sc = new Scanner(System.in);
	String stringval=sc.nextLine();
	return stringval;
	}
}
