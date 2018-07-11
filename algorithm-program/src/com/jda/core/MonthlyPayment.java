package com.jda.core;
import com.jda.utility.AlgorithmUtility;
/** 
   *Pass the command­line arguments P, Y, and R and calculates the monthly payments you
   *would have to make over Y years to pay off a P principal loan amount at R per cent
   *interest compounded monthly.
   *
   */
public class MonthlyPayment 
{
	public static void main(String[] args) 
	{
		float principalAmnt=Float.valueOf(args[0]);
		float year =Float.valueOf(args[1]);
		float intrst=Float.valueOf(args[2]);
		System.out.println("Monthly Payment: " + AlgorithmUtility.montlyPayment(principalAmnt, year, intrst) );
	}
}
