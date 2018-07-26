package com.jda.advanced_core;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jda.advanced_utility.Input;

public class Regex 
{
	private static Input get =Input.getInputInstance();
	static String tmplateStr="";
	static String mobileNumber;
	static String fullName;
	static String date;
     public static void main(String[] args) 
     {
    	try 
    	{
			FileReader readFile=new FileReader("/home/bridgelabz/Desktop/JavaCode/NameTemplate.txt");
			BufferedReader br = new BufferedReader(readFile);
			  
			  try
			  {
			  String str;
			  while ((str = br.readLine()) != null)
			  {
				  tmplateStr+=str+"\n";
			  }
			  }
			  catch(IOException e)
			  {
				  System.out.println("Exception: " + e);
			  }
			  System.out.println("Enter your full name");
			   fullName=get.sc.nextLine();
			  System.out.println("Enter your mobile number");
			   mobileNumber=get.sc.nextLine();
			  System.out.println("Enter your date(dd/mm/yyyy)");
			   date=get.sc.nextLine();
			  
			  replaceName();
			  replaceFullName();
			  replaceDate();
			  replacePhoneNumber();
			  System.out.println(tmplateStr);
		} 
    	catch (FileNotFoundException e) 
    	{
			e.printStackTrace();
		}
     }
  private static void replaceName() {
         Pattern p = Pattern.compile("<<\\w+>>");
        Matcher m = p.matcher(tmplateStr);
         if (m.find()) {
             tmplateStr = m.replaceAll(fullName.split(" ")[0]);
         }
     }

     private static void replaceFullName() {
        Pattern p = Pattern.compile("<<\\w+\\s\\w+>>");
        Matcher m = p.matcher(tmplateStr);
         if (m.find()) {
             tmplateStr = m.replaceAll(fullName);
         }
     }

     private static void replaceDate() 
     {
         Pattern p = Pattern.compile("<<[d]{2}/[m]{2}/[y]{4}>>");
        Matcher m = p.matcher(tmplateStr);
         if (m.find()) {
             tmplateStr = m.replaceAll(date);
         }
     }
    private static void replacePhoneNumber() {
         Pattern p = Pattern.compile("<<91-x{10}>>");
        Matcher m = p.matcher(tmplateStr);
         if (m.find()) {
             tmplateStr = m.replaceAll(mobileNumber);
         }
     }
}
