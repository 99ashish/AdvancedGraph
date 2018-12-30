package com.java.core;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class DfsAlgo {
	static boolean []visited =new boolean[1000];
    static void init()
    {
    	for(int i = 0; i < 1000; i++ )
    		visited[i] = false;
    }
    static void dfs(List<Integer> []Graph,int node)
    {
    	visited[node] = true;
       	for(int i = 0; Graph[node] != null && i < Graph[node].size(); i++)
    	{
    		if(!visited[Graph[node].get(i)])
    		dfs(Graph,Graph[node].get(i));
    	}
    }
	public static void main(String[] args) {
		init();
		int vertex,edges;
		Scanner sc = new Scanner(System.in);
		vertex  = sc.nextInt();
		edges = sc. nextInt();
		List<Integer> []Graph = new ArrayList[vertex+1];
		for(int i = 0; i < edges; i++)
		{
			int src,dest;
			src = sc.nextInt();
			dest = sc.nextInt();
			if(Graph[src] == null)
				Graph[src] = new ArrayList<>();
			Graph[src].add(dest);
		}
		int totlatIceLand = 0;
		for(int i = 1; i <= vertex; i++)
		{
			if(!visited[i])
			{
				dfs(Graph,i);
				totlatIceLand++;
			}
		}
		System.out.println(totlatIceLand);
		
		

	}

}
