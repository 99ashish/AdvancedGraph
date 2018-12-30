package com.java.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String value();
	int lifeSpan();	
}

 class Annotation {
	static int age;
	@MyAnno(value = "Define the Dog Age",lifeSpan=22)
	static void Age(int age)
	{
	age = 20;	
	Annotation d =new Annotation();
	Class<?> className = d.getClass();
	try {
		Method m = className.getDeclaredMethod( "Age",int.class);
		MyAnno annotation = m.getAnnotation(MyAnno.class);
		System.out.println(annotation.value() + "  " + annotation.lifeSpan());
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	


	public static void main(String[] args) {
		
		Age(20);
		// TODO Auto-generated method stub

	}

}
