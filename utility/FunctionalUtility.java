package com.jda.utility;
import  java.util.Scanner;

public class FunctionalUtility {
	static Scanner sc = new Scanner(System.in);
	public static int getInteger()
	{
	String getval=sc.next();
	int value=Integer.valueOf(getval);
	return value;
	}
	public static float getFloat()
	{
	String getval=sc.next();
	float value=Float.valueOf(getval);
	return value;
	}
	public static String getNext()
	{
	String getval=sc.next();
	return getval;
	}
	public static String getString()
	{
	String stringval=sc.nextLine();
	return stringval;
	}
}
