package com.jda.core;
import java.util.ArrayList;
/**
 * Give the range to the system from 0 to 1000
 * and get the prime number series.
 */
import java.util.List;

import com.jda.utility.AlgorithmUtility;
public class PrimeSeries 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the start and end limit (should be in 0-1000 range)");
		int strt=AlgorithmUtility.getInteger();
		int end =AlgorithmUtility.getInteger();
		 List<Integer> series=AlgorithmUtility.primeSeries(strt, end);
		System.out.println("Prime Series is: \n" + series);
	}
}
