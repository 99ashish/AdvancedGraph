package com.jda.core;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import com.jda.utility.FunctionalUtility;
public class CoupanNumber 
{
	public static void main(String[] args) 
	{
		System.out.println("How many coupan you want ?");
		int num = FunctionalUtility.getInteger();
		Set< Long> set =new HashSet<>();
		int cnt=0, rcnt=0;
		while(true)
		{
			Random r =new Random();
			Long val = (long) (r.nextInt(Integer.MAX_VALUE) %Integer.MAX_VALUE);
			rcnt++;
			if( !set.contains(val) )
			{
				set.add(val);
				cnt++;
			}
			if(cnt==num)
				break;
		}
		System.out.println("Random Function called " + rcnt + " times");
		System.out.println("Following are the ticket number:\n "+set );
		/*Iterator<Long> it =set.iterator();
		System.out.println("Following are the ticket number");
		while(it.hasNext())
		{
			System.out.println(it.next() );
		}*/
	}
}
