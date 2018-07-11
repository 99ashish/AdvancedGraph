package com.jda.core;
import com.jda.utility.FunctionalUtility;
public class PrimeFactor 
{
	static  boolean primeChecker(int val)
	{
	for(int i=2; i*i<=val; i++)
	{
		if(val%i ==0 )
			return false;
	}
	return true;
    }
public static void main(String[] args) 
{
		// TODO Auto-generated method stub
		System.out.println("Enter a  number");
		int number = FunctionalUtility.getInteger();
		System.out.println("Prime Factor of " +  number + " are");
      for(int i=2; i*2 <= number; i++)
      {
    	  if ( (number% i == 0) && primeChecker(i) )
    	  {
    		  System.out.print(i +" ");
    	  }    		  
      }
	}
}
