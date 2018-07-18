package com.jda.Utility;
import java.util.HashSet;
import java.util.Set;
/**
 * Implementation of queue which is worked on the basis of
 * FIFO. Insertion is done from front side and deletion is done for
 * back end.
 * @author bridgelabz
 *
 */
public class Queue {
	Queue link;
	String name;
	int amount=20000;
	static int size = 0;
	public static Queue front;
	public static Queue back;
	public void push(String val) 
	{
		Queue node = new Queue();
		node.name = val;
		if (size==0) {
			front = node;
			back = node;
		} else {
			front.link = node;
			front = node;
		}
		size++;
	}
public int getBal()
	{
		return back.amount;
	}
public void withDraw(int amnt)
{
	if(amnt>back.amount)
	{
		System.out.println("insufficient Balance");
		return;
	}
	back.amount-=amnt;
}
public void deposite(int amnt)
{
	back.amount+=amnt;
}
	public String  deque() {
		if(back==null)
			return null;
		String ch=back.name;
		back = back.link;
		size--;
		return ch;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	public int sizeOfQueue() {
		return size;
	}

}
