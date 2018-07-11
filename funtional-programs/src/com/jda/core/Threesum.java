package com.jda.core;
import com.jda.utility.FunctionalUtility;
public class Threesum 
{
	public static void main(String[] args) 
	{
    System.out.println("Enter the size of array");
    int len= FunctionalUtility.getInteger();
    System.out.println("Enter " + len + " number into the array");
    int[] arr=new int[len];
    int cnt=0;
    for(int i = 0 ; i < len ; i++)
    {
    	arr[i]=FunctionalUtility.getInteger();
    	
    }
    System.out.println("Total triplets are given below");
   java.util.Arrays.sort(arr);
    for(int i = 0 ; i < len ; i++)
    {
    	for(int j = i+1; j <len ; j++)
    	{
    		for(int k=j+1; k<len ;k++)
    		{
    			if(arr[k]+arr[i]+arr[j]==0)
    			{
    				System.out.println(arr[i] + " " + arr[j] + " " +arr[k]);
    				cnt++;
    		}
    	}
    }
  }
    System.out.println("Total number of triplet is " + cnt);
 }
 }

