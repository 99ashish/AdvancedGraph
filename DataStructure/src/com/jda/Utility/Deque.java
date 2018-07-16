package com.jda.Utility;

public class Deque {
	Deque next;
	Deque prev;
	char data;
	static int size=0;
	public static Deque frontEnd;
	public static Deque backEnd;
	public void addAtFront(char ch)
	{
		size++;
		Deque node= new Deque();
		node.data=ch;
		if(frontEnd==null)
		{
			frontEnd=node;
			backEnd=node;
			return;
		}
		node.prev=frontEnd;
		frontEnd.next=node;
		frontEnd=node;
	}
	public void addAtBack(char ch)
	{
		size++;
		Deque node= new Deque();
		node.data=ch;
		if(backEnd==null)
		{
			frontEnd=node;
			backEnd=node;
			return;
		}
		node.next=backEnd;
		backEnd.prev=node;
		backEnd=node;
	}
  public char removeFromFront()
  {
	  if(frontEnd==null)
		  return '0';
	  size--;
	  char ch=frontEnd.data;
	  frontEnd=frontEnd.prev;
	  return ch;
  }
  public char removeFromBack()
  {
	  if(backEnd==null)
		  return '0';
	  size--;
	  char ch=backEnd.data;
	  backEnd=backEnd.next;
	  return ch;
  }
  public boolean isEmpty()
  {
	  if(size==0)
		  return true;
	  return false;
  }
  public int sizeOfDeque()
  {
	  return size;
  }
}
