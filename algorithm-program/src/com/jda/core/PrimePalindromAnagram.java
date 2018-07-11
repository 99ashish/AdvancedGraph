package com.jda.core;
import java.util.List;
import com.jda.utility.AlgorithmUtility;

/**
 * Firstlly get series of prime number between given range. Then apply palindrom
 * check for that element and if it is palindrom then check its anagram pair
 * exist or not in the prime series and print.
 * 
 * @author bridgelabz
 *
 */
public class PrimePalindromAnagram 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the start and end limit (should be in 0-1000 range)");
		int strt = AlgorithmUtility.getInteger();
		int end = AlgorithmUtility.getInteger();
		List<Integer> series = AlgorithmUtility.primeSeries(strt, end);
		int len = series.size();
		for (int i = 0; i < len; i++) 
		{
			String first = String.valueOf(series.get(i));
			if (AlgorithmUtility.palindrom(first)) 
			{
				for (int j = i + 1; j < len; j++) 
				{
					String second = String.valueOf(series.get(j));
					// System.out.println(second.charAt(0));
					if (AlgorithmUtility.checkAnagram(first, second)) 
					{
						System.out.println(series.get(i) + " " + series.get(j));
					}
				}
			}
		}
	}
}
