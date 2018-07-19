package com.jda.core;

import com.jda.utility.AlgorithmUtility;

public class BinarySearchTree 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the size of tree ");
		int size=AlgorithmUtility.getInteger();
		int[] totBst= new int[size+1];
		if(size<2)
		{
			System.out.println("Total bst is 1");
		}
		else
		{
			totBst[0]=1;
			totBst[1]=1;
			for(int i=2;i<=size;i++)
			{
				for(int j=0;j<i;j++)
				{
					totBst[i]+=(totBst[j]*totBst[i-j-1]);
				}
			}
			System.out.println("Total bst is "+ totBst[size]);
		}
	}
}
