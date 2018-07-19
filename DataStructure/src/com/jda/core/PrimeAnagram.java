package com.jda.core;
import com.jda.utility.AlgorithmUtility;
import com.jda.utility.FunctionalUtility;
/**
 * Extend the Prime Number Program and store only the numbers in that range that are
 *Anagrams. For e.g. 17 and 71 are both Prime and Anagrams in the 0 to 1000 range.
 *
 */
public class PrimeAnagram 
{
	public static void main(String[] args) 
	{
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
							System.out.println(j+ " " +k);
						}
					}
				}
			 }
		 }

	}

}
