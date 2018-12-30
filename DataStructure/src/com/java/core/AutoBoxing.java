package com.java.core;

public class AutoBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer obj =new Integer(100);
        int value=obj.intValue();
        System.out.println(value);
        
        /*
         * Beginning with JDK 5, Java added two important feature:
         * autoboxing and auto-unboxing.
         * Autoboxing is a process in which primitive types are automatic
         * boxed into its equivalent wrapper class. No need to explicitly
         * construct an object.
         * Auto-unboxing is a process in which value of the object automatically
         * extracted (unbox) from a type of wrapper class whenever its needed.  
         */
        Integer obj1 = 100;
        System.out.println(obj1);
        int obj2 = obj1;
        System.out.println(obj2);
	}

}
