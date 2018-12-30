package com.java.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class DataPoint{
	int idx;
	int val;	
}
class sorting implements Comparator<DataPoint>
{

	@Override
	public int compare(DataPoint o1, DataPoint o2) {
		if(o2.val ==  o1.val)
		   return o2.idx-o1.idx;
		
		return o2.val - o1.val;
		
	}
	
}
public class LearningGraph {
	
	public static void main(String[] args) {
		int n,m,k;
	Scanner s = new	Scanner(System.in);
	n = s.nextInt();
	m = s.nextInt();
	k = s.nextInt();
	DataPoint []val = new DataPoint[m];
	for(int i = 0; i < n; i++)
	{
		DataPoint data = new DataPoint();
		data.idx = i+1;
		data.val = s.nextInt();
		val[i] = data;
	}
    List<DataPoint> []Graph = new ArrayList[n];
    for(int i = 0; i < m; i++)
    {
    	int src = s.nextInt();
    	int dest = s.nextInt();
    	if(Graph[src-1] == null)
    		Graph[src-1] = new ArrayList<>();
    	if(Graph[dest-1] == null)
    		Graph[dest-1] = new ArrayList<>();
    	Graph[src-1].add(val[dest-1]);
    	Graph[dest-1].add(val[src-1]);	
    }
    sorting s1 = new sorting();
    for(int i = 0; i < n; i++)
    Collections.sort(Graph[i], s1);

    for(int i = 0; i < n; i++)
    {
    	for(int j = 0  ; j< Graph[i].size();j++)
    	{
    	System.out.print(Graph[i].get(j).idx + " "+Graph[i].get(j).val);
    	}
    System.out.println();
	}
    for(int i = 0; i < n; i++)
    	System.out.print(Graph[i].get(n-k-1).idx + " ");
	}

}
