package com.jda.core;
import com.jda.utility.AlgorithmUtility;
/**
 * Takes a command­line argument N, asks you to think of a number
 * between 0 and N­1, where N = 2^n, and always guesses the answer with n
 * questions.
 * @author bridgelabz
 *
 */
public class FindYourNumber 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int num=Integer.valueOf(args[0]);
		int cnt=0,digit=num;
		int low=0,high=num;
		int mid=0;
		while(digit>0)
		{
			digit/=2;
			cnt++;
		}
		while(cnt>0)
		{
		mid=(low+high+1)/2;
		System.out.println("Enter true if no. is greater than the " + mid + " else false");
		String ans=AlgorithmUtility.getString();
		if(ans.equals("true"))
			low=mid;
		if(ans.equals("false"))
			high=mid;
		cnt--;
		}
		System.out.println("Your answer is "+ (low+high+1)/2);
	}
}
