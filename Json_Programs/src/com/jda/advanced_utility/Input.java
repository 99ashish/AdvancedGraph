package com.jda.advanced_utility;
import java.util.Scanner;
/**
 * This is a singleton class for getting input from user.
 */
public class Input {
public Scanner sc;
private static Input scan=null;
private Input()
{
	sc=new Scanner(System.in);
}
public static Input getInputInstance()
{
	if(scan==null)
	 scan= new Input();
	return scan;
}
}
