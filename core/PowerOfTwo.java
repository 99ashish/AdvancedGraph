package com.jda.core;
import com.jda.utility.*;
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalUtility intUtility = new FunctionalUtility();
		System.out.println("Enter a  digit lies between 0 to 31");
		int n = intUtility.getInteger();
		
		if(n < 30)
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
