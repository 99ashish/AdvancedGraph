package com.jda.core;
import com.jda.utility.*;
public class PowerOfTwo 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter a  digit lies between 0 to 31");
		int n = FunctionalUtility.getInteger();	
		if(n < 31)
		{
			int power=1, i=0;
			while( i< n)
			{
				power=power*2;
				i++;
				System.out.print(power + " ");
			}
		}
		else
		{
			System.out.println("invalid number");
		}
	}
}
