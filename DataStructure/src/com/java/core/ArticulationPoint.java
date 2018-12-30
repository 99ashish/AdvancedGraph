package com.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ArticulationPoint {
 static int []parent= new int[11];
 static boolean []visited = new boolean[11];
 static int []disc = new int[11];
 static int []low = new int[11];
 static List<Integer> AP = new ArrayList<>();
 static List<Integer> []bridge = new ArrayList[101];
 static void init()
 {
	 for(int i = 0; i <= 10; i++)
	 {
		 parent[i] = -1;
		 visited[i] = false;
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			if(Graph[dest] == null)
				Graph[dest] = new ArrayList<>();
			Graph[dest].add(src);
				
		}
		totArticulationPointAndBridge(Graph,1,0);
		Collections.sort(AP);
		if(AP.size() > 0)
			System.out.println(AP.size());
		for(int i = 0; i < AP.size(); i++)
			System.out.println(AP.get(i) + " ");
		int cnt = 0;
		for(int i = 0; i <= vertex; i++)
			if(bridge[i] != null)
			cnt+=bridge[i].size();
		System.out.println(cnt);
		bridge[0].add(-1);
		for(int i = 0; i <= vertex; i++ )
			if(bridge[i] != null)
			Collections.sort(bridge[i]);
		for(int i = 0; i <= vertex; i++)
		{
			if(bridge[i] != null)
			{
				for(int j = 0; j < bridge[i].size(); j++)
					System.out.println(i + " " + bridge[i].get(j));
			}
		}

	}
	private static void totArticulationPointAndBridge(List<Integer>[] Graph, int src, int time) {
		visited[src]  = true;
		disc[src] = low[src] = time++;
		int child = 0;
		if(Graph[src] != null)
		{
			for(int i = 0; i<Graph[src].size();i++)
			{
				int child1 = Graph[src].get(i);
				if(!visited[child1])
				{
					child++;
					parent[child1] = src;
					totArticulationPointAndBridge(Graph, child1, time);
					low[src] = Math.min(low[src], low[child1]);
					if(parent[src] == -1 && child > 1)
						AP.add(src);
					if(parent[src] != -1 && disc[src] <= low[child1])
						AP.add(src);
					if(disc[src] < low[child1])
					{
						
						if(bridge[child1] == null)
						if(src<child1)
						{
							if(bridge[src] == null)
								bridge[src] = new ArrayList<>();
						         bridge[src].add(child1);
						
						}
						else 
							{
							if(bridge[child1] == null)
								bridge[child1] = new ArrayList<>();
							bridge[child1].add(src);
							}
					}
				}
				else if(child1 != parent[src])
				{
					low[src] = Math.min(low[src], disc[child1]);
				}
			}
		}
		
	}

}
