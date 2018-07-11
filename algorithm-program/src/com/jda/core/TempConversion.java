package com.jda.core;
import com.jda.utility.AlgorithmUtility;
public class TempConversion 
{
 public static void main(String[] args) 
 {
		System.out.println("Press 1 for celsius to Farenhuiet conversion and press any number thing for vice vers");
       int opt=AlgorithmUtility.getInteger();
       if(opt==1)
       {
    	   System.out.println("Enter tempareture in farenhuiet");
    	   		float tmp=AlgorithmUtility.getFloat();
    	   		System.out.println(tmp + " F = "+ AlgorithmUtility.tempratureConversion(tmp, opt)+ " C");
       }
       else
       {
    	 System.out.println("Enter tempareture in celcius");
  		float tmp=AlgorithmUtility.getFloat();
  		System.out.println(tmp + " C = "+ AlgorithmUtility.tempratureConversion(tmp, opt)+ " F");
      }
    	   
 }

}
