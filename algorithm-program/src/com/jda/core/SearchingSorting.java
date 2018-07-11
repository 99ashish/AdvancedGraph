package com.jda.core;
import java.util.ArrayList;
import java.util.List;

import com.jda.utility.AlgorithmUtility;
public class SearchingSorting 
{
      public static void main(String[] arg)
      {
    	  System.out.println("Enter the size of the array");
    	  int lenOfArray=AlgorithmUtility.getInteger();
    	  List<Integer> arr =new ArrayList<>();
    	  System.out.println("Enter the "+ lenOfArray +" element into the array");
    	  for(int i=0;i<lenOfArray;i++)
    	  {
    		  arr.add(AlgorithmUtility.getInteger());
    	  }
    	  System.out.println("Sorted data using bubble sort:");
    	  List<Integer> list=AlgorithmUtility.bubbleSortForInteger(arr, arr.size());
    	  System.out.println(list);
    	  System.out.println("Sorted data using insertion sort:");
    	   arr=AlgorithmUtility.insertionSortForInterger(arr, arr.size());
    	  System.out.println(arr);
    	  System.out.println("Enter the serching element");
    	  int key=AlgorithmUtility.getInteger();
    	  if(AlgorithmUtility.binarySearchForInteger(arr, key, arr.size()))
    		  System.out.println("Number found");
    	  else
    		  System.out.println("Number not Found");
    	  
      }
}
