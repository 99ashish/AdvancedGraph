package com.java.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SgAgainstCrime {

	static boolean []visited = new boolean[1000001];
	static int []disc = new int[1000001];
	static int []low = new int[1000001];
	static int [] parent = new int[1000001];
	static Set<Integer> resultSet = new HashSet<>();
	public static PrintWriter pw = new PrintWriter(System.out);
	static BufferedReader br;

	static void init(int n)
	{
		for(int i = 0; i <= n; i++)
		{
			visited[i] = false;
			parent[i] = -1;
		}
	}
static class data{
		
		int node;
		int id;
		public data(int node, int id)
		    {
				this.node = node;
				this.id = id;
			}
	}
	private static void solve() throws FileNotFoundException {
		int n,m,q;
		FastReader sc = new FastReader();
		n = sc.I();
		m = sc.I();
		q = sc.I();
		Set<data> []graph = new HashSet[n+1];
         init(n);
		for(int i = 0; i < m; i++)
		{
			int src,dest,id;
			src = sc.I();
			dest = sc.I();
			id =sc.I();
			data data1 = new data(dest,id);
			data data2 = new data(src,id);
			if(graph[src] == null)
				graph[src] = new HashSet();
			if(graph[dest] == null)
				graph[dest] = new HashSet();
			graph[src].add(data1);
			graph[dest].add(data2);	
		}
		for(int i = 1; i <=n ;i++)
			if(!visited[i])
		      infactedCity(graph,i,0);
		for(int i = 0; i < q; i++)
		{
			int q1 = sc.I();
			if(resultSet.contains(q1))
				pw.println("YES");
			else
				pw.println("no");
		}
		 pw.close();

		
	}

	private static void infactedCity(Set<data>[] graph, int src,int time) {
    
           disc[src] = low[src] = time++;
           visited[src] = true;
           if(graph[src] != null )
           {
	           for(data subChild : graph[src])
	           {
	        	   if(!visited[subChild.node])
	        	   {
	        		   parent[subChild.node] = src;
	        		   infactedCity(graph, subChild.node, time);
	        		   low[src] = Math.min(low[src], low[subChild.node]);
	        		   if(low[subChild.node] > disc[src])
	        		   {
	        			   resultSet.add(subChild.id); 
	        		   }
	        	   }
	        	   else if( parent[src] != subChild.node ){
	        		   low[src] = Math.min(low[src], disc[subChild.node]);
	        	   }
	        		   
	           }
           }
		
	}
	

	public static void main(String[] args) {
		new Thread(null, new Runnable() {
            public void run() {
                try {
 
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, "1", 1 << 26).start();
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
