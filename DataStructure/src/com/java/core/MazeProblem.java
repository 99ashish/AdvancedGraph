package com.java.core;

import java.util.Scanner;

public class MazeProblem {
	
	static int []xpath ={1,-1,0,0};
	static int []ypath ={0,0,1,-1};
	static boolean [][]visited = new boolean[11][11];
static boolean maze(int x, int y, int n, int m, int [][]array)
{
	if(x==n && y==m)
		return true;
	if(visited[x][y])
		return false;
	visited[x][y]= true;
	for(int i=0; i < 4; i++)
	{
		
		if((x+xpath[i]>0 && y+ypath[i]>0) && (x+xpath[i]<=n && y+ypath[i]<=m) && array[x+xpath[i]][y+ypath[i]] == 1)
		{
			
			if(maze(x+xpath[i], y+ypath[i], n, m, array))
				return true;
		}
	}
	return false;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("hi");
		//System.out.println(maze(1,1,n,m,array));
	}
}
