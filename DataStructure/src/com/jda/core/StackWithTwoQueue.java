package com.jda.core;
import com.jda.Utility.Queue;
import com.jda.utility.AlgorithmUtility;
public class StackWithTwoQueue
{
	public static void main(String[] args)
	{
		Queue q1= new Queue();
		Queue q2= new Queue();
		q1.push("2");
		q2.push("3");
		q2.push("5");
		System.out.println(q1.deque());
		System.out.println(q2.deque());
		System.out.println(q1.deque());
		System.out.println(q2.deque());
	}

}
