package com.java.core;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.Scanner;


import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class queueData{
	int scl;
	int rolNum;
}
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        s.nextLine();
        LinkedList<queueData> []q = new LinkedList[4];
        LinkedList<Integer> stk =new LinkedList<>();
        while(Q > 0)
        {
        	Q--;
        	String str = s.nextLine();
        	String []str1 = str.split(" ");
        	if(str1[0].equals("E") )
        	{
        		int idx1 = Integer.valueOf(str1[1]);
        		int idx2 = Integer.valueOf(str1[2]);
        		queueData data = new queueData();
        		data.scl = idx1;
        		data.rolNum = idx2;
        		if(q[idx1-1] == null)
        			q[idx1-1] = new LinkedList<queueData>();
        		q[idx1-1].add(data);
        		if( !stk.contains(idx1-1) )
        		stk.add(idx1-1);
        	}
        	else
        	{
        	    if(stk.size() > 0)
        	    {
        		int idx1 = stk.getFirst();
        		if(q[idx1].size() > 0)
        		{
        		queueData data = q[idx1].remove();
        		if(q[idx1].size() == 0)
        			stk.removeFirst();
        		System.out.println(data.scl + " " +data.rolNum);
        		}
        	    } 
        	    
        	}
        	System.out.println((-2+3)%3);
        }

    }
}
