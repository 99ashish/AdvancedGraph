package com.java.core;

interface FunctionalInterface<R,T>{
	R func(T v);
}
class Ashish<T>{
	T obj;
	Ashish(T val)
	{
		obj = val;
	}	
	T getObj(){
		return obj;
	}
}
class Pandey<T>{
	T obj;
	Pandey(T val)
	{
		obj = val;
	}
	T getObj(){
		return obj;
	}
}

public class CreationofObjWithLambdaExp {
	static <R,T> R myFactory(FunctionalInterface<R,T> factory, T val){
		return factory.func(val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalInterface<Ashish<Integer>,Integer> factory= Ashish<Integer>::new;
		Ashish<Integer> data = myFactory(factory, new Integer(20));
		System.out.println(data.getObj());
		FunctionalInterface<Pandey<String>,String> factory1= Pandey<String>::new;
		Pandey<String> data1 = myFactory(factory1, new String("Pandu"));
		System.out.println(data1.getObj());
		 if (data instanceof Ashish) 
			System.out.println("Type of data is of Ashish");
			
		}
		 

	}


