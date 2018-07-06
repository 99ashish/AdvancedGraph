package com.jda.core;
import com.jda.utility.FunctionalUtility;
public class TwoDArray 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the row number :");
		int m=FunctionalUtility.getInteger();
		System.out.println("Enter the column number");
		int n=FunctionalUtility.getInteger();
		System.out.println("Enter " + m*n + " values");
		String[][] multi =new String[m][n];
		for(int i = 0 ; i < m ; i++)
		{
			for (int j = 0 ; j < n ; j++)
			{
				multi[i][j]=FunctionalUtility.getNext();
			}
		}
		for(int i = 0 ; i < m ; i++)
		{
			for (int j = 0 ; j < n ; j++)
			{
				System.out.print(multi[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
