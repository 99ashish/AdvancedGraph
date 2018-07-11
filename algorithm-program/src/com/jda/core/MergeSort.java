package com.jda.core;

import com.jda.utility.AlgorithmUtility;
/**
 * We have an integer array of fixed size.
 * Now we have to sort the array with the help of merge sort algorithm. 
 * Merge function will split the original array into two array and the merge it.
 * First array contains the value from index low to mid, Second array contains
 * the value from mid+1 to high.
 * @author bridgelabz
 *
 */
public class MergeSort 
{
	public static int[] merge(int[] arr,int low,int mid,int high)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		int[] tmparr1=new int[n1];
		int[] tmparr2 = new int[n2];
		for(int i=0;i<n1;i++)
			tmparr1[i]=arr[i+low];
		for(int i=0;i<n2;i++)
			tmparr2[i]=arr[i+mid+1];
		int i=0,j=0,k=low;
		while(i<n1 && j<n2 )
		{
			if(tmparr1[i]>tmparr2[j])
			{
				arr[k++]=tmparr2[j++];
			}
			else
			{
				arr[k++]=tmparr1[i++];
			}
		}
		while(i<n1)
		{
			arr[k++]=tmparr1[i++];
		}
		while(j<n2)
		{
			arr[k++]=tmparr2[j++];
		}
		return arr;
	}
	public static void mergeSort(int[] arr, int low ,int high)
	{
		if(low>=high)
			return ;
		int mid=low+(high-low)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the size of the array");
		int num=AlgorithmUtility.getInteger();
		int[] arr =new int[num];
		System.out.println("Enter the "+ num + " into the array");
		for(int i=0;i<num;i++)
			arr[i]=AlgorithmUtility.getInteger();
		mergeSort(arr,0,num-1);
		for(int i=0;i<num;i++)
			System.out.print(arr[i] + ", ");
	}
}
