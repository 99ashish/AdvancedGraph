package com.java.GenericUtility;

import java.util.ArrayList;
import java.util.List;

public class GenericSorting {

	synchronized public <T extends Comparable<T>>  List<T> insertionSorting(List<T> dataList) throws InterruptedException
	 {
		System.out.println(Thread.currentThread().getName());
		 int j;
		for(int i=1;i<dataList.size();i++)
		{	
			T key = dataList.get(i);
			for (j=i-1;j>=0 && dataList.get(j).compareTo(key) > 0;j--)
				dataList.set(j+1,dataList.get(j));
			dataList.set(j+1, key);
		}
		return dataList;
		
	 }
	
	synchronized public <T extends Comparable<T>>  List<T> selectionSorting(List<T> dataList) throws InterruptedException
	 {
		for(int i = 0; i < dataList.size(); i++)
		{
			int minimum = i;
			for(int j = i + 1; j < dataList.size(); j++)
			{
				if(dataList.get(minimum).compareTo(dataList.get(j))>0)
				{
					minimum = j;
				}
			}
			if(minimum != i)
			{
				T obj = dataList.get(i);
				dataList.set(i, dataList.get(minimum));
				dataList.set(minimum, obj);
			}
		}
		return dataList;
	 }
	synchronized public<T extends Comparable<T> > List<T> bubbleSort(List<T> dataList) throws InterruptedException
	{
		
		for(int i = 0; i < dataList.size()-1; i++)
		{
			for(int j = 0; j < dataList.size() - i-1; j++)
			{
				if(dataList.get(j).compareTo(dataList.get(j+1))  > 0)
				{
					T obj = dataList.get(j);
					dataList.set(j, dataList.get(j+1));
					dataList.set(j+1, obj);
				}
			}
		}
	return dataList;	
	}
	synchronized public<T extends Comparable<T> > void quickSort(List<T> dataList, int lowerBound, int upperBound) throws InterruptedException
	{
		if(lowerBound < upperBound)
		{
		int idx = partition(dataList, lowerBound, upperBound);
		quickSort(dataList, lowerBound, idx-1);
		quickSort(dataList, idx+1, upperBound);
		}
		
	}

	private <T extends Comparable<T>> int partition(List<T> dataList, int low, int size) {
		int pivot = size;
		int idx = low -1;
		for(int i = low ; i < size ;i++)
		{
			if(dataList.get(i).compareTo(dataList.get(pivot)) < 0)
					{
				     idx += 1;
				     T obj = dataList.get(idx);
				     dataList.set(idx, dataList.get(i));
				     dataList.set(i, obj);
					}
		}
		 idx += 1;
		 T obj = dataList.get(idx);
	     dataList.set(idx, dataList.get(pivot));
	     dataList.set(pivot, obj);
		return idx;
	}
	public<T extends Comparable<T> > void mergeSort(List<T> dataList, int lowerBound, int upperBound) throws InterruptedException
	{
		if(lowerBound < upperBound)
		{
			int mid = lowerBound + (upperBound-lowerBound)/2;
			mergeSort(dataList, lowerBound, mid);
			mergeSort(dataList, mid+1, upperBound);
			mergeTwoList(dataList, lowerBound, mid, upperBound );
		}
	}
	private <T extends Comparable<T>> void mergeTwoList(List<T> dataList, int lowerBound, int mid, int upperBound) 
	{
		int strt1 = lowerBound;
		int strt2 = mid+1;
		List<T> tmpDataList = new ArrayList<>();
		while(strt1 <= mid && strt2 <= upperBound)
		{
			if(dataList.get(strt1).compareTo(dataList.get(strt2)) > 0) 
			{
				tmpDataList.add(dataList.get(strt2));
                 strt2++;
			}
			else
			{
				tmpDataList.add(dataList.get(strt1));
				strt1++;
			}
		}
		while(strt1 <= mid)
		{
			tmpDataList.add(dataList.get(strt1));
			strt1++;
		}
		while(strt2 <= upperBound)
		{
			tmpDataList.add(dataList.get(strt2));
			strt2++;
		}
		for(int i = 0; i < tmpDataList.size(); i++)
		{
			dataList.set(lowerBound, tmpDataList.get(i));
			lowerBound++;
		}
			
	}
	synchronized public<T extends Comparable<T> > void heapSort(List<T> dataList, int size) throws InterruptedException
	{
		for(int i=size/2; i >= 0; i--)
		{
			heapify(dataList,size,i);

		}
		for(int i = size-1; i >= 0; i--)
		{
			swap(dataList, 0, i);
			size--;
			heapify(dataList,size,0);
		}
	}

	private <T extends Comparable<T> > void heapify(List<T> dataList, int size, int i) 
	{
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left < size && dataList.get(left).compareTo( dataList.get(largest)) > 0)
		{
			largest = left;
		}
		if(right < size && dataList.get(right).compareTo( dataList.get(largest)) > 0)
		{
			largest = right;
		}
		if(largest != i)
		{
			swap(dataList,largest,i);
			heapify(dataList,size,largest);
		}

	}

	private<T extends Comparable<T> > void swap(List<T> dataList, int largest, int i)
	{
		T tmpData = dataList.get(i);
		dataList.set(i,dataList.get(largest));
		dataList.set(largest,tmpData);
		
	}
}

