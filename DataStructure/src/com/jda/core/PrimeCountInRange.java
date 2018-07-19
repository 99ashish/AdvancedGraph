package com.jda.core;
import com.jda.utility.FunctionalUtility;
/**
 * Take a range of 0 ­ 1000 Numbers and find the Prime numbers in that range. Store
 *the prime numbers in a 2D Array, the first dimension represents the range 0­100,
 *100­200, and so on. While the second dimension represents the prime numbers in
 *that range.
 *
 */
public class PrimeCountInRange 
{
	public static void main(String[] args) 
	{	
	 int[][] primeCount= new int[10][100];
	 for(int i=0;i<10;i++)
	 {
		 int idx=0;
		 for(int j=i*100;j<=(i*100+100);j++)
		 {
			if(FunctionalUtility.primeChecker(j))
				primeCount[i][idx++]=j;
		 } 
			
	 }
	 for(int i=0;i<10;i++)
	 {
		 for(int j=0;j<100;j++)
		 {
			 if(primeCount[i][j]==0)
				 break;
		 System.out.print(primeCount[i][j] + " ");
		 }
		 System.out.println();
	 }
	}

}
