package com.jda.Utility;
import java.io.FileWriter;
import java.io.IOException;
/**
 *Read the Text from a file, split it into words and arrange it as Linked List.
 *Take a user input to search a Word in the List. If the Word is not found then add it
 *to the list, and if it found then remove the word from the List. In the end save the
 *list into a file.
 *Create a Unordered Linked List. The Basic Building Block is the Node
 *Object. Each node object must hold at least two pieces of information. One ref to
 *the data field and second the ref to the next node object.
 *
 */
public class CustomLinkedList<T>
{
	static int size = 0;
	T data;
	CustomLinkedList link;
	public static CustomLinkedList head;
	public static CustomLinkedList end;
	public void add(T str)
	{
		size++;
		if (head == null) 
		{
			CustomLinkedList node = new CustomLinkedList();
			node.data = str;
			head = node;
			end = node;
		} 
		else
		{
			CustomLinkedList node = new CustomLinkedList();
			node.data = str;
			end.link = node;
			end = node;
		}
	}
	public void remove(T str) 
	{
		CustomLinkedList list = head;
		CustomLinkedList prev = list;
		if (head.data == str)
		{
			head = head.link;
			size--;
		}
		else 
		{
			while (list != null) 
			{
				if (list.data == str) 
				{
					prev.link = list.link;
					if(list==end)
						end=prev;
					size--;
				}
				prev=list;
				list=list.link;
			}
		}
	}
	public void writeToFile(String fileName) throws IOException
	{
		 FileWriter fw=new FileWriter(fileName);    
		 CustomLinkedList list = head;
		while (list != null) 
			{	
			System.out.print(list.data+ " ");
           fw.write(list.data +","); 
           list = list.link;
			}
			fw.close();
	}
	public int search(T str)
	{
		if(head==null)
			return -1;
		if(str.equals(head.data))
			return 0;
		CustomLinkedList list=head;
		int cnt=0;
		while(list!=null)
		{
			cnt++;
			if(str.equals(list.data ))
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
public void append(T str)
{
	add(str);
}
public int index(T str)
{
	if(head.data==str)
		return 0;
	int cnt=0;
	CustomLinkedList list=head;
	while(list!=null)
	{
		cnt++;
		if(list.data==str)
			return cnt;
		list=list.link;	
	}	
	return -1;
}
public void insert(int pos, T str)
{
	if(pos==0)
	{
		CustomLinkedList tmp= new CustomLinkedList();
		tmp.data=str;
		tmp.link=head;
		head=tmp;
		return;
	}
	int cnt=0;
	CustomLinkedList list=head;
	CustomLinkedList prev=list;
	while(list!=null)
	{
		cnt++;
		if(cnt==pos)
		{
			CustomLinkedList tmp= new CustomLinkedList();
			tmp.data=str;
			tmp.link=head;
			head=tmp;
			return;
		}
		prev=list;
		list=list.link;
	}
	add(str);
}
public T pop()
{
	if(head==null)
	{
		return null;
	}
	CustomLinkedList list=head;
	CustomLinkedList prev=list;
	while(list.link!=null)
	{
		prev=list;
		list=list.link;
	}
	T elmnt=(T) prev.data;
	size--;
	if(list==head)
	{
		head=null;
		return elmnt;
	}
	end=prev;
	prev.link=null;
	return elmnt;
}
public T pop(int pos)
{
	if(head==null)
		return null;
	if(pos==0)
	{
		size--;
	  T str=(T) head.data;
	  head=head.link;
	  return str;
	}
	CustomLinkedList list=head;
	CustomLinkedList prev=head;
	int cnt=0;
	while(list!=null)
	{
		cnt++;
		if(cnt==pos)
		{
			size--;
			 T str=(T)list.data;
			  prev.link=list.link;
			  return str;
		}
		prev=list;
		list=list.link;
	}
	T elmnt=(T)prev.data;
	if(list==end)
	{
	end=prev;
	prev.link=null;
	}
	return elmnt;
}
public void printList() {
		CustomLinkedList list = head;
		while (list != null) {
			System.out.println(list.data);
			list = list.link;
		}
	}
}
