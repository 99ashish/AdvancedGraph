package com.java.core;
import java.util.ArrayList;
import java.util.List;

import com.java.GenericUtility.*;
class GenericMinMaxClass<T extends Comparable<T> > implements GenericInterface<T> {

  T[] list;
  public GenericMinMaxClass(T[] o) {
	list  = o;
}
	@Override
	public T min() {
		
		T minValue = null;
		try{
		minValue = list[0];
		for(int i = 1; i < list.length; i++ ){
			if(list[i].compareTo(minValue) < 0)
				minValue = list[i];
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index out of bound");
		}
		return minValue;
	}

	@Override
	public T max() {
		T maxValue = null;
		try{
		maxValue = list[0];
		for(int i = 1; i < list.length; i++ ){
			if(list[i].compareTo(maxValue) > 0)
				maxValue = list[i];
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index out of bound");
		}
		return maxValue;
	}

}

class GenericMinMax{
	public static void main(String[] args) {
		
	    Integer []nums = {1,2,3,45,21};
	    String []str = {"sd","hfb","adb"};
	    Double []dbl = {};
		GenericMinMaxClass<Integer> intArray = new GenericMinMaxClass<>(nums);
		GenericMinMaxClass<String> strArray = new GenericMinMaxClass<>(str);
		GenericMinMaxClass<Double> dblArray = new GenericMinMaxClass<>(dbl);
		System.out.println(intArray.min());
		System.out.println(intArray.max());
		System.out.println(strArray.min());
		System.out.println(strArray.max());
		System.out.println(dblArray.min());
		System.out.println(dblArray.max());

	}
}
