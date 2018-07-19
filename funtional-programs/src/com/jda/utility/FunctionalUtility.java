package com.jda.utility;
import  java.util.Scanner;
public class FunctionalUtility {
	static Scanner sc = new Scanner(System.in);
	public static  boolean primeChecker(int val)
	{
	for(int i=2; i*i<=val; i++)
	{
		if(val%i ==0 )
			return false;
	}
	return true;
    }
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
