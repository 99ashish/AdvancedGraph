package com.jda.core;
import com.jda.utility.FunctionalUtility;
public class HormonicSeries 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
    System.out.println("Enter the Nth number");
    int num=FunctionalUtility.getInteger();
    float sum=0;
    for( int i=1 ; i<=num ; i++ )
    {
    	sum += (float)1/i;
    }
    System.out.println("Sum of " + num + " hormonic number is  " + sum);
	}

}
