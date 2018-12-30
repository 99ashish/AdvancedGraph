package com.java.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


interface Function<T>{
	boolean getData(T n);
	
}
interface CompareFunction<T>{
	boolean getData(T n1 , T n2);
	
}
interface BlockBodyClass<T>{
	void printArray(T[] list);
}
class Number1<T>{
	private int num;
	Number1(int num){ this.num = num;}
  boolean isGreater(Number1 n){ return num > n.num;}
  boolean isLesser(Number1 n){ return num < n.num;}
}
public class LamdaExpression {
	
	static <T> int lambdaExperssion(CompareFunction<T> str, T[] data, T compare)
	{
            int cnt = 0; 
            for(int i = 0; i < data.length; i++)
            {
            	if(str.getData(data[i], compare))
            		cnt++;
            }
            return cnt;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer> strFun;
		strFun = (n) ->(n%2)==0;
		System.out.println(strFun.getData(5));
		strFun = (n) ->(n>=0);
		String []str={"Ashish","Kumar","pandey"};
		BlockBodyClass<String> printStr;
		printStr=(list) -> {
			                   for(int i = 0; i < list.length; i++ )
			                   System.out.println(list[i]);
		                  }; 
		                  
		Integer []intData={1,2,3,4,4};
        BlockBodyClass<Integer> printInt;
		printInt=(list) -> {
		          			for(int i = 0; i < list.length; i++ )
		          			System.out.println(list[i]);
		          		    };
		System.out.println(strFun.getData(-2));
		//lambdaExperssion(printStr,str);
		//lambdaExperssion(printInt,intData);
		Number1[] numList = {new Number1(22),new Number1(233),new Number1(217)};
		
		int cnt=lambdaExperssion(Number1::isGreater, numList, new Number1(23));
		System.out.println(cnt);

	}

}
