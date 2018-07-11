package com.jda.core;
import com.jda.utility.AlgorithmUtility;
/**
 *  Two strings are said to anagram if we can form one string with the help of other string.
 * @author bridgelabz
 *
 */
public class Anagram {

	public static void main(String[] args) {
		String first=AlgorithmUtility.getString();
		String second=AlgorithmUtility.getString();
		if(AlgorithmUtility.checkAnagram(first, second))
		{
			System.out.println("Given Strings are anagram");
		}
		else
		{
			System.out.println("Given Strings are not anagram");
		}

	}

}
