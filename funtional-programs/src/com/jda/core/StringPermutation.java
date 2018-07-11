package com.jda.core;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.jda.utility.FunctionalUtility;
/**
 * String permutation is a standard problem for getting all the possible combination 
 * of a given string.
 * @author bridgelabz
 *
 */
public class StringPermutation
{
	static ArrayList<String> recursiveStirng = new ArrayList<String>();
	  public static char[] appendString(String str,int idx, char ch)
	    {
		  /**
		   * Append a string with a new character, if appending position is 0then
		   * simply add to the initial position or if the last position then add last to 
		   * the string. if appending position is between 0 to length then simply append
		   * the string at that position.
		   * 
		   */
	        int len=str.length();
	        char[] tmpstr =new char[len+1]; 
			int l=0;
	        for(int i=0;i<=len;i++)
	        {
	            if(i==idx)
	            tmpstr[i]=ch;
	            else
	            tmpstr[i]=str.charAt(l++);   
	        }
	        return tmpstr;
	    }  
	public static Set<String> IterativePermutation(String str,int len)
	   {
		/**
		 * Iterative permutation, the logic behind it to firstly add first element of the string to a
		 * set and then add second character to the all possible position of the set string
		 * and store all the newly string to the set and perform the same operation n times(length of the string)
		 * and we get all permutation of the string.
		 */
		   Set<String> localSet1= new HashSet<>();
		   Set<String> localSet2= new HashSet<>();
		   localSet1.add(String.valueOf(str.charAt(0)));
		   boolean turn= false;
		   for(int k=1; k<len;k++)
		   {
			if(!turn)   
			{
		    Iterator it=localSet1.iterator();
		   while(it.hasNext())
		   {
			 String ch=(String)it.next();
			 localSet1.remove(ch);
			 it=localSet1.iterator();
			 for(int j=0;j<k;j++)
	         {
	             String tmp=ch;
				 tmp=String.valueOf(appendString(ch,j,str.charAt(k)));
				 localSet2.add(tmp);
			 }
			     String tmp=ch;
				 tmp=String.valueOf(appendString(ch,k,str.charAt(k)));
				 localSet2.add(tmp);
		   }
		   localSet1.clear();
		   turn=true;
		  }
		  else
		  {
		   Iterator itr=localSet2.iterator();
		   //System.out.println(localSet2.size());
		   while(itr.hasNext())
		   {
			 String ch=(String)itr.next();
			 localSet2.remove(ch);
			 itr=localSet2.iterator();
			 for(int j=0;j<k;j++)
	         {
	             String tmp=ch;
				 tmp=String.valueOf(appendString(ch,j,str.charAt(k)));
				 localSet1.add(tmp);
			 }
			     String tmp=ch;
				 tmp=String.valueOf(appendString(ch,k,str.charAt(k)));
				 localSet1.add(tmp);
		   }
	       turn=false;
	        localSet2.clear();
		   }
		   }
		   if(localSet1.size()>0)
		  return localSet1;
	  return localSet2;   
	   } 
	public static String swap(String str, int strtPos ,int endPos)
	{
		/**
		 * Standard algorithm of string to get all permutation
		 * of the string.
		 */
	char[] ch =str.toCharArray();
     char tmp=ch[strtPos];
	 ch[strtPos]=ch[endPos];
	 ch[endPos]=tmp;
	 return String.valueOf(ch);
	}
	public static void recursivePermutaion(String tmpString , int strt, int len)
	{
	if(strt==len)
	{
		recursiveStirng.add(tmpString);
		return;
	}
	for(int i=strt;i<len;i++)
	{
	tmpString = swap(tmpString,i,strt);
	recursivePermutaion(tmpString,strt+1,len);
	tmpString= swap(tmpString,i,strt);
	}
	}
	public static ArrayList<String> recursive(String tmpString , int strt, int len)
	{
	  recursivePermutaion(tmpString , strt , len);	
	  return recursiveStirng;
	}
	public static void main(String[] args)
	{
	 System.out.println("Enter the String ");
	 String originalString = FunctionalUtility.getString();
	 int len = originalString.length();
	 recursive(originalString , 0 , len);
	 System.out.println("Permutaion string of "+ originalString + " is " + recursiveStirng.size());
	System.out.println(recursiveStirng);
	 System.out.println("String permutation using iteration");
	 Set<String> iterative=IterativePermutation(originalString,  len);
	 System.out.println("Permutaion string of "+ iterative + " of " + iterative.size() +" size");
	 Iterator it=recursiveStirng.iterator();
	 boolean flag=true;
	 for(int i=0;i<iterative.size();i++)
	 {
		 if(it.hasNext())
		 {
		 String ch=(String)it.next();
		 if(!iterative.contains(ch))
		 {
			 flag=false;
		 }
		 }	 
	 }
	 if(flag)
		 System.out.println("Both are same");
	 else
		 System.out.println("Both are different");
	}
}