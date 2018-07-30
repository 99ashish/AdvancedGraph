package com.jda.core;
import com.jda.Utility.Queue;
import com.jda.utility.AlgorithmUtility;
import com.jda.utility.FunctionalUtility;
/**
 * Add the Prime Numbers that are Anagram in the Range of 0 ­ 1000 in a Queue using
 *the Linked List and Print the Anagrams from the Queue.
 *
 */
public class PrimeAnagramQueue 
{
	public static void main(String[] args) 
	{
		Queue stk=new Queue();
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
	  String ch1=(String) stk.deque();
	  String ch2=(String) stk.deque();
	  System.out.println(ch1+ " " + ch2);
  }


	}

}
