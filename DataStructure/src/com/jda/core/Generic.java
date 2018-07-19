package com.jda.core;
import com.jda.utility.AlgorithmUtility;
public class Generic<T> {
public <T extends Comparable<T>> int sortArray(T[] arr)
{
	int cnt=0;
	int len=arr.length;
  for(int i=0;i<len;i++)
  {
	  int greatest=i;
	  for(int j=i+1;j<len;j++)
	  {
		  if(arr[greatest].compareTo(arr[j])>0)
		  {
			  greatest=j;
		  }
	  }
	  if(greatest!=i)
		  cnt++;
  }
  return cnt;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=AlgorithmUtility.getInteger();
		Generic  g = new Generic();
		Integer[] arr=new Integer[size];
		for(int i=0;i<size;i++)
			arr[i]=AlgorithmUtility.getInteger();
    System.out.println(g.sortArray(arr));
	}
}
