package com.jda.core;
import com.jda.utility.AlgorithmUtility;
public class DayOfWeek 
{
	public static void main(String[] args) 
	{
       int day=Integer.valueOf(args[1]);
       int month=Integer.valueOf(args[0]);
       int year=Integer.valueOf(args[2]);
       switch(AlgorithmUtility.dayOfWeek(month, day, year))
       {
       case 0: System.out.println("Sunday");
       		         break;
       case 1: System.out.println("Monday");
	                break;
       case 2: System.out.println("Tuseday");
	                break;
       case 3: System.out.println("Wednesday");
	                 break;
       case 4: System.out.println("Thursday");
                     break;
       case 5: System.out.println("Friday");
	         break;
	         default:
	        	 System.out.println("Saturday");
       }

	}

}
