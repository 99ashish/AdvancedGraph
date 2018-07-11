package com.jda.core;
import com.jda.utility.*;
public class ReplaceTemplate 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the UserName:");
		String username= FunctionalUtility.getString();
		String mystring = "Hello <<UserName>>, How are you?";
       mystring = mystring.replaceFirst("<<UserName>>", username);
       System.out.println(mystring);
	}
}
