package com.java.core;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.jda.Utility.Queue;

class Node1
{
	int dest;
	long cost;
	Node1(int dest,long cost)
	{
	this.dest = dest;
	this.cost = cost;
	}
}
public class pq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Comparator<Node1> idComparator = new Comparator<Node1>(){
    		
    		@Override
    		public int compare(Node1 c1, Node1 c2) {
                return (int) (c1.cost - c2.cost);
            }
    	};
    	PriorityQueue<Node1> pq = new PriorityQueue<>(11,idComparator); 
    
    		pq.add(new Node1(2,3));
    		pq.add(new Node1(2,1));
    		pq.add(new Node1(2,-3));
    		while(!pq.isEmpty())
    		{
    			System.out.println(pq.poll().cost);
    		}
	}

}
