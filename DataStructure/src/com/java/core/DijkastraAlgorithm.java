package com.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node
{
	int dest;
	int cost;
}
public class DijkastraAlgorithm {
	static long []distance = new long[10001];
	static void init()
	{
		for(int i = 0; i < 1001; i++)
			distance[i] = Long.MAX_VALUE;
	}
    static void computeSortestDistance(List<Node> []Graph,int src)
    {
    	Comparator<Node> idComparator = new Comparator<Node>(){
    		
    		@Override
    		public int compare(Node c1, Node c2) {
                return (int) (c1.cost - c2.cost);
            }
    	};
    	PriorityQueue<Node> pq = new PriorityQueue<>(11,idComparator); 
            distance[src] = 0;
            Node srcData = new Node();
            srcData.cost = 0;
            srcData.dest = src;
            pq.add(srcData);
            while(!pq.isEmpty())
            {
            	srcData = pq.poll();
	            if(Graph[srcData.dest] != null)
	            {   
	            	for(int i = 0; i < Graph[srcData.dest].size(); i++)
	            	{
	            		
            			
	            		if(distance[Graph[srcData.dest].get(i).dest] > distance[srcData.dest] + Graph[srcData.dest].get(i).cost)
	            		{  
	            			Node tmpData = new Node();
	            			//System.out.println(Graph[srcData.dest].get(i).dest +" "  + distance[srcData.dest] + " " +Graph[srcData.dest].get(i).cost);
	            			distance[Graph[srcData.dest].get(i).dest] = distance[srcData.dest] + Graph[srcData.dest].get(i).cost;
	                        tmpData.dest = Graph[srcData.dest].get(i).dest;
	                        tmpData.cost = (int) (distance[srcData.dest] + Graph[srcData.dest].get(i).cost);
	                        pq.add(tmpData);
	                        
	            		}
	            	}
	            		
	            }
            }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		init();
		Scanner s = new Scanner (System.in);
		n = s.nextInt();
		m = s.nextInt();
		List<Node> []Graph = new ArrayList[n+1];
		
		for(int i = 0; i < m; i++)
		{
			int src1,dest1,cost1;
			src1 = s.nextInt();
			dest1 = s.nextInt();
			cost1 = s.nextInt();
			Node data1 = new Node();
			Node data2 = new Node();
			if(Graph[src1] == null)
	    		Graph[src1] = new ArrayList<>();
	    	if(Graph[dest1] == null)
	    		Graph[dest1] = new ArrayList<>();
	    	
	    	data1.dest = dest1;
	    	data1.cost = cost1;
	    	data2.dest =src1;
	    	data2.cost = cost1;
	    	//System.out.println(data.dest + data.cost + src1);
	    	Graph[src1].add(data1);
	    	
	    	Graph[dest1].add(data2);
		}
		
		computeSortestDistance(Graph,1);
		for(int i = 2; i <= n; i++)
		{
			if(distance[i] == Long.MAX_VALUE)
				System.out.print("1000000000" + " ");
			else
				System.out.print(distance[i] + " ");
		}
		
		
	}

};
