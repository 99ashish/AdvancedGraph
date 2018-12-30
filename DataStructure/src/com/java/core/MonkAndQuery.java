package com.java.core;
import java.util.*;

public class MonkAndQuery {
	static long GCD(long a , long b)
    {
        if(b == 0)
          return a;
         return GCD(b , a%b);
       
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		int n = s.nextInt();
		List<Long> list = new ArrayList<>();
		Map<Long,Integer> mp = new HashMap<>();
		for(int i = 0; i < n; i++)
		{
			long x1 = s.nextLong();
			long y1 =s.nextLong();
			long x2 = s.nextLong();
			long y2 =s.nextLong();
			long laticPoint = GCD(Math.abs(x2-x1) , Math.abs(y2-y1)) + 1;
			list.add(laticPoint);
			if(mp.containsKey(laticPoint)) continue;
			else
			mp.put(laticPoint,i+1);
			
		}
		
		Collections.sort(list);
		int q = s.nextInt();
		
		while(q > 0)
		{
			q--;
			long key  = s.nextLong();
			long ans  = calculateMinLaticpoint(list, 0, list.size(),key);
			if(mp.containsKey(ans))
			System.out.println(mp.get(ans));
			else
				System.out.println("-1");
		}

	}

	private static long calculateMinLaticpoint(List<Long> list, int i, int j, long key) {
		int low  = i;
		int high = j;
		long idx =  Long.MAX_VALUE;
		while(low < high)
		{
			int mid = low + (high - low) /2;
			if(list.get(mid)>= key)
			{
				high = mid;
				if(idx > list.get(mid))
					idx = list.get(mid) ;
			}
			else
				low = mid + 1;
		}
		
		return idx;
	}

}
