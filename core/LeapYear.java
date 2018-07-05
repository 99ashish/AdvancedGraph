package com.jda.core;
import com.jda.utility.*;
public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalUtility intUtility = new FunctionalUtility();
		System.out.println("Enter four digit number");
		int year = intUtility.getInteger();
		int digitinyear=year,  digit = 0;
		while(digitinyear > 0)
		{
			digitinyear=digitinyear/10;
			digit++;
		}
		if(digit == 4)
		{
		if ((year%400 == 0 )|| (year%4 == 0  && year%100 !=0))
		{
			System.out.print("Given year " + year + " is leap year");
		}
		else
		{
			System.out.print("Given year " + year + " is not a l eap year");
		}
	}
		else
		{
			System.out.print("Given number is not a valid year");
		}
     
	}

}
