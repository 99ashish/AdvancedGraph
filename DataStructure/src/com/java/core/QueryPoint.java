package com.java.core;
import java.util.*;
public class QueryPoint{
	 static int []isAvailable = new int[1000005];
	 static int []isPrime = new int[1000005];
	private static void init(){
		for(int i = 2; i < 1000005; i++)
		{
			if(isPrime[i] == 0)
			{
				for(int j = 1; j < 1000005; j+=i)
					isPrime[j] = i;
			}
		}
	}
	static boolean isPossible(int x)
	{
		if(x < 4)
			return false;
		List<Integer> prime = new ArrayList<>();
		int tmp = x;
	    while(x > 1)
	    {
	    	int y = isPrime[x];
	    	prime.add(y);
	    	while(x>0 && (x%y==0) )
	    		x/=y;
	    }
	    boolean ans = false;
	    for(int i = 0; i < prime.size(); i++)
	    {
	    	for(int j = 0; j < prime.size(); j++ )
	    	{
	    		if((tmp%(prime.get(i)*prime.get(j))) == 0)
	    		{
	    			int temp = tmp/(prime.get(i)*prime.get(j));
	    			if(temp == 1 || isAvailable[temp] == 1)
	    				return true;
	    		}
	    			
	    	}
	    }
		return false;
	}
	public static void main(String[] args) {
		init();
		int n,q;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		q = s.nextInt();
		int []array = new int[n];
		for(int i = 0; i < n; i++)
		{
			array[i] = s.nextInt();
			isAvailable[array[i]] = 1;
		}
		for(int i = 2; i < 1000005; i++)
		{
			if(isAvailable[i] >0)
			{
				for (int j = i; j< 1000005; j*=i)
					isAvailable[j] = 1;
			}
		}
		while(q > 0)
		{
			q--;
			int val = s.nextInt();
			if(isPossible(val))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}