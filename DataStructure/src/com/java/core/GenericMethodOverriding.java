package com.java.core;
class A<T>
{
	T obj;
	A(T obj)
	{
	 this.obj = obj;	
	}
	T getObj()
	{
		return obj;
	}
}

class B<T> extends A<T>
{

	B(T obj) 
	{
		super(obj);
	}
	@Override
	T getObj()
	{
		System.out.println("Overriden method get called");
		return obj;
	}
	
}
public class GenericMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A<String> obj = new B("Ashish");
		System.out.println(obj.getObj());

	}

}
