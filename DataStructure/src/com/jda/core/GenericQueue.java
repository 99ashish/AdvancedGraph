package com.jda.core;
import com.jda.Utility.*;
class Person<T>{
	T age;
	T name;
}
public class GenericQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomLinkedList que1=new CustomLinkedList();
		CustomLinkedList.head=null;
		Person pr=new Person();
		pr.name="Ashish";
		pr.age="23";
		que1.add(pr);
		Person pr1=new Person();
		pr1.name="p1ndey";
		pr1.age="28";
		que1.add(pr1);
		pr1=(Person) que1.pop(3);
		System.out.println(pr1.name);
}

}
