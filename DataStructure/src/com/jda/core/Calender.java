package com.jda.core;

import com.jda.utility.AlgorithmUtility;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = Integer.valueOf(args[0]);
		int year = Integer.valueOf(args[1]);
		int strtDay = AlgorithmUtility.dayOfWeek(month, 1, year);
		String[][] cal = new String[6][7];
		cal[0][0] = "Sun    ";
		cal[0][1] = "Mon    ";
		cal[0][2] = "Tue    ";
		cal[0][3] = "Wed    ";
		cal[0][4] = "Thu    ";
		cal[0][5] = "Fri    ";
		cal[0][6] = "Sat   ";
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			day[1]++;
		int totDay = day[month - 1];
		int cntDay = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 1 && strtDay > j)
					cal[i][j] = "            ";
				else {
					if (cntDay <=totDay ) {
						if (cntDay < 10)
							cal[i][j] = String.valueOf((cntDay++) + "          ");
						else
							cal[i][j] = String.valueOf((cntDay++) + "       ");
					} else
						cal[i][j] = "     ";
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(cal[i][j]);
			}
			System.out.println();
		}
	}
}
