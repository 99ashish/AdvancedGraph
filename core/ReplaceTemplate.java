package com.jda.core;
import com.jda.utility.*;
public class ReplaceTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalUtility stringUtility = new FunctionalUtility();
		System.out.println("Enter the UserName:");
		String username= stringUtility.getString();
		String mystring = "Hello <<UserName>>, How are you?";
       mystring = mystring.replaceFirst("<<UserName>>", username);
       System.out.println(mystring);
	}

}
