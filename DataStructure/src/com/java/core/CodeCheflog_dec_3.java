package com.java.core;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
class pair{
	int first;
	int second;
}
class Graph{
	
	List<pair> inComingEdge = new ArrayList<>();
	List<pair> outGoingEdge = new ArrayList<>();
}
public class CodeCheflog_dec_3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int Node = s.nextInt();
		int Edges = s.nextInt();
		Graph []graph = new Graph[Node+1];
		for(int i = 0; i < Edges; i++)
		{
			int src, dest;
			src = s.nextInt();
			dest = s.nextInt();
			pair node = new pair();
			node.first = src;
			node.second = dest;
			if(graph[src] == null)
			{
				graph[src] = new Graph();
			}
			graph[src].outGoingEdge.add(node);
			if(graph[dest] == null)
				graph[dest] = new Graph();
			node.first = dest;
			node.second = src;
			graph[dest].inComingEdge.add(node);
		}
		for(int i = 1; i <= Node; i++)
		{
			for(int  j = 0; j<graph[i].outGoingEdge.size(); j++)
			{
				System.out.println(graph[i].outGoingEdge.get(j).first + " " + graph[i].outGoingEdge.get(j).second);
			}
			for(int  j = 0; j<graph[i].inComingEdge.size(); j++)
			{
				System.out.println(graph[i].inComingEdge.get(j).first + " " + graph[i].inComingEdge.get(j).second);
			}
		}

	}

}
