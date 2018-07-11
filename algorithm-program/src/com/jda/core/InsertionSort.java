package com.jda.core;
import java.util.ArrayList;
import java.util.List;
import com.jda.utility.AlgorithmUtility;
/**
 * Insertion sort for List of string.
 * @author bridgelabz
 *
 */
public class InsertionSort 
{
	public static void main(String[] args) 
	{
		List<String> str=new ArrayList<> ();
		System.out.println("Entre the size of list");
		int listSize= AlgorithmUtility.getInteger();
		for(int i=0;i<listSize;i++)
		str.add(AlgorithmUtility.getString());
		str= AlgorithmUtility.insertionSortForString(str, listSize);
		System.out.println(str);
	}
}
