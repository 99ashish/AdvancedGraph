package com.jda.core;
import com.jda.Utility.Stack;
import com.jda.utility.AlgorithmUtility;
import com.jda.utility.FunctionalUtility;
/**
 * Add the Prime Numbers that are Anagram in the Range of 0 ­ 1000 in a Stack using
 *the Linked List and Print the Anagrams in the Reverse Order.
 *
 */
public class PrimeAnagramLinkedlist 
{
	public static void main(String[] args) 
	{
		Stack stk=new Stack();
		for(int i=0;i<10;i++)
		 {
			 for(int j=i*100;j<(i*100+100);j++)
			 {
				if(FunctionalUtility.primeChecker(j))
				{
					for(int k=j+1;k<1000;k++)
					{
						if(FunctionalUtility.primeChecker(k)&&AlgorithmUtility.checkAnagram(String.valueOf(j), String.valueOf(k)))
						{
							stk.push(String.valueOf(j));
							stk.push(String.valueOf(k));
						}
					}
				}
			 }
		 }
  while(!stk.isEmpty())
  {
	  String ch1=stk.peek();
	  stk.pop();
	  String ch2=stk.peek();
	  stk.pop();
	  System.out.println(ch1+ " " + ch2);
  }

	}

}
