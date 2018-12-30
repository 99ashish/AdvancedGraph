package com.java.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BsAlgo {

	static boolean []visited =new boolean[1000];
	static int []sortestDist = new int[1000];
    static void init()
    {
    	for(int i = 0; i < 1000; i++ )
    	{
    		sortestDist[i] = Integer.MAX_VALUE;
    		visited[i] = false;
    	}
    }
    static void bfs(List<Integer> []Graph,int node)
    {
    	visited[node] = true;
    	Queue<Integer> q =new LinkedList<>();
    	q.add(node);
    	sortestDist[node] = 0;
       while(!q.isEmpty())
       {
    	   int childNode = q.poll();
    		for(int i = 0; Graph[node] != null && i < Graph[node].size(); i++)
        	{
        		if(!visited[Graph[node].get(i)])
        		{
        			if(sortestDist[Graph[node].get(i)] > sortestDist[node] + 1)
        			{
        				sortestDist[Graph[node].get(i)] = sortestDist[node] + 1;
        			}
        			q.add(Graph[node].get(i));
        			visited[Graph[node].get(i)] =true;
        		}
        	}
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
		bfs(Graph,1);
		for(int i = 1; i <= 4; i++)
			System.out.println(sortestDist[i]);
		
		

	}


}
