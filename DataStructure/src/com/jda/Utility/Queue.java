package com.jda.Utility;
/**
 * Implementation of queue which is worked on the basis of
 * FIFO. Insertion is done from front side and deletion is done for
 * back end.
 *
 */
public class Queue<T> {
	Queue link;
	T name;
	int amount=20000;
	static int size = 0;
	public static Queue front;
	public static Queue back;
	public void push(T val) 
	{
		Queue<T> node = new Queue<>();
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
	public T  deque() {
		if(back==null)
			return null;
		T ch= (T) back.name;
		back = back.link;
		size--;
		return (T)ch;
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
