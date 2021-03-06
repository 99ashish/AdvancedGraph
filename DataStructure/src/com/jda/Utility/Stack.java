package com.jda.Utility;
/**
 * Implementation of stack which is worked on the basis of
 * LIFO. Insertion is done from top side and deletion is done for
 * top. It's implementation is similar to linked list.
 *
 */
public class Stack<T> {
	T data;
	Stack next;
	Stack prev;
	static int size =0;
	public static Stack top;
	public void push(T val)
	{
		size++;
		if (top == null) {
			Stack node = new Stack();
			node.data = val;
			top = node;
		} else {
			Stack node = new Stack();
			node.data = val;
			top.next = node;
			node.prev=top;
			top=node;
		}
	}
	public T peek()
	{
		return (T)top.data;
	}
	public void pop()
	{
		size--;
		top=top.prev;
	}
	public boolean isEmpty()
	{
		if(size>0)
			return false;
		return true;
	}
public int sizeOfStack()
{
	return size;
}
}
