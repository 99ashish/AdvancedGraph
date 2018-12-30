package com.java.core;

import java.util.Scanner;

public class EculidianFuntion {

	 static long d, x, y;
	    static long power(long a, long b, long m)
	    {
	       long result = 1;
	       long x = a;
	       while(b > 0)
	       {
	           if(b%2 == 1)
	           result = (x * result)%m;
	         x = (x*x)%m;
	         b /= 2;
	       }
	       return result%m;
	    }
	    static void ecludian(long a , long b)
	    {
	        if(b == 0)
	        {
	            d = a;
	            x = 1;
	            y = 0;
	            
	        }
	        else
	        {
	        ecludian(b , a%b);
	        long tmp = x;
	        x = y;
	        y = tmp - (a/b)*y;
	        }
	    }
	    public static void main(String args[] ) throws Exception {
	        /* Sample code to perform I/O:
	         * Use either of these methods for input

	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String name = br.readLine();                // Reading input from STDIN
	        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

	        //Scanner
	        Scanner s = new Scanner(System.in);
	        String name = s.nextLine();                 // Reading input from STDIN
	        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

	        */

	        // Write your code here
	        Scanner s = new Scanner(System.in);
	        long a,b,c,m;
	        a = s.nextLong();
	        b = s.nextLong();
	        c = s.nextLong();
	        m = s.nextLong();
	        long ans1 = power(a,b,m);
	        ecludian(c,m);
	        long ans2 = (x%m + m)%m;
	        System.out.print((ans1*ans2)%m);

	    }

}
