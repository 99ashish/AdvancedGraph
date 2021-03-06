package com.jda.core;
import com.jda.Utility.Queue;
import com.jda.utility.AlgorithmUtility;
public class QueueLinkedListCalender 
{
	public static void main(String[] args) 
	{
		int month = Integer.valueOf(args[0]);
		int year = Integer.valueOf(args[1]);
		int strtDay = AlgorithmUtility.dayOfWeek(month, 1, year);
		Queue cal=new Queue();
		cal.push("S  ");
		cal.push("M  ");
		cal.push("T  ");
		cal.push("W  ");
		cal.push("Th ");
		cal.push("F  ");
		cal.push("Sa ");
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			day[1]++;
		int totDay = day[month - 1];
		int cntDay = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 1 && strtDay > j)
					cal.push( "     ");
				else {
					if (cntDay <=totDay ) {
						if (cntDay < 10)
							cal.push(String.valueOf((cntDay++) + "   "));
						else
							cal.push(String.valueOf((cntDay++))+" ");
					} else
						cal.push("  ");
				}
	}
 }
	for(int i=0;i<6;i++)
	{
		for(int j=0;j<7;j++)
		{
			System.out.print(cal.deque());	
		}
		System.out.println();
	}
}
}
