package com.jda.Utility;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Create a Ordered Linked List having Numbers in ascending order.
 * The List of Numbers to a File.
 * @author bridgelabz
 *
 */
public class OrderedLinkedList {
	static int size = 0;
	int data;
	OrderedLinkedList link;
	public static OrderedLinkedList head;
	public static OrderedLinkedList end;
	@SuppressWarnings("null")
	public int pop(int pos)
	{
		if(head==null)
			return (Integer) null;
		if(pos==0)
		{
			size--;
		  int str=head.data;
		  head=head.link;
		  return str;
		}
		OrderedLinkedList list=head;
		OrderedLinkedList prev=head;
		int cnt=0;
		while(list!=null)
		{
			cnt++;
			if(cnt==pos)
			{
				size--;
				  int str=list.data;
				  prev.link=list.link;
				  return str;
			}
			prev=list;
			list=list.link;
		}
		int elmnt=prev.data;
		if(list==end)
		{
		end=prev;
		prev.link=null;
		}
		return elmnt;
	}
	public int search(int val)
	{
		if(head==null)
			return -1;
		if(val==head.data)
			return 0;
		OrderedLinkedList list=head;
		int cnt=0;
		while(list!=null)
		{
			cnt++;
			if(val==list.data )
				return cnt;
			list=list.link;
		}
		return -1;
	}
public boolean isEmpty()
{
	if(size==0)
		return true;
	return false;
}
public int sizeOfLinkedList()
{
	return size;
}
public void append(int val)
{
	add(val);
}
public void add(int val)
{
	size++;
	if (head == null) 
	{
		OrderedLinkedList node = new OrderedLinkedList();
		node.data = val;
		head = node;
		end = node;
	}
	else
	{	
		OrderedLinkedList list=head;
		OrderedLinkedList prev=head;	
		while(list!=null)
		{
			if(val<list.data)
				break;
			prev=list;
			list=list.link;
		}
		if(list==head)
		{
			addFront(list, val);
			return;
		}
		addMidAndLast(prev,list,val);		
	}
}
private void addFront(OrderedLinkedList list,int val)
{
	OrderedLinkedList node = new OrderedLinkedList();
	node.data=val;
	node.link=head;
	head=node;
}
private void addMidAndLast(OrderedLinkedList prev, OrderedLinkedList list, int val)
{
	OrderedLinkedList node = new OrderedLinkedList();
	node.data=val;
	prev.link=node;
	node.link=list;
	if(list==null)
		end=node;
}
public void writeToFile(String fileName) throws IOException
{
	 FileWriter fw=new FileWriter(fileName);    
	 OrderedLinkedList list = head;
		while (list != null) {	
     fw.write(list.data +","); 
     list = list.link;
		}
		fw.close();
}
}
