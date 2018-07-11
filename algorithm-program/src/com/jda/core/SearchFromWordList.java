package com.jda.core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.jda.utility.AlgorithmUtility;
/**
 * Firstly read data from text file in which strings are seprated from comma.
 * Read line by line data and then split the string into string arrary on the basis of comma.
 * then add the strings into the list and sort the whole array.
 * Apply binary search with key string if it's found the string found else not found.
 * @author bridgelabz
 *
 */
public class SearchFromWordList 
{
	public static void main(String[] args) throws Exception 
	{
		  // We need to provide file path as the parameter:
		  // double backquote is to avoid compiler interpret words
		  // like \test as \t (ie. as a escape sequence)
		System.out.println("Please give the correct path of the text file:");
		String fileName=AlgorithmUtility.getString();
		  File file = new File(fileName);
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  String st;
		  String[] tmpstr;
		  List<String> str= new ArrayList<>();
		  while ((st = br.readLine()) != null)
		  {
			  tmpstr=st.split(",");
			  for(int i=0;i<tmpstr.length;i++)
			  str.add(tmpstr[i]);
		  }
		  str=AlgorithmUtility.bubbleSortForString(str, str.size());
		  System.out.println("Enter key string for searching");
		  String key=AlgorithmUtility.getString();
           if(AlgorithmUtility.binarySearchForString(str, key, str.size()))
        	   System.out.println("String Found");
           else
        	   System.out.println("Not found");
	}
}
