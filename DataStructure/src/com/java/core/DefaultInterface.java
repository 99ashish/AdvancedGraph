package com.java.core;
interface A<T extends String>
{
	void getDate();
	default void print()
	{
		System.out.println("good moring");
	}
	static void print1()
	{
		System.out.println("good moring");
	
	}
}
interface B<T extends String >
{
	void getDate();
	default void print()
	{
		System.out.println("good Night");
	}
	static void print1()
	{
		System.out.println("good Night");
	
	}
}
class C<T extends String> implements  A<T>,B<T>
{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Cio ");
	}

	@Override
	public void getDate() {
		// TODO Auto-generated method stub
		
	}
	
}
public class DefaultInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C<String> obj = new C<>();
		

	}

}
