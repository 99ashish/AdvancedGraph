package com.java.core;
import java.util.*;
class container{
	int val;
	int divisor;
}
public class MyTest {
	static int []array = new int[1000001];
	static List<container> data = new ArrayList<>();
	static void calculateDivisor()
	{
	   for(int i = 1; i <= 1000000; i++)
	   {
		   for(int j = 1; i*j <= 1000000; j++)
			   array[i*j]++;
	   }
	   container con = new container();
	   con.divisor = 0;
	   con.val = 0;
	   data.add(con);
	   for(int i = 1; i <= 1000000; i++)
	   {
		   container con1 = new container();
		   con1.divisor = array[i];
		   con1.val = i;
		   if((data.get(i-1).divisor * data.get(i-1).val)  >= (con1.divisor * i))
		   {
			   con1.divisor = data.get(i-1).divisor;
			   con1.val = data.get(i-1).val;
		   }
		   data.add(con1);
	   }
	   
	}
	public static void main(String[] args) {
		int t;
		Scanner s = new Scanner(System.in);
		t = s.nextInt();
		calculateDivisor();
		while( t > 0)
		{
			t--;
			int n;
			n = s.nextInt();
			System.out.println((data.get(n).divisor * data.get(n).val)+ (n-data.get(n).val));
			
		}

	}

}
