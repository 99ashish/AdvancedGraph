package com.jda.core;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class person implements Comparable<person>
{
	int age;
	String name;
	public void setAge(int age){this.age=age;}
	public void setName(String name){this.name=name;}
	public int getAge(){return this.age;}
	public String setAge(){return this.name;}
	@Override
	public int compareTo(person o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
}

public class GenericSort{
	public static <T extends Comparable<T>> int compare(T a,T b)
	{
		return a.compareTo(b);
	}
	public static<T extends Comparable<T>> void sort(List<T> arr)
	{
		for(int i=0;i<arr.size();i++)
		{
			T key=arr.get(i);
			int j;
			for( j=i-1; j>=0 && arr.get(j).compareTo(key)>0 ; j--)
				arr.set(j+1, arr.get(j));
			arr.set(j+1,key);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
	     List<person> emp=new ArrayList<>();
		for(int i=0;i<3;i++)
		{
			person pr=new person();
			Integer k=sc.nextInt();
			sc.nextLine();
			pr.age=k;
			pr.name=sc.nextLine();
			emp.add(pr);	
		}
		GenericSort.sort(emp);;
		for(int i=0;i<3;i++)
		{
            System.out.println(emp.get(i).age+ " "+ emp.get(i).name);
		}
    }
}