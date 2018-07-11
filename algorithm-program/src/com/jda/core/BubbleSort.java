package com.jda.core;
import java.util.ArrayList;
import java.util.List;

import com.jda.utility.AlgorithmUtility;
public class BubbleSort 
{
	public static void main(String[] args) 
	{
		List<Integer> str=new ArrayList<> ();
		System.out.println("Entre the size of list");
		int listSize= AlgorithmUtility.getInteger();
		for(int i=0;i<listSize;i++)
		str.add(AlgorithmUtility.getInteger());
		str= AlgorithmUtility.bubbleSortForInteger(str, listSize);
		System.out.println(str);
	}
}
