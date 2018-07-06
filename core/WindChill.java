package com.jda.core;
import java.lang.Math;

import com.jda.utility.FunctionalUtility;
public class WindChill
{
	public static void main(String[] args)
	{
	 System.out.println("Enter the value of temprature t and wind speed v ");
	 float t=FunctionalUtility.getFloat();
	 float v=FunctionalUtility.getFloat();
	 float ans = (float)(35.74 + 0.6215*t + (((0.4275*t)-35.75)*Math.pow(v,0.16))) ;
	 System.out.println("Effective temprature is " + ans );
	}
	
	
}