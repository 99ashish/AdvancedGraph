package com.jda.Utility;
import java.util.Arrays;
public class CustomArrayList {
	 private int size=0;
	 private static final int intialCapacity=10;
	 public int[ ] arrayList;
	 public  int[] CreateArrayList()
	 {
		 return   new int[intialCapacity];
	 }
	 void add(int obj)
	 {
		 if(size==arrayList.length){
			 ensureCapacity();
		 }
		 arrayList[size++]=obj;
			 
	 }
	 void ensureCapacity()
	 {
		 int newSize=arrayList.length*2;
		 arrayList=Arrays.copyOf(arrayList,newSize);
	 }
  public int get(int index)
  {
	  if(index>=size || index<0)
		  throw new ArrayIndexOutOfBoundsException("Index :" + index +" is out of bound");
	  return arrayList[index];
		  
  }
  public void remove(int item)
  {
	  for(int i=0; i<size; i++)
	  {
		  if(item == arrayList[i])
		  {
			  for(int j=i ;j<size-1;j++)
				  arrayList[j]=arrayList[j+1];
			  size--;
			  break;
		  }
	  }
  }
  public boolean search(int item)
  {
	  for(int i=0; i<size; i++)
	  {
		  if(item == arrayList[i])
		  {
			 return true;
		  }
	  }
	  return false;
  }
  public boolean isEmpty()
  {
	  if(size==0)
		  return true;
	  return false;
  }
  public void append(int item)
  {
	  add(item);
  }
  public void insert(int pos,int item)
  {
	  for(int i=0;i<=size;i++)
	  {
		  if(i==pos)
		  {
			  for(int j=i;j<size;j++)
			  {
				   int tmp=arrayList[j];
				  arrayList[j]=item;
				  item=tmp;
			  }
			  add(item);
		  }
	  }
  }
  public int pop()
  {
	  return arrayList[size--];
  }
  public int pop(int pos)
  {
	 if(pos>=size)
		 throw new ArrayIndexOutOfBoundsException("Index:" + pos +"out of bound");
	 int item=arrayList[pos];
	 remove(item);
	 return item;  
  }
}
