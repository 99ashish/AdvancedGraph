package com.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Person implements Comparable<Person>{
	int age;
	String name;
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
            if(this.age>o.age)
            	return 1;
            else
            	return -1;
	}
}
class GenricSorting<T extends Comparable<T>> implements Runnable{
	List<T> dataList;
	 GenricSorting(List<T> val) {
	        dataList = val;

	}
	public GenricSorting() {
		// TODO Auto-generated constructor stub
	}
	public List<T> output()
	{
	   //System.out.println(dataList);
		List<T> data = new ArrayList<>(dataList);
	   return data;
	}
	synchronized public <T extends Number> Number additon(T a,T b)
	{
		return (Number)(a.doubleValue()+b.doubleValue());
	}
   synchronized public <T extends Comparable<T>>  void sorting(List<T> dataList2) throws InterruptedException
	 {
		System.out.println(Thread.currentThread().getName());
		 int j;
		for(int i=1;i<dataList2.size();i++)
		{	
			T key = dataList2.get(i);
			for (j=i-1;j>=0 && dataList2.get(j).compareTo(key) > 0;j--)
				dataList2.set(j+1,dataList2.get(j));
			dataList2.set(j+1, key);
		}
		//System.out.println(dataList2);
	 }
   synchronized static<T> void printData(T data)
   {
	   System.out.println(data);
   }
   synchronized static<T extends Comparable<T> > T min(List<T> list)
   {
	   T minimum = null;
	   try{
		  
	      minimum = list.get(0);
	      for (T t : list) { 
	    	  if(minimum.compareTo(t) > 0)
	    		  minimum =  t;	
		} 
	   }
	   catch(ArrayIndexOutOfBoundsException e)
	   {
		   System.out.println(e.getMessage());
	   }
	return minimum;
	   
   }

	@Override
	public void run() {
		try {
			sorting(dataList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output();
		
	}
}
public class GenericSort
{
	 	public static  void main(String[] args) throws InterruptedException 
	 	{   
			List<String> list1 = new ArrayList<>();
			 List<Person> emp =new ArrayList<>();
	           list1.add("Kama");
	           list1.add("mshish");
	           list1.add("Pandey");
	           @SuppressWarnings(value =  "unchecked" )
	           /*Scanner sc =new Scanner(System.in);
	           for(int i=0;i<3;i++)
	   		{
	   			Person pr=new Person();
	   			Integer k=sc.nextInt();
	   			sc.nextLine();
	   			pr.age=k;
	   			pr.name=sc.nextLine();
	   			emp.add(pr);	
	   		}
	   		
	   		GenricSorting<Person> task2 =new GenricSorting(emp);
	   	    Thread sortPersonList = new Thread(task2);
	   	    sortPersonList.setName("Person");
	        GenricSorting<String> task1 =new GenricSorting(list1);
	   		Thread sortString = new Thread(task1);
	   		sortString.setName("String");
	   	    sortString.start();
	   	    sortPersonList.start();
	   	    sortPersonList.join();
	   	    sortString.join();
	   	    System.out.println(list1);
	   	    System.out.println(emp.get(0).age + " " + emp.get(0).name);
	   	    */
	 		
	 		GenricSorting<Integer> task2 =new GenricSorting();
	 		task2.printData(2.0);
	 		task2.printData("ashish");
	 		System.out.println(task2.min(list1));
	 		
	           System.out.println(task2.additon(2.0, 3.001));
	}

	

}
