package com.java.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

public class PerfectXor {

	public static void main(String[] args) {
		
		new Thread(null,new Runnable(){

			@Override
			public void run() {
				try {
					solution();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

	},"1",1<<26).start();

}
	static boolean []visited;
	static long []disc;
	static long []low;
	static long[]weights;
	static int time=0;
	public static PrintWriter pw = new PrintWriter(System.out);
	static BufferedReader br;
    static Vector []graph;
    static long maxXor = 0;
    static long totwgt = 0;
	static void solution() throws FileNotFoundException{
		FastReader sc = new FastReader();
		long n =sc.L();
		long m = sc.L();
		visited = new boolean[(int) (n+1)];
		disc = new long[(int) (n+1)];
		low = new long[(int) (n+1)];
		weights = new long[(int) (n+1)];
		graph = new Vector[(int) (n+1)];
		for(int i = 1; i <= n; i++)
			{
			weights[i] = sc.L();
			graph[i] = new Vector();
			totwgt += weights[i]; 
			}
		for(int i = 0; i < m; i++)
		{
			long src = sc.L();
			long dest = sc.L();
			graph[(int) src].add(dest);
			graph[(int) dest].add(src);
		}
		biConnectedComponent(1,-1);	
		if(maxXor == 0) pw.println("-1"); else pw.print(maxXor);
		pw.close();
	}
	static void biConnectedComponent(long subChild2,long subChild22)
	{
	
		visited[(int) subChild2] =true;
		disc[(int) subChild2]=low[(int) subChild2]=time++;
		int child =0;
		long xor = 0;
		long tmpwgt = totwgt;
		boolean flg= false;
		for(int i = 0; i < graph[(int) subChild2].size(); i++)
		{
			long subChild = (long) graph[(int) subChild2].get(i);
			if(!visited[(int) subChild])
			{
				child++;
				biConnectedComponent(subChild, subChild2);
				
				if(low[(int) subChild] >= disc[(int) subChild2])
				{
					xor ^= weights[(int) subChild];
					tmpwgt -= weights[(int) subChild];
					flg = true;
				}
				else
					low[(int) subChild2] =Math.min(low[(int) subChild2], low[(int) subChild]);
					
			}
			if(subChild22 != subChild)
				low[(int) subChild2] = Math.min(low[(int) subChild2], disc[(int) subChild]);
		}
		xor ^= (tmpwgt-weights[(int) subChild2]);
		if((subChild22 == -1 && child>1) ||(flg && subChild22 !=-1))
			if(xor>maxXor)
			maxXor = xor;
	}
static class FastReader {
	    
	    StringTokenizer st;

	    public FastReader() throws FileNotFoundException {
	        //br=new BufferedReader(new FileReader("C:\\Users\\shree\\Downloads\\B-small-practice.in"));
	        br = new BufferedReader(new InputStreamReader(System.in));

	    }

	    String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }

	    int I() {
	        return Integer.parseInt(next());
	    }

	    long L() {
	        return Long.parseLong(next());
	    }

	    double D() {
	        return Double.parseDouble(next());
	    }

	    String nextLine() {
	        String str = "";
	        try {
	            str = br.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }

	    public boolean hasNext() throws IOException {
	        while (st == null || !st.hasMoreTokens()) {
	            String s = br.readLine();
	            if (s == null) {
	                return false;
	            }
	            st = new StringTokenizer(s);
	        }
	        return true;
	    }

	}

}
