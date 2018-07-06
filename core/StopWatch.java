package com.jda.core;
import com.jda.utility.FunctionalUtility;
public class StopWatch
{
	public static void main(String[] args)
	{
	 System.out.println("Enter the 1 to start stopwatch and 2 to stop the stopwatch ");
	 long startTime=0,endTime=0;
	 while(true)
	 {
	 int opt=FunctionalUtility.getInteger();
	    if(opt == 1)
	    {
	     startTime = System.nanoTime();
	      break;
	    }
	 }
     while(true)
	 {
	 int opt=FunctionalUtility.getInteger();
	    if(opt == 2)
	    {
	     endTime   = System.nanoTime();
	      break;
	    }
	 }
     long totalTime = endTime - startTime;
     System.out.println("Total elapsed time is " + (float)(totalTime/1000000000.0) + " second");
	}
	
	
}