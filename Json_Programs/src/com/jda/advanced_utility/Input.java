package com.jda.advanced_utility;
import java.util.Scanner;
public class Input {
static Scanner sc=new Scanner(System.in);
public static int getInteger()
{
	return sc.nextInt();
}
public static long getLong()
{
	return sc.nextLong();
}
public static String getString()
{
	return sc.nextLine();
}
}
